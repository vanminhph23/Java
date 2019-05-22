package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.UOMDto;
import com.isofh.his.service.category.UOMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/uoms")
public class UOMController extends BaseCategoryController<UOMDto, UOMService> {

    private final static Logger logger = LoggerFactory.getLogger(UOMController.class);

    @Autowired
    private UOMService service;

    @Override
    protected UOMService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}