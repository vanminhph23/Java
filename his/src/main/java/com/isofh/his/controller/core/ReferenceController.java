package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.service.core.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/references")
public class ReferenceController extends BaseCategoryController<ReferenceDto, ReferenceService> {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceController.class);

    @Autowired
    private ReferenceService service;

    @Override
    protected ReferenceService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
