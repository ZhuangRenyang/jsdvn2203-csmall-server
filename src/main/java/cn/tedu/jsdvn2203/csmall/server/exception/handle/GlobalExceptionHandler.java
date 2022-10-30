package cn.tedu.jsdvn2203.csmall.server.exception.handle;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

/*
 *统一异常处理类
 */
//@ResponseBody
//@ControllerAdvice
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理业务异常
     *
     * @param e 业务异常
     * @return 异常信息
     */
    @ExceptionHandler
    public JsonResult handleServiceException(ServiceException e) {
        return JsonResult.fail(e);
    }

    @ExceptionHandler
    public JsonResult handleServiceException(BindException e) {
//        String message = e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        //提示：多个错误
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        StringBuilder builder = new StringBuilder();
//        for (FieldError fieldError:fieldErrors) {
//            builder.append(fieldError.getDefaultMessage());
//            builder.append("; ");
//        }
//        StringJoiner joiner = new StringJoiner("; ","[前缀]","[后缀]");
        StringJoiner joiner = new StringJoiner("; ", "错误信息：", "。");
        for (FieldError fieldError : fieldErrors) {
            joiner.add(fieldError.getDefaultMessage());
        }

        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST, joiner.toString());
    }

    @ExceptionHandler
    public JsonResult handleThrowable(Throwable e) {
        log.error("统一处理未明确的异常:{},错误信息:{}", e.getClass().getName(), e.getMessage());
        String message = "服务器繁忙,请稍后重试";
        return JsonResult.fail(ServiceCode.ERR_UNKNOWN, message);
    }
}
