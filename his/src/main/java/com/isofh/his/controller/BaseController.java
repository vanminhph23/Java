package com.isofh.his.controller;

import com.isofh.his.exception.BaseException;
import com.isofh.his.model.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    protected ResponseEntity response(int code, String message, Map<String, Object> data) {
        return new ResponseEntity(new ResponseMsg(code, message, data), HttpStatus.OK);
    }

    protected ResponseEntity response(Exception ex) {
        return new ResponseEntity(ResponseMsg.get(ex), HttpStatus.OK);
    }

    protected ResponseEntity response(int code, String message, List<String> keys, List<Object> values) throws BaseException {
        int keySize = keys.size();
        int valueSize = values.size();

        if (keySize != valueSize) {
            throw new BaseException("Keys and values must be the same size");
        }

        Map<String, Object> data = new HashMap<>();
        for (int i = 0; i < keySize; i++) {
            data.put(keys.get(i), values.get(i));
        }

        return response(code, message, data);
    }

    protected ResponseEntity response(int code, String message, String key, Object value) {
        Map<String, Object> data = new HashMap<>();
        data.put(key, value);

        return response(code, message, data);
    }

    protected ResponseEntity response(String key, Object value) {
        return response(null, key, value);
    }

    protected ResponseEntity response(String message, String key, Object value) {
        return response(0, message, key, value);
    }

    protected ResponseEntity response(int code, String message) {
        return response(code, message, null);
    }
}
