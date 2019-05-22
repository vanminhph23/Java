package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseCategoryController;
import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.service.employee.CertificateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/certificates")
public class CertificateController extends BaseCategoryController<CertificateDto, CertificateService> {

    private final static Logger logger = LoggerFactory.getLogger(CertificateController.class);

    @Autowired
    private CertificateService service;

    @Override
    protected CertificateService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}
