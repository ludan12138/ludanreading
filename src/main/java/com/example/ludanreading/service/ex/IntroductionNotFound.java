package com.example.ludanreading.service.ex;

public class IntroductionNotFound extends ServiceException{
    public IntroductionNotFound() {
        super();
    }

    public IntroductionNotFound(String message) {
        super(message);
    }

    public IntroductionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public IntroductionNotFound(Throwable cause) {
        super(cause);
    }

    protected IntroductionNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
