package com.isofh.his.controller;

import com.isofh.his.model.Privilege;
import com.isofh.his.model.ResponseMsg;
import com.isofh.his.model.Role;
import com.isofh.his.repository.PrivilegeRepository;
import com.isofh.his.service.PrivilegeService;
import com.isofh.his.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController extends BaseController {

    @Autowired
    private PrivilegeService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("privilege", service.get(id));
    }

    @PostMapping("/create-privilege")
    public ResponseEntity<ResponseMsg> createPrivilege(@Valid @RequestBody Privilege privilege) {
        return response("privilege", service.createPrivilege(privilege));
    }

}
