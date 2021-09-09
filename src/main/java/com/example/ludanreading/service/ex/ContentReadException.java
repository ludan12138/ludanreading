package com.example.ludanreading.service.ex;

public class ContentReadException extends ServiceException{
    public ContentReadException() {
        super();
    }

    public ContentReadException(String message) {
        super(message);
    }

    public ContentReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentReadException(Throwable cause) {
        super(cause);
    }

    protected ContentReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
