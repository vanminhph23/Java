package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseCategoryController;
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
@RequestMapping(path = "/references")
public class ReferenceController extends BaseCategoryController {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceController.class);

    @Autowired
    private ReferenceService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response(service.findDtoById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceDto dto) {
        return response(service.createDto(dto));
    }

    @PutMapping
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ReferenceDto dto) {
        return response(service.updateDto(dto));
    }

    @PostMapping("/references/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
