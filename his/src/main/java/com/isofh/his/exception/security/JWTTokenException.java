package com.isofh.his.exception.security;

import com.isofh.his.exception.BaseException;

public class JWTTokenException extends BaseException {

    private final static int ERROR_CODE = 1000;

    public JWTTokenException(String message) {
        super(ERROR_CODE, message);
    }

    public JWTTokenException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
