package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.service.employee.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PrivilegeController extends BaseController {

    @Autowired
    private PrivilegeService service;

    @GetMapping("/privileges/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("privilege", service.get(id));
    }

    @PostMapping("/privileges")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody Privilege privilege) {
        return response("privilege", service.save(privilege));
    }

    @PutMapping("/privileges")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody Privilege privilege) {
        return response("privilege", service.save(privilege));
    }
}
