package com.isofh.his.exception.insurance;

import com.isofh.his.exception.BaseException;

public class TakeTokenException extends BaseException {

    private final static int ERROR_CODE = 3000;

    public TakeTokenException(String message) {
        super(ERROR_CODE, message);
    }

    public TakeTokenException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public TakeTokenException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
