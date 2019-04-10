package com.isofh.his.controller.core;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.core.ReferenceListDto;
import com.isofh.his.service.core.ReferenceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ReferenceListController extends BaseController {

    @Autowired
    private ReferenceListService service;

    @GetMapping("/reference-lists/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("referenceList", service.getAndTransfer(id));
    }

    @PostMapping("/reference-lists")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceListDto dto) {
        return response("referenceList", service.saveAndTransfer(dto));
    }

    @PutMapping("/reference-lists")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody ReferenceListDto dto) {
        return response("referenceList", service.saveAndTransfer(dto));
    }
}
