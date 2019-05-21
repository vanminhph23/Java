package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.ResultTemplateDto;
import com.isofh.his.service.category.ResultTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/result-templates")
public class ResultTemplateController extends BaseCategoryController<ResultTemplateDto, ResultTemplateService> {

    private final static Logger logger = LoggerFactory.getLogger(ResultTemplateController.class);

    @Autowired
    private ResultTemplateService service;

    @Override
    protected ResultTemplateService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}