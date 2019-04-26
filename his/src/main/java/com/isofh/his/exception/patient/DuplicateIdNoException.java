package com.isofh.his.exception.patient;

import com.isofh.his.exception.BaseException;

public class DuplicateIdNoException extends BaseException {

    private final static int ERROR_CODE = 2000;

    public DuplicateIdNoException(String message) {
        super(ERROR_CODE, message);
    }

    public DuplicateIdNoException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
