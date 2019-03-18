package com.isofh.his.controller;

import com.isofh.his.model.User;
import com.isofh.his.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{name}")
    public User getById(@PathVariable String name) {
        return userRepository.findByName(name);
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}
