package com.isofh.signer.controller;

import com.isofh.signer.dto.ResponseMsg;
import com.isofh.signer.dto.UserDto;
import com.isofh.signer.service.UserService;
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
        return response("user", userService.getDto(userService.get(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseMsg> create(@Valid @RequestBody UserDto userDto) {
        return response("user", userService.save(userService.getModel(userDto)));
    }
}
