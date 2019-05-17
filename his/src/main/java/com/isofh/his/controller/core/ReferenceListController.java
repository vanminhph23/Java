package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.service.core.ReferenceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ReferenceListController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceListController.class);

    @Autowired
    private ReferenceListService service;

    @GetMapping("/reference-lists/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("referenceList", service.findDtoById(id));
    }

    @GetMapping("/reference-lists")
    public ResponseEntity<ResponseMsg> getByValue(@RequestParam String referenceValue, @RequestParam int value) {
        return response("referenceList", service.findDtoByReferenceValueAndValue(referenceValue, value));
    }

    @PostMapping("/reference-lists")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceListDto dto) {
        return response("referenceList", service.createDto(dto));
    }

    @PutMapping("/reference-lists")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ReferenceListDto dto) {
        return response("referenceList", service.updateDto(dto));
    }

    @PostMapping("/reference-lists/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
