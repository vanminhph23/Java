package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.ReportTemplateDto;
import com.isofh.his.service.category.ReportTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/report-templates")
public class ReportTemplateController extends BaseCategoryController<ReportTemplateDto, ReportTemplateService> {

    private final static Logger logger = LoggerFactory.getLogger(ReportTemplateController.class);

    @Autowired
    private ReportTemplateService service;

    @Override
    protected ReportTemplateService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}