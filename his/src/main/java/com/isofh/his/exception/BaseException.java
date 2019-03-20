package com.isofh.his.exception;

public class BaseException extends Exception {

    public BaseException(Throwable cause) {
        super(cause);
        this.code = 500;
    }

    public BaseException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
        this.code = 500;
    }

    private Integer code;
    private Object data = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
