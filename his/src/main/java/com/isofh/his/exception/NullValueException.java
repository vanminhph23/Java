package com.isofh.his.exception;

public class NullValueException extends BaseException {

    private final static int ERROR_CODE = 1102;

    public NullValueException(String message) {
        super(ERROR_CODE, message);
    }

    public NullValueException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
