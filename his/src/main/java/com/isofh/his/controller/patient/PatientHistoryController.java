package com.isofh.his.controller.patient;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.service.patient.PatientHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class PatientHistoryController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryController.class);

    @Autowired
    private PatientHistoryService service;

    @GetMapping("/patient-histories/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("patientHistory", service.findDtoById(id));
    }

    @PostMapping("/patient-histories")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody PatientHistoryDto dto) {
        Long historyId = service.create(dto);
        PatientHistoryDto ph = service.findDtoById(historyId);

        return response("patientHistory", ph);
    }

    @PutMapping("/patient-histories")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody PatientHistoryDto dto) {
        PatientHistory ph = service.update(dto);
        return response("patientHistory", service.getDto(ph));
    }

    @PostMapping("/patient-histories/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
