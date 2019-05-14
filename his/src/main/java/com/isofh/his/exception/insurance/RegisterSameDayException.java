package com.isofh.his.exception.insurance;

import com.isofh.his.exception.BaseException;

public class RegisterSameDayException extends BaseException {

    private final static int ERROR_CODE = 3100;

    public RegisterSameDayException(String message) {
        super(ERROR_CODE, message);
    }

    public RegisterSameDayException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public RegisterSameDayException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
