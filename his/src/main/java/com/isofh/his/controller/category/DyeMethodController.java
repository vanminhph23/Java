package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.DyeMethodDto;
import com.isofh.his.dto.category.ReportTemplateDto;
import com.isofh.his.service.category.DyeMethodService;
import com.isofh.his.service.category.ReportTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/dye-methods")
public class DyeMethodController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(DyeMethodController.class);

    @Autowired
    private DyeMethodService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response(service.findDtoById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DyeMethodDto dto) {
        return response(service.createDto(dto));
    }

    @PutMapping("/dye-methods")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody DyeMethodDto dto) {
        return response(service.updateDto(dto));
    }

    @PostMapping("/dye-methods/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}