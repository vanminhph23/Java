package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.category.JobDto;
import com.isofh.his.service.category.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
public class JobController extends BaseController {

    @Autowired
    private JobService service;

    @GetMapping("/jobs/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("job", service.getDto(service.get(id)));
    }

    @PostMapping("/jobs")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody JobDto model) {
        return response("job", service.getDto(service.save(service.getModel(model))));
    }

    @PutMapping("/jobs")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody JobDto model) {
        return response("job", service.getDto(service.save(service.getModel(model))));
    }

    @PostMapping("/jobs/excel")
    public ResponseEntity<InputStreamResource> importExcel(@RequestParam("file") MultipartFile file) {
        return response(service.importExcel(file, 1, 1));
    }
}
