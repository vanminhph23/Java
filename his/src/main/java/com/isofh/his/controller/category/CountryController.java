package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.CountryDto;
import com.isofh.his.service.category.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/countries")
public class CountryController extends BaseCategoryController<CountryDto, CountryService> {

    private final static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService service;

    @Override
    protected CountryService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
