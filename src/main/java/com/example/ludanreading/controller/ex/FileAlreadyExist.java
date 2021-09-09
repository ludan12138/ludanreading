package com.example.ludanreading.controller.ex;

public class FileAlreadyExist extends FileUploadException{
    public FileAlreadyExist() {
        super();
    }

    public FileAlreadyExist(String message) {
        super(message);
    }

    public FileAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public FileAlreadyExist(Throwable cause) {
        super(cause);
    }

    protected FileAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
