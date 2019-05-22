package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.DiseaseDto;
import com.isofh.his.service.category.DiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/diseases")
public class DiseaseController extends BaseCategoryController<DiseaseDto, DiseaseService> {

    private final static Logger logger = LoggerFactory.getLogger(DiseaseController.class);

    @Autowired
    private DiseaseService service;

    @Override
    protected DiseaseService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
