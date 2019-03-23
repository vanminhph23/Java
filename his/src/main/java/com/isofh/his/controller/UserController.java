package com.isofh.his.controller;

import com.isofh.his.dto.ResponseMsg;
import com.isofh.his.model.User;
import com.isofh.his.service.user.UserService;
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
        return response("user", userService.getById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<ResponseMsg> createUser(@Valid @RequestBody User user) {
        return response("user", userService.createUser(user));
    }

    @PostMapping("/update-user")
    public ResponseEntity<ResponseMsg> updateUser(@Valid @RequestBody User user) {
        return response("user", userService.updateUser(user));
    }
}
