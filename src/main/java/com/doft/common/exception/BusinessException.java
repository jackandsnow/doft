package com.doft.common.exception;

/**
 * Created by Jack at 14:30 2018/3/9
 * version 1.0
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException() {
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(Throwable cause)
    {
        super(cause);
    }

    public BusinessException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
