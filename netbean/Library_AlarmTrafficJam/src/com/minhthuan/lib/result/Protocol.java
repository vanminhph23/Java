package com.minhthuan.lib.result;

import com.google.gson.Gson;
import com.minhthuan.lib.user.User;

/**
 * Created by vanmi on 10/19/2015.
 */
public class Protocol {

    public enum Type {

        LOGIN,
        SIGUP,
        ADD_MARKER,
        GET_MARKER,
        UPDATESETTING,
        UPDATE_AVATAR
    }

    private Type type;
    private String object;
    private String user;

    public Protocol(Type type, Object object, User user) {
        this.type = type;
        this.object = new Gson().toJson(object);
        this.user = new Gson().toJson(user);
    }

    public Type getType() {
        return type;
    }

    public String getObject() {
        return object;
    }

    public String getUser() {
        return user;
    }

}
