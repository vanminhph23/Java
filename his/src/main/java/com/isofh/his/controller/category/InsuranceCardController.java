package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.InsuranceCardDto;
import com.isofh.his.service.category.InsuranceCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/insurance-cards")
public class InsuranceCardController extends BaseCategoryController<InsuranceCardDto, InsuranceCardService> {

    private final static Logger logger = LoggerFactory.getLogger(InsuranceCardController.class);

    @Autowired
    private InsuranceCardService service;

    @Override
    protected InsuranceCardService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
