package com.isofh.his.controller.patient;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.patient.info.PatientHistoryDto;
import com.isofh.his.exception.data.NotFoundException;
import com.isofh.his.insurance.card.model.BenhNhan;
import com.isofh.his.insurance.card.model.TheBH;
import com.isofh.his.insurance.card.service.InsuranceCardPortalService;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.patient.info.PatientHistoryService;
import com.isofh.his.service.patient.invoice.PatientInvoiceLineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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