package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.CertificateDto;
import com.isofh.his.service.employee.CertificateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class CertificateController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(CertificateController.class);

    @Autowired
    private CertificateService service;

    @GetMapping("/certificates/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("certificate", service.findDtoById(id));
    }

    @PostMapping("/certificates")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody CertificateDto dto) {
        return response("certificate", service.saveDto(dto));
    }

    @PutMapping("/certificates")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody CertificateDto dto) {
        return response("certificate", service.saveDto(dto));
    }

    @PostMapping("/certificates/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
