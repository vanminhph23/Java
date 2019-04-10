package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.service.category.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class DepartmentController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService service;

    @GetMapping("/departments/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("department", service.getAndTransfer(id));
    }

    @PostMapping("/departments")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DepartmentDto dto) {
        return response("department", service.saveAndTransfer(dto));
    }

    @PutMapping("/departments")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody DepartmentDto dto) {
        return response("department", service.saveAndTransfer(dto));
    }

    @PostMapping("/departments/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
