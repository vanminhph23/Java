package com.isofh.his.exception.insurance;

import com.isofh.his.exception.BaseException;

public class InsurancePortalException extends BaseException {

    private final static int ERROR_CODE = 3001;

    public InsurancePortalException(String message) {
        super(ERROR_CODE, message);
    }

    public InsurancePortalException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public InsurancePortalException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
