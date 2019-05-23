package com.isofh.his.controller.employee;

import com.isofh.his.controller.base.BaseResponseController;
import com.isofh.his.dto.base.ResponseMsg;
import com.isofh.his.dto.employee.ChooseRoleRequest;
import com.isofh.his.dto.employee.JwtAuthenticationResponse;
import com.isofh.his.dto.employee.LoginRequest;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.model.employee.Role;
import com.isofh.his.model.employee.User;
import com.isofh.his.security.JwtTokenProvider;
import com.isofh.his.security.UserPrincipal;
import com.isofh.his.service.category.DepartmentService;
import com.isofh.his.service.employee.RoleService;
import com.isofh.his.service.employee.UserService;
import com.isofh.his.service.report.JasperReportServiceImpl;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseResponseController {

    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    JasperReportServiceImpl reportService;

    @Override
    protected Logger getLogger() {
        return this.logger;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> login(@Valid @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Map<String, Object> map = new HashMap<>();
        map.put("authentication", new JwtAuthenticationResponse(tokenProvider.generateToken(authentication)));

        User user = userService.findById(userPrincipal.getId());
        List<Role> roles = user.getRoles();
        List<Department> departments = user.getDepartments();

        map.put("roles", roles.stream().map(role -> roleService.getSimpleDto(role)));
        map.put("departments", departments.stream().map(department -> departmentService.getSimpleDto(department)));

        return response(map);
    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public ResponseEntity<ResponseMsg> chooseRole(@Valid @RequestBody ChooseRoleRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Long roleId = request.getRoleId();
        Long departmentId = request.getDepartmentId();

        User user = userService.findById(userPrincipal.getId());
        List<Role> roles = user.getRoles();
        Role choosedRole = null;

        boolean isValid = false;
        for (Role role: roles) {
            if (role.getId().equals(roleId)) {
                choosedRole = role;
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new InvalidDataException("User not have role id: " + request.getRoleId());
        }

        if (departmentId != null && departmentId > 0 && !departmentId.equals(user.getDepartmentId())) {
            isValid = false;
            List<Department> departments = user.getDepartments();
            for (Department department: departments) {
                if (department.getId().equals(departmentId)) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                throw new InvalidDataException("User not have department id: " + request.getRoleId());
            }
        }

        List<String> privileges = new ArrayList<>();
        List<Privilege> list = choosedRole.getPrivileges();

        for (Privilege pr : list) {
            privileges.add(pr.getValue());
        }

        Map<String, Object> map = new HashMap<>();
        String jwt = tokenProvider.generateToken(userPrincipal.getId(), departmentId, roleId, user.getDepartmentId(), privileges);

        map.put("authentication", new JwtAuthenticationResponse(jwt));
        map.put("privileges", privileges);

        return response(map);
    }
}
