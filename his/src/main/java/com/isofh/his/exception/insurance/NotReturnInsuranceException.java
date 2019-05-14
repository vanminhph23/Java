package com.isofh.his.exception.insurance;

import com.isofh.his.exception.BaseException;

public class NotReturnInsuranceException extends BaseException {

    private final static int ERROR_CODE = 3101;

    public NotReturnInsuranceException(String message) {
        super(ERROR_CODE, message);
    }

    public NotReturnInsuranceException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public NotReturnInsuranceException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
