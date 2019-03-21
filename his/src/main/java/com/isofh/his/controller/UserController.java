package com.isofh.his.controller;

import com.isofh.his.model.ResponseMsg;
import com.isofh.his.model.User;
import com.isofh.his.service.UserService;
import com.isofh.his.service.security.JwtService;
import org.springframework.beans.factory.annotation.*;
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
    public ResponseEntity<ResponseMsg> getById(@PathVariable Long id) {
        return response("user", userService.get(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<ResponseMsg> createUser(@Valid @RequestBody User user) {
        return response("user", userService.createUser(user));
    }

    @PostMapping("/update-user")
    public ResponseEntity<ResponseMsg> updateUser(@Valid @RequestBody User user) {
        return response("user", userService.updateUser(user));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> login(HttpServletRequest request, @RequestBody User user) {

        if (userService.checkLogin(user)) {
            user.setLoginToken(jwtService.generateTokenLogin(user.getUsername()));
            return response("user", user);
        } else {
            return response(3, "Invalid username or password");
        }
    }
}
