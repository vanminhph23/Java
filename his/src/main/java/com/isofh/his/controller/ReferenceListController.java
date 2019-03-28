package com.isofh.his.controller;

import com.isofh.his.dto.ResponseMsg;
import com.isofh.his.dto.base.ReferenceListDto;
import com.isofh.his.service.base.ReferenceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reference-list")
public class ReferenceListController extends BaseController {

    @Autowired
    private ReferenceListService referenceListService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("referenceList", referenceListService.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody ReferenceListDto referenceListDto) {
        return response("referenceList", referenceListService.create(referenceListService.getModel(referenceListDto)));
    }
}
