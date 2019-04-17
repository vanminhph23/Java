package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.HospitalDto;
import com.isofh.his.service.category.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class HospitalController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService service;

    @GetMapping("/hospitals/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("hospital", service.getAndTransfer(id));
    }

    @PostMapping("/hospitals")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody HospitalDto dto) {
        return response("hospital", service.saveAndTransfer(dto));
    }

    @PutMapping("/hospitals")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody HospitalDto dto) {
        return response("hospital", service.saveAndTransfer(dto));
    }

    @PostMapping("/hospitals/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
