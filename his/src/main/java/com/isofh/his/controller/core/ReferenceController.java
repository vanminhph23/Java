package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.service.core.ReferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ReferenceController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceController.class);

    @Autowired
    private ReferenceService service;

    @GetMapping("/references/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("reference", service.findDtoById(id));
    }

    @GetMapping("/references")
    public ResponseEntity<ResponseMsg> getByValue(@RequestParam String value) {
        return response("reference", service.findDtoByValue(value));
    }

    @PostMapping("/references")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceDto dto) {
        return response("reference", service.saveDto(dto));
    }

    @PutMapping("/references")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ReferenceDto dto) {
        return response("reference", service.saveDto(dto));
    }

    @PostMapping("/references/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
