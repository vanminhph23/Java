package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.service.category.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class ZoneController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ZoneController.class);

    @Autowired
    private ProvinceService service;

    @GetMapping("/zones/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("zone", service.getAndTransfer(id));
    }

    @PostMapping("/zones")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ProvinceDto dto) {
        return response("zone", service.saveAndTransfer(dto));
    }

    @PutMapping("/zones")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ProvinceDto dto) {
        return response("zone", service.saveAndTransfer(dto));
    }

    @PostMapping("/zones/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
