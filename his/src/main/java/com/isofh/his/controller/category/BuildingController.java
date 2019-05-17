package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.BuildingDto;
import com.isofh.his.service.category.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class BuildingController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingService service;

    @GetMapping("/buildings/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("job", service.findDtoById(id));
    }

    @PostMapping("/buildings")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody BuildingDto dto) {
        return response("job", service.createDto(dto));
    }

    @PutMapping("/buildings")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody BuildingDto dto) {
        return response("job", service.updateDto(dto));
    }

    @PostMapping("/buildings/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
