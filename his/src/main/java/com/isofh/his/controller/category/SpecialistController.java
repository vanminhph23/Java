package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.SpecialistDto;
import com.isofh.his.service.category.SpecialistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/specialists")
public class SpecialistController extends BaseCategoryController<SpecialistDto, SpecialistService> {

    private final static Logger logger = LoggerFactory.getLogger(SpecialistController.class);

    @Autowired
    private SpecialistService service;

    @Override
    protected SpecialistService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
