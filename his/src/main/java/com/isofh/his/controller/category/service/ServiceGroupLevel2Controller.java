package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.service.ServiceGroupLevel2Dto;
import com.isofh.his.service.category.service.ServiceGroupLevel2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/service-group-level2s")
public class ServiceGroupLevel2Controller extends BaseCategoryController<ServiceGroupLevel2Dto, ServiceGroupLevel2Service> {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel2Controller.class);

    @Autowired
    private ServiceGroupLevel2Service service;

    @Override
    protected ServiceGroupLevel2Service getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
