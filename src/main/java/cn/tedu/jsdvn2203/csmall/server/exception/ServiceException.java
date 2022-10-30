package cn.tedu.jsdvn2203.csmall.server.exception;


/**
 * 业务异常
 *  检查型异常类 - 继承Exception
 *  运行时异常类 - 继承RuntimeException
 */
public class ServiceException extends RuntimeException{

    private Integer serviceCode;

    public ServiceException(Integer serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
     }

    public Integer getServiceCode() {
        return serviceCode;
    }
}
