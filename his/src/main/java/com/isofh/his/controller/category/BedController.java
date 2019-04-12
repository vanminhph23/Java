package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.BedDto;
import com.isofh.his.dto.category.ProvinceDto;
import com.isofh.his.service.category.BedService;
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
public class BedController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BedController.class);

    @Autowired
    private BedService service;

    @GetMapping("/beds/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("bed", service.getAndTransfer(id));
    }

    @PostMapping("/beds")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody BedDto dto) {
        return response("bed", service.saveAndTransfer(dto));
    }

    @PutMapping("/beds")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody BedDto dto) {
        return response("bed", service.saveAndTransfer(dto));
    }

    @PostMapping("/beds/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}