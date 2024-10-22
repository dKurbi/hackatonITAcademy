package com.itacademy.hackaton.exception;

public class NoDistrictFoundException extends RuntimeException{

    public NoDistrictFoundException() {
        super();
    }

    public NoDistrictFoundException(String message) {
        super(message);
    }

    public NoDistrictFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDistrictFoundException(Throwable cause) {
        super(cause);
    }

    protected NoDistrictFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
