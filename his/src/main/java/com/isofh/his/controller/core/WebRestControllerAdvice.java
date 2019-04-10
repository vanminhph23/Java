package com.isofh.his.controller.core;

import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class WebRestControllerAdvice {

    private final static Logger logger = LoggerFactory.getLogger(WebRestControllerAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseMsg handleBaseException(Exception ex) {
        return ResponseMsg.get(ex);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseMsg handleNoHandlerFoundException(Exception ex) {
        return ResponseMsg.get(new BaseException(404, ex));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseMsg handleBadCredentialsException() {
        return ResponseMsg.get(new BaseException(1, "Invalid username or password."));
    }
}