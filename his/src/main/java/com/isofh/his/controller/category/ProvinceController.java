package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.service.category.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/provinces")
public class ProvinceController extends BaseCategoryController<ProvinceDto, ProvinceService> {

    private final static Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    @Autowired
    private ProvinceService service;

    @Override
    protected ProvinceService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
