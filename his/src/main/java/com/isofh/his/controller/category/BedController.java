package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.BedDto;
import com.isofh.his.service.category.BedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/beds")
public class BedController extends BaseCategoryController<BedDto, BedService> {

    private final static Logger logger = LoggerFactory.getLogger(BedController.class);

    @Autowired
    private BedService service;

    @Override
    protected BedService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
