package cn.tedu.jsdvn2203.csmall.server.web;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import lombok.Data;
/**
 * Controller的返回结果
 */
@Data
public class JsonResult{

    /**
     * 业务状态码
     */
    private Integer code;

    /**
     * 错误时的信息
     */
    private String message;

    /**
     * 处理成功时，需要响应到客户端的数据
     */
    private Object data;

    /**
     * 响应成功(不带有数据)
     */
    public static JsonResult ok(){
        return ok(null);
    }

    /**
     * 响应成功(带有数据)
     */
    public static JsonResult ok(Object data){
        JsonResult result = new JsonResult();
        result.setCode(ServiceCode.OK);
        result.setData(data);
        return result;
    }


    /**
     * 响应错误信息
     */
    public static JsonResult fail(ServiceException e){

        return fail(e.getServiceCode(), e.getMessage());
    }

    /**
     * 创建并返回JsonResult对象
     * @param code 业务状态码
     * @param message 错误时的信息
     * @return JsonResult对象
     */
    public static JsonResult fail(Integer code,String message){
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
