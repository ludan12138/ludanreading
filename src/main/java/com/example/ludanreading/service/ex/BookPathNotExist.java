package com.example.ludanreading.service.ex;

public class BookPathNotExist extends ServiceException{
    public BookPathNotExist() {
        super();
    }

    public BookPathNotExist(String message) {
        super(message);
    }

    public BookPathNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public BookPathNotExist(Throwable cause) {
        super(cause);
    }

    protected BookPathNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
