package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.service.category.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController extends BaseCategoryController<DepartmentDto, DepartmentService> {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService service;

    @Override
    protected DepartmentService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
