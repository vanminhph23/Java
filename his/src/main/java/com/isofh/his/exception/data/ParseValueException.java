package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class ParseValueException extends BaseException {

    private final static int ERROR_CODE = 1200;

    public ParseValueException(String message) {
        super(ERROR_CODE, message);
    }

    public ParseValueException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
