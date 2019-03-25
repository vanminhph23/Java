package com.isofh.his.controller;

import com.isofh.his.dto.ResponseMsg;
import com.isofh.his.model.Department;
import com.isofh.his.model.User;
import com.isofh.his.service.user.DepartmentService;
import com.isofh.his.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", service.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody Department model) {
        return response("department", service.create(model));
    }
}
