package com.lan.app.btvn.exception;

public class AppException extends RuntimeException{
    private final int errorCode;

    public AppException(final int errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
