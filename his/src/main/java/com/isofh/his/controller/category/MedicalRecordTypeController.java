package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.MedicalRecordTypeDto;
import com.isofh.his.service.category.MedicalRecordTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class MedicalRecordTypeController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(MedicalRecordTypeController.class);

    @Autowired
    private MedicalRecordTypeService service;

    @GetMapping("/medical-record-types/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("medicalRecordType", service.getAndTransfer(id));
    }

    @PostMapping("/medical-record-types")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody MedicalRecordTypeDto dto) {
        return response("medicalRecordType", service.saveAndTransfer(dto));
    }

    @PutMapping("/medical-record-types")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody MedicalRecordTypeDto dto) {
        return response("medicalRecordType", service.saveAndTransfer(dto));
    }

    @PostMapping("/medical-record-types/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
