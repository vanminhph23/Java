package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.AcademicRankDto;
import com.isofh.his.service.employee.AcademicRankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/academic-ranks")
public class AcademicRankController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(AcademicRankController.class);

    @Autowired
    private AcademicRankService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response(service.findDtoById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody AcademicRankDto dto) {
        return response(service.createDto(dto));
    }

    @PutMapping
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody AcademicRankDto dto) {
        return response(service.updateDto(dto));
    }

    @PostMapping("/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
