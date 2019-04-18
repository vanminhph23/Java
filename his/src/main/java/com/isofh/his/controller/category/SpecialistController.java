package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.SpecialistDto;
import com.isofh.his.service.category.SpecialistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class SpecialistController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(SpecialistController.class);

    @Autowired
    private SpecialistService service;

    @GetMapping("/specialists/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("specialist", service.getAndTransfer(id));
    }

    @PostMapping("/specialists")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody SpecialistDto dto) {
        return response("specialist", service.saveAndTransfer(dto));
    }

    @PutMapping("/specialists")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody SpecialistDto dto) {
        return response("specialist", service.saveAndTransfer(dto));
    }

    @PostMapping("/specialists/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
