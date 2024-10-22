package com.itacademy.hackaton.application.exceptions;

public class DistrictRetrievalException extends RuntimeException{
    public DistrictRetrievalException() {
        super();
    }

    public DistrictRetrievalException(String message) {
        super(message);
    }

    public DistrictRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DistrictRetrievalException(Throwable cause) {
        super(cause);
    }

    protected DistrictRetrievalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
