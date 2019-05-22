package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.service.employee.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController extends BaseCategoryController<UserDto, UserService> {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;

    @Override
    protected UserService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
