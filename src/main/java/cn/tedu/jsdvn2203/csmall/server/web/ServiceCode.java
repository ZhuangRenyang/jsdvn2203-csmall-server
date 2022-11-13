package cn.tedu.jsdvn2203.csmall.server.web;

import com.sun.org.apache.bcel.internal.generic.PUSH;

public class ServiceCode {

    /**
     * 成功
     */
    public static final int OK = 20000;

    public static final int ERR_BAD_REQUEST = 40000;


    /*
     *错误: JWT 数据错误可能被恶意篡改
     */
    public static final int ERR_JWT_INVALID = 40001;

    /*
     *错误: JWT过期
     */
    public static final int ERR_JWT_EXPIRED = 40300;

    /*
     *错误: 数据不存在
     */
    public static final int ERR_NOT_FOUND = 40400;

    /**
     * 错误：冲突 - 重复数据
     */
    public static final int ERR_CONFLICT = 40900;

    /**
     * 错误：插入失败
     */
    public static final int ERR_INSERT=50000;

    /**
     * 错误：删除失败
     */
    public static final int ERR_DELETE = 50001;

    /**
     * 错误：修改失败
     */
    public static final int ERR_UPDATE = 50002;

    /**
     * 错误：未处理的异常
     */
    public static final int ERR_UNKNOWN = 59999;
}
