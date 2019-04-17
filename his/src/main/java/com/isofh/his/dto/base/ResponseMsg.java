package com.isofh.his.dto.base;


import com.isofh.his.exception.BaseException;

public class ResponseMsg {

    private Integer code = 0;
    private String message = null;
    private Object data = null;

    public ResponseMsg() {
    }

    public ResponseMsg(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseMsg(Integer code, String message) {
        this(code, message, null);
    }

    public ResponseMsg(Exception ex) {
        this();

        message = ex.getMessage();

        Throwable cause = ex.getCause();
        if (cause != null) {
            message += "(" + cause.getMessage() + ")";
        }

        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            data = baseException.getData();
            code = baseException.getCode();
        } else {
            code = 500;
            message = "Internal Server Error: " + message;
            ex.printStackTrace();
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}