package com.isofh.his.controller.base;

import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.exception.storage.StorageFileNotFoundException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public abstract class BaseResponseController {

    protected abstract Logger getLogger();

    protected ResponseEntity response(int code, String message, Object data) {
        return new ResponseEntity(new ResponseMsg(code, message, data), HttpStatus.OK);
    }

    protected ResponseEntity response(String fileName) {
        try {
            File file = new File(fileName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=" + file.getName());

            return new ResponseEntity(new InputStreamResource(new ByteArrayInputStream(FileUtils.readFileToByteArray(file))), headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new StorageFileNotFoundException("Could not read file: " + fileName);
        }
    }

    protected ResponseEntity response(String message, Object data) {
        return response(0, message , data);
    }

    protected ResponseEntity response(Object data) {
        return response(null, data);
    }

    protected ResponseEntity response(Exception ex) {
        return new ResponseEntity(new ResponseMsg(ex), HttpStatus.OK);
    }

    protected ResponseEntity response(int code, String message) {
        return response(code, message, null);
    }
}
