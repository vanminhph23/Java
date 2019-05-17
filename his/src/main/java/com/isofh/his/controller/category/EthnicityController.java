package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.EthnicityDto;
import com.isofh.his.service.category.EthnicityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class EthnicityController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(EthnicityController.class);

    @Autowired
    private EthnicityService service;

    @GetMapping("/ethnicities/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("zone", service.findDtoById(id));
    }

    @PostMapping("/ethnicities")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody EthnicityDto dto) {
        return response("zone", service.createDto(dto));
    }

    @PutMapping("/ethnicities")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody EthnicityDto dto) {
        return response("zone", service.updateDto(dto));
    }

    @PostMapping("/ethnicities/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
