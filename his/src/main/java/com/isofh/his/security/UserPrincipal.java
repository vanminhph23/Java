package com.isofh.his.security;

import com.isofh.his.model.category.Department;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.model.employee.Role;
import com.isofh.his.model.employee.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    private Long departmentId;

    private List<Long> roleIds;

    private List<Long> departmentIds;

    private String email;

    private String password;

    private boolean isEnabled;

    private List<SimpleGrantedAuthority> authorities;

    private List<String> privileges;


    public UserPrincipal(Long id, String username, String email, String password, boolean isEnabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;

        this.roleIds = new ArrayList<>();
        this.departmentIds = new ArrayList<>();
        this.authorities = new ArrayList<>();
        this.privileges = new ArrayList<>();
    }

    public static UserPrincipal get(Long id, Long departmentId, List<Long> roleIds, List<Long> departmentIds, List<String> privileges) {
        UserPrincipal userPrincipal = new UserPrincipal(id, null, null, null, true);
        userPrincipal.setDepartmentId(departmentId);
        userPrincipal.setRoleIds(roleIds);
        userPrincipal.setDepartmentIds(departmentIds);
        userPrincipal.setPrivileges(privileges);

        for (String pr : privileges) {
            userPrincipal.authorities.add(new SimpleGrantedAuthority(pr));
        }

        return userPrincipal;
    }

    public static UserPrincipal get(User user) {
        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled());

        userPrincipal.setDepartmentId(user.getDepartmentId());

        List<Role> roles = user.getRoles();

        for (Role r : roles) {
            userPrincipal.roleIds.add(r.getId());
            List<Privilege> privileges = r.getPrivileges();
            for (Privilege pr : privileges) {
                userPrincipal.privileges.add(pr.getValue());
                userPrincipal.authorities.add(new SimpleGrantedAuthority(pr.getValue()));
            }
        }

        List<Department> departments = user.getDepartments();
        for (Department d : departments) {
           userPrincipal.departmentIds.add(d.getId());
        }

        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Long> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Long> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
