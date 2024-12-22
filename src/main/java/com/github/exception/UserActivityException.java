package com.github.exception;

public class UserActivityException extends RuntimeException {
    public UserActivityException(String message) {
        super(message);
    }

    public UserActivityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserActivityException(Throwable cause) {
        super(cause);
    }

    public UserActivityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
