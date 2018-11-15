package com.bbs.exception;

/**
 * @author liuqiangsheng
 */
public class BusinessRunException extends Exception {
    /**
     * 业务处理层异常
     *
     * @param msg 异常信息
     */
    public BusinessRunException(String msg) {
        super(msg);
    }

    /**
     * 业务处理层异常
     *
     * @param t 异常堆栈
     */
    public BusinessRunException(Throwable t) {
        super(t);
    }
}