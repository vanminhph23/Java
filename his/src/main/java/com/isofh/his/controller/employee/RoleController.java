package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.RoleDto;
import com.isofh.his.service.employee.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RoleController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService service;

    @GetMapping("/roles/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("role", service.findDtoById(id));
    }

    @PostMapping("/roles")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody RoleDto dto) {
        return response("role", service.createDto(dto));
    }

    @PutMapping("/roles")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody RoleDto dto) {
        return response("role", service.updateDto(dto));
    }
}
