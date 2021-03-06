package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.service.ServiceGroupLevel3Dto;
import com.isofh.his.service.category.service.ServiceGroupLevel3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/service-group-level3s")
public class ServiceGroupLevel3Controller extends BaseCategoryController<ServiceGroupLevel3Dto, ServiceGroupLevel3Service> {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel3Controller.class);

    @Autowired
    private ServiceGroupLevel3Service service;

    @Override
    protected ServiceGroupLevel3Service getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
