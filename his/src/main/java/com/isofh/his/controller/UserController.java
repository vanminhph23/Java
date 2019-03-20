package com.isofh.his.controller;

import com.isofh.his.model.ResultEntity;
import com.isofh.his.model.User;
import com.isofh.his.service.UserService;
import com.isofh.his.service.security.JwtService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping("/")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResultEntity> login(HttpServletRequest request, @RequestBody User user) {
        try {
            if (userService.checkLogin(user)) {
                user.setLoginToken(jwtService.generateTokenLogin(user.getUsername()));
                return response("user", user);
            } else {
                return response(3, "Invalid username or password");
            }
        } catch (Exception ex) {
            return response(ex);
        }
    }
}
