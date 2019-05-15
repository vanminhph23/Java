package com.isofh.his.exception.patient;

import com.isofh.his.exception.BaseException;

public class PatientNotPaidException extends BaseException {

    private final static int ERROR_CODE = 2001;

    public PatientNotPaidException(String message) {
        super(ERROR_CODE, message);
    }

    public PatientNotPaidException(String message, Object data) {
        super(ERROR_CODE, message, data);
    }

    public PatientNotPaidException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
