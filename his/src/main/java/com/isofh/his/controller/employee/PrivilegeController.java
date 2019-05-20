package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.PrivilegeDto;
import com.isofh.his.service.employee.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/privileges")
public class PrivilegeController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(PrivilegeController.class);

    @Autowired
    private PrivilegeService service;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response(service.findDtoById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody PrivilegeDto dto) {
        return response(service.createDto(dto));
    }

    @PutMapping("/privileges")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody PrivilegeDto dto) {
        return response(service.updateDto(dto));
    }
}
