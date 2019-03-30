package com.isofh.his.controller;

import com.isofh.his.dto.ResponseMsg;
import com.isofh.his.model.employee.Role;
import com.isofh.his.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("role", service.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody Role role) {
        return response("role", service.create(role));
    }

}
