package com.intellect.book.base.mapper.weekend.reflection;


/**
 * <p> </p>
 *
 * @author huijun
 * @create 2018-11-23 12:56:25
 **/
public class ReflectionOperationException extends RuntimeException {
    public ReflectionOperationException() {
    }

    public ReflectionOperationException(String message) {
        super(message);
    }

    public ReflectionOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionOperationException(Throwable cause) {
        super(cause);
    }

    public ReflectionOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
