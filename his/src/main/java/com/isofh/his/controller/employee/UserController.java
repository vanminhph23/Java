package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.UserDto;
import com.isofh.his.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", userService.get(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody UserDto userDto) {
        return response("user", userService.create(userService.getModel(userDto)));
    }
}
