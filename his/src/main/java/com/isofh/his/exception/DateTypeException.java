package com.isofh.his.exception;

public class DateTypeException extends BaseException {

    private final static int ERROR_CODE = 1201;

    public DateTypeException(String message) {
        super(ERROR_CODE, message);
    }

    public DateTypeException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
