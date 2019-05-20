package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.service.core.ReferenceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/reference-lists")
public class ReferenceListController extends BaseController<ReferenceListDto, ReferenceListService> {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceListController.class);

    @Autowired
    private ReferenceListService service;

    @Override
    protected ReferenceListService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
