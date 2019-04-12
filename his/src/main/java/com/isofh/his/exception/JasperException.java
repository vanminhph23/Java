package com.isofh.his.exception;

public class JasperException extends BaseException {

    private final static int ERROR_CODE = 504;

    public JasperException(String message) {
        super(ERROR_CODE, message);
    }

    public JasperException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
