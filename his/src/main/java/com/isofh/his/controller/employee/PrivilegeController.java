package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.service.employee.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/privileges")
public class PrivilegeController extends BaseCategoryController<PrivilegeDto, PrivilegeService> {

    private final static Logger logger = LoggerFactory.getLogger(PrivilegeController.class);

    @Autowired
    private PrivilegeService service;

    @Override
    protected PrivilegeService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
