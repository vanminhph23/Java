package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.service.ServiceGroupLevel1Dto;
import com.isofh.his.service.category.service.ServiceGroupLevel1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ServiceGroupLevel1Controller extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel1Controller.class);

    @Autowired
    private ServiceGroupLevel1Service service;

    @GetMapping("/service-group-level1s/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("serviceGroupLevel1", service.getAndTransfer(id));
    }

    @PostMapping("/service-group-level1s")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ServiceGroupLevel1Dto dto) {
        return response("serviceGroupLevel1", service.saveAndTransfer(dto));
    }

    @PutMapping("/service-group-level1s")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ServiceGroupLevel1Dto dto) {
        return response("serviceGroupLevel1", service.saveAndTransfer(dto));
    }

    @PostMapping("/service-group-level1s/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
