package com.isofh.his.exception.storage;

import com.isofh.his.exception.BaseException;

public class StorageFileNotFoundException extends BaseException {

    private final static int ERROR_CODE = 502;

    public StorageFileNotFoundException(String message) {
        super(ERROR_CODE, message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(ERROR_CODE, message, cause);
    }
}
