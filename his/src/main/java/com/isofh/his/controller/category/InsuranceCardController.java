package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.InsuranceCardDto;
import com.isofh.his.service.category.InsuranceCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/insurance-cards")
public class InsuranceCardController extends BaseCategoryController<InsuranceCardDto, InsuranceCardService> {

    private final static Logger logger = LoggerFactory.getLogger(InsuranceCardController.class);

    @Autowired
    private InsuranceCardService service;


    @Override
    protected InsuranceCardService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
