package com.isofh.his.controller.patient;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.patient.invoice.PatientInvoiceLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/patient-invoice-lines")
public class PatientInvoiceLineController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PatientInvoiceLineController.class);

    @Autowired
    private PatientInvoiceLineService service;

    @Override
    protected BaseService getService() {
        return this.service;
    }

    @Override
    protected Logger getLogger() {
        return this.logger;
    }
}