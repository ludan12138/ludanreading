package com.example.ludanreading.service.ex;

public class AvatarNotFound extends ServiceException{
    public AvatarNotFound() {
        super();
    }

    public AvatarNotFound(String message) {
        super(message);
    }

    public AvatarNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AvatarNotFound(Throwable cause) {
        super(cause);
    }

    protected AvatarNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
