package com.isofh.his.controller;

import com.isofh.his.dto.ResponseMsg;
import com.isofh.his.dto.base.ReferenceDto;
import com.isofh.his.service.base.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reference")
public class ReferenceController extends BaseController {

    @Autowired
    private ReferenceService referenceService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", referenceService.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceDto referenceDto) {
        return response("user", referenceService.create(referenceService.getModel(referenceDto)));
    }
}
