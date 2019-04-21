package com.isofh.his.controller.category.service;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.service.ServiceGroupLevel2Dto;
import com.isofh.his.service.category.service.ServiceGroupLevel2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ServiceGroupLevel2Controller extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ServiceGroupLevel2Controller.class);

    @Autowired
    private ServiceGroupLevel2Service service;

    @GetMapping("/service-group-level2s/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("serviceGroupLevel1", service.findDtoById(id));
    }

    @PostMapping("/service-group-level2s")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ServiceGroupLevel2Dto dto) {
        return response("serviceGroupLevel1", service.saveDto(dto));
    }

    @PutMapping("/service-group-level2s")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ServiceGroupLevel2Dto dto) {
        return response("serviceGroupLevel1", service.saveDto(dto));
    }

    @PostMapping("/service-group-level2s/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
