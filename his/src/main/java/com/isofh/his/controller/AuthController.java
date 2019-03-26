package com.isofh.his.controller;

import com.isofh.his.dto.*;
import com.isofh.his.security.JwtTokenProvider;
import com.isofh.his.security.UserPrincipal;
import com.isofh.his.service.user.DepartmentService;
import com.isofh.his.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    RoleService roleService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> login(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String, Object> map = new HashMap<>();
        map.put("authentication", new JwtAuthenticationResponse(tokenProvider.generateToken(authentication)));

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        if (userPrincipal != null) {
            addRoleAndDepartment(map, userPrincipal);
            map.put("department", departmentService.getDto(userPrincipal.getDepartment()));
        }

        return response(map);
    }

    @RequestMapping(value = "/choose-role", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> chooseRole(@Valid @RequestBody ChooseRoleRequest chooseRoleRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> map = new HashMap<>();
        map.put("authentication", new JwtAuthenticationResponse(tokenProvider.generateToken(authentication, chooseRoleRequest.getDepartmentId(), chooseRoleRequest.getRoleId())));

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        if (userPrincipal != null) {
            addRoleAndDepartment(map, userPrincipal);
        }

        return response(map);
    }

    private void addRoleAndDepartment(Map<String, Object> map, UserPrincipal userPrincipal) {
        map.put("roles", userPrincipal.getRoles().stream().map(r -> roleService.getDto(r)));
        map.put("departments", userPrincipal.getDepartments().stream().map(d -> departmentService.getDto(d)));
    }
}
