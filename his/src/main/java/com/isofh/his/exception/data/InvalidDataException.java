package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class InvalidDataException extends BaseException {

    private final static int ERROR_CODE = 1100;

    public InvalidDataException(String message) {
        super(ERROR_CODE, "Invalid data: " + message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(ERROR_CODE, "Invalid data: " + message, cause);
    }
}
