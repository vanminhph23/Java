package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.employee.AcademicRankDto;
import com.isofh.his.service.employee.AcademicRankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/academic-ranks")
public class AcademicRankController extends BaseCategoryController<AcademicRankDto, AcademicRankService> {

    private final static Logger logger = LoggerFactory.getLogger(AcademicRankController.class);

    @Autowired
    private AcademicRankService service;

    @Override
    protected AcademicRankService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
