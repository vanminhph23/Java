package com.isofh.his.exception.patient;

import com.isofh.his.exception.BaseException;

public class InsuranceNumberNotPaidException extends BaseException {

    private final static int ERROR_CODE = 2002;

    public InsuranceNumberNotPaidException(String message) {
        super(ERROR_CODE, message);
    }

    public InsuranceNumberNotPaidException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public InsuranceNumberNotPaidException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
