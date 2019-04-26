package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class NotFoundException extends BaseException {

    private final static int ERROR_CODE = 1104;

    public NotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
