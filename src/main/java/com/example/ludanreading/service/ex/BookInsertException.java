package com.example.ludanreading.service.ex;

public class BookInsertException extends ServiceException{
    public BookInsertException() {
        super();
    }

    public BookInsertException(String message) {
        super(message);
    }

    public BookInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookInsertException(Throwable cause) {
        super(cause);
    }

    protected BookInsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
