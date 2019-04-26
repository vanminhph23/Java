package com.isofh.his.exception.data;

import com.isofh.his.exception.BaseException;

public class DuplicateNameException extends BaseException {

    private final static int ERROR_CODE = 1102;

    public DuplicateNameException(String message) {
        super(ERROR_CODE, message);
    }

    public DuplicateNameException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
