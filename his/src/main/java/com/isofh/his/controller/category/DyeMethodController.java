package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.category.DyeMethodDto;
import com.isofh.his.service.category.DyeMethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dye-methods")
public class DyeMethodController extends BaseCategoryController<DyeMethodDto, DyeMethodService> {

    private final static Logger logger = LoggerFactory.getLogger(DyeMethodController.class);

    @Autowired
    private DyeMethodService service;

    @Override
    protected DyeMethodService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}