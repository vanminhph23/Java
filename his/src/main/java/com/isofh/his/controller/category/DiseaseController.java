package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.DiseaseDto;
import com.isofh.his.service.category.DiseaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class DiseaseController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(DiseaseController.class);

    @Autowired
    private DiseaseService service;

    @GetMapping("/diseases/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("disease", service.getAndTransfer(id));
    }

    @PostMapping("/diseases")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DiseaseDto dto) {
        return response("disease", service.saveAndTransfer(dto));
    }

    @PutMapping("/diseases")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody DiseaseDto dto) {
        return response("disease", service.saveAndTransfer(dto));
    }

    @PostMapping("/diseases/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
