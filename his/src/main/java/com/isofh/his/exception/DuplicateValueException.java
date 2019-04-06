package com.isofh.his.exception;

public class DuplicateValueException extends BaseException {

    private final static int ERROR_CODE = 1000;

    public DuplicateValueException(String message) {
        super(ERROR_CODE, message);
    }

    public DuplicateValueException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
