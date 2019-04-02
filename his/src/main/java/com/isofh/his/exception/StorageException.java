package com.isofh.his.exception;

public class StorageException extends BaseException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(400, message, cause);
    }
}
