package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.service.category.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/departments/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("department", service.getDto(service.get(id)));
    }

    @PostMapping("/departments")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DepartmentDto model) {
        return response("department", service.getDto(service.save(service.getModel(model))));
    }

    @PutMapping("/departments")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody DepartmentDto model) {
        return response("department", service.getDto(service.save(service.getModel(model))));
    }

    @PostMapping("/departments/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
