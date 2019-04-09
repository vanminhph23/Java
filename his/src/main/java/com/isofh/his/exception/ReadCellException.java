package com.isofh.his.exception;

public class ReadCellException extends BaseException {

    private final static int ERROR_CODE = 503;

    public ReadCellException(String message) {
        super(ERROR_CODE, message);
    }

    public ReadCellException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
