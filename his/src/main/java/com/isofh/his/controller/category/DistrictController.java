package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.DistrictDto;
import com.isofh.his.service.category.DistrictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class DistrictController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(DistrictController.class);

    @Autowired
    private DistrictService service;

    @GetMapping("/districts/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("district", service.findDtoById(id));
    }

    @PostMapping("/districts")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DistrictDto dto) {
        return response("district", service.createDto(dto));
    }

    @PutMapping("/districts")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody DistrictDto dto) {
        return response("district", service.updateDto(dto));
    }

    @PostMapping("/districts/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
