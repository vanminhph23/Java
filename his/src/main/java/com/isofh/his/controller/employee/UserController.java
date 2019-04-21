package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.service.employee.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", userService.findDtoById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody UserDto dto) {
        return response("user", userService.saveDto(dto));
    }

    @PutMapping("/users")
    public ResponseEntity<ResponseMsg> update(@Valid @RequestBody UserDto dto) {
        return response("user", userService.saveDto(dto));
    }
}
