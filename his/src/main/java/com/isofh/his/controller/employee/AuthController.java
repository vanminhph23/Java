package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.ChooseRoleRequest;
import com.isofh.his.dto.employee.JwtAuthenticationResponse;
import com.isofh.his.dto.employee.LoginRequest;
import com.isofh.his.security.JwtTokenProvider;
import com.isofh.his.security.UserPrincipal;
import com.isofh.his.service.category.DepartmentService;
import com.isofh.his.service.employee.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    RoleService roleService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> login(@Valid @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword())
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

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> chooseRole(@Valid @RequestBody ChooseRoleRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> map = new HashMap<>();
        map.put("authentication", new JwtAuthenticationResponse(tokenProvider.generateToken(authentication, request.getDepartmentId(), request.getRoleId())));

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
