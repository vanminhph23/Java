package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.EthnicityDto;
import com.isofh.his.service.category.EthnicityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/ethnicities")
public class EthnicityController extends BaseCategoryController<EthnicityDto, EthnicityService> {

    private final static Logger logger = LoggerFactory.getLogger(EthnicityController.class);

    @Autowired
    private EthnicityService service;

    @Override
    protected EthnicityService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
