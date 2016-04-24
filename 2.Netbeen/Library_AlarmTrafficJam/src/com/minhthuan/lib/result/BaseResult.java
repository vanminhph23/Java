package com.minhthuan.lib.result;

import com.google.gson.Gson;

/**
 * Created by sev_user on 10/19/15.
 */
public class BaseResult {
    private Protocol.Type type;
    private int result;
    private String reason;
    private String object;

    public BaseResult(Protocol.Type type, int result, Object object, String reason) {
        this.type = type;
        this.result = result;
        this.reason = reason;
        this.object = new Gson().toJson(object);
    }

    public Protocol.Type getType() {
        return type;
    }

    public void setType(Protocol.Type type) {
        this.type = type;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = new Gson().toJson(object);
    }
    
    
}
