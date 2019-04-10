package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.service.core.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ReferenceController extends BaseController {

    @Autowired
    private ReferenceService service;

    @GetMapping("/references/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", service.get(id));
    }

    @PostMapping("/references")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceDto referenceDto) {
        return response("user", service.save(service.getModel(referenceDto)));
    }

    @PutMapping("/references")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ReferenceDto referenceDto) {
        return response("user", service.save(service.getModel(referenceDto)));
    }
}
