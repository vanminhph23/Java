package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class DataTypeException extends BaseException {

    private final static int ERROR_CODE = 1201;

    public DataTypeException(String message) {
        super(ERROR_CODE, message);
    }

    public DataTypeException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
