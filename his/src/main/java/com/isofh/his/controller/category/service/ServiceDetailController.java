package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.category.service.ServiceDetailDto;
import com.isofh.his.service.category.service.ServiceDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/service-detail")
public class ServiceDetailController extends BaseController<ServiceDetailDto, ServiceDetailService> {

    private final static Logger logger = LoggerFactory.getLogger(ServiceDetailController.class);

    @Autowired
    private ServiceDetailService service;

    @Override
    protected ServiceDetailService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
