package com.isofh.his.model;


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

    public static ResponseMsg get(Exception ex) {
        int code = 500;
        String message = ex.getMessage();
        Object data = null;
        if (ex instanceof BaseException) {
            BaseException baseException = (BaseException) ex;
            data = baseException.getData();
            code = baseException.getCode();
        } else {
            message = "Internal Server Error: " + message;
        }

        return new ResponseMsg(code, message, data);
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