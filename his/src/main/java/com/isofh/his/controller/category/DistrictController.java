package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.DistrictDto;
import com.isofh.his.service.category.DistrictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/districts")
public class DistrictController extends BaseCategoryController<DistrictDto, DistrictService> {

    private final static Logger logger = LoggerFactory.getLogger(DistrictController.class);

    @Autowired
    private DistrictService service;

    @Override
    protected DistrictService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
