package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.MedicalRecordTypeDto;
import com.isofh.his.service.category.MedicalRecordTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/medical-record-types")
public class MedicalRecordTypeController extends BaseCategoryController<MedicalRecordTypeDto, MedicalRecordTypeService> {

    private final static Logger logger = LoggerFactory.getLogger(MedicalRecordTypeController.class);

    @Autowired
    private MedicalRecordTypeService service;

    @Override
    protected MedicalRecordTypeService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
