package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.EthnicityDto;
import com.isofh.his.service.category.EthnicityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ethnicities")
public class EthnicityController extends BaseCategoryController<EthnicityDto, EthnicityService> {

    private final static Logger logger = LoggerFactory.getLogger(EthnicityController.class);

    @Autowired
    private EthnicityService service;

    @Override
    protected EthnicityService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
