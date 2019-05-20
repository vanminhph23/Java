package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.service.ServiceGroupLevel1Dto;
import com.isofh.his.dto.category.service.ServiceTechnicalDto;
import com.isofh.his.service.base.BaseCategoryService;
import com.isofh.his.service.category.service.ServiceTechnicalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/service-technical")
public class ServiceTechnicalController extends BaseController<ServiceTechnicalDto, ServiceTechnicalService> {

    private final static Logger logger = LoggerFactory.getLogger(ServiceTechnicalController.class);

    @Autowired
    private ServiceTechnicalService service;

    @Override
    protected ServiceTechnicalService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
