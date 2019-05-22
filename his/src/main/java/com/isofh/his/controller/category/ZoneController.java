package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.ZoneDto;
import com.isofh.his.service.category.ZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/zones")
public class ZoneController extends BaseCategoryController<ZoneDto, ZoneService> {

    private final static Logger logger = LoggerFactory.getLogger(ZoneController.class);

    @Autowired
    private ZoneService service;

    @Override
    protected ZoneService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
