package com.isofh.his.controller.category;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.service.category.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/assurance-card")
public class AssuranceCardController extends BaseController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("assuranceCard", service.getDto(service.get(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody DepartmentDto model) {
        return response("assuranceCard", service.getDto(service.save(service.getModel(model))));
    }
}
