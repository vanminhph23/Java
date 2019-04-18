package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.CountryDto;
import com.isofh.his.service.category.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class CountryController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService service;

    @GetMapping("/countries/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("country", service.getAndTransfer(id));
    }

    @PostMapping("/countries")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody CountryDto dto) {
        return response("country", service.saveAndTransfer(dto));
    }

    @PutMapping("/countries")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody CountryDto dto) {
        return response("country", service.saveAndTransfer(dto));
    }

    @PostMapping("/countries/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
