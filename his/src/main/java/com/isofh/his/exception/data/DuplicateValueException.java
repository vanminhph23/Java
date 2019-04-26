package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class DuplicateValueException extends BaseException {

    private final static int ERROR_CODE = 1101;

    public DuplicateValueException(String message) {
        super(ERROR_CODE, message);
    }

    public DuplicateValueException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
