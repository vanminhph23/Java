package com.isofh.his.controller.patient;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.patient.info.PatientHistoryDto;
import com.isofh.his.exception.data.NotFoundException;
import com.isofh.his.insurance.card.model.BenhNhan;
import com.isofh.his.insurance.card.model.TheBH;
import com.isofh.his.insurance.card.service.InsuranceCardPortalService;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.service.patient.info.PatientHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/patient-histories")
public class PatientHistoryController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryController.class);

    @Autowired
    private PatientHistoryService service;

    @Autowired
    private InsuranceCardPortalService insuranceCardPortalService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        PatientHistoryDto ph = service.findDtoById(id);

        return response(ph);
    }

    @GetMapping("/id-no/{idNo}")
    public ResponseEntity<ResponseMsg> getByIdNo(@PathVariable String idNo) {

        PatientHistory ph = service.findLastByIdNo(idNo);

        if (ph == null) {
            throw new NotFoundException("Not found patient idNo: " + idNo);
        }

        PatientHistoryDto dto = service.getDto(ph);

        return response(dto);
    }

    @GetMapping("/patient-value/{patientValue}")
    public ResponseEntity<ResponseMsg> getByPatientValue(@PathVariable String patientValue) {

        PatientHistory ph = service.findLastByPatientValue(patientValue);

        if (ph == null) {
            throw new NotFoundException("Not found patient value: " + patientValue);
        }

        PatientHistoryDto dto = service.getDto(ph);

        return response(dto);
    }

    @PostMapping("/insurance-card")
    public ResponseEntity<ResponseMsg> getPatientInsuranceCard(@Valid @RequestBody BenhNhan bn) {
        TheBH bh = insuranceCardPortalService.getPatientInsuranceCard(bn);

        return response(bh);
    }

    @PostMapping
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody PatientHistoryDto dto) {
        PatientHistoryDto ph = service.createDto(dto);
        return response(ph);
    }

    @PutMapping
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody PatientHistoryDto dto) {
        PatientHistoryDto ph = service.updateDto(dto);

        return response(ph);
    }

    @PostMapping("/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        String responseStr = service.importExcel(file, 1, 1);

        return response(responseStr);
    }
}
;