package com.isofh.his.exception.storage;

import com.isofh.his.exception.BaseException;

public class StorageException extends BaseException {

    private final static int ERROR_CODE = 501;

    public StorageException(String message) {
        super(ERROR_CODE, message);
    }

    public StorageException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
