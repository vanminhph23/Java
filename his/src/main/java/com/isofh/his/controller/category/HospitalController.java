package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.HospitalDto;
import com.isofh.his.service.category.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hospitals")
public class HospitalController extends BaseCategoryController<HospitalDto, HospitalService> {

    private final static Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService service;

    @Override
    protected HospitalService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
