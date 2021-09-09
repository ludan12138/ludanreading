package com.example.ludanreading.service.ex;

public class AuthorNotFound extends ServiceException{
    public AuthorNotFound() {
        super();
    }

    public AuthorNotFound(String message) {
        super(message);
    }

    public AuthorNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorNotFound(Throwable cause) {
        super(cause);
    }

    protected AuthorNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
