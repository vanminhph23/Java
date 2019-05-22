package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.BuildingDto;
import com.isofh.his.service.category.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/buildings")
public class BuildingController extends BaseCategoryController<BuildingDto, BuildingService> {

    private final static Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingService service;

    @Override
    protected BuildingService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
