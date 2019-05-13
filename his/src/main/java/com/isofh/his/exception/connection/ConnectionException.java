package com.isofh.his.exception.connection;

import com.isofh.his.exception.BaseException;

public class ConnectionException extends BaseException {

    private final static int ERROR_CODE = 2000;

    public ConnectionException(String message) {
        super(ERROR_CODE, message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
