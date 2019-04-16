package com.isofh.his.exception;

public class DuplicateNameException extends BaseException {

    private final static int ERROR_CODE = 1101;

    public DuplicateNameException(String message) {
        super(ERROR_CODE, message);
    }

    public DuplicateNameException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
