package com.isofh.his.security;

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

    private Long roleId;

    private Long mainDepartmentId;

    private String email;

    private String password;

    private boolean isEnabled;

    private List<String> privileges;


    public UserPrincipal(Long id, String username, String email, String password, boolean isEnabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;

        this.privileges = new ArrayList<>();
    }

    public static UserPrincipal get(Long id, Long departmentId, Long roleId, Long mainDepartmentId, List<String> privileges) {
        UserPrincipal userPrincipal = new UserPrincipal(id, null, null, null, true);
        userPrincipal.setDepartmentId(departmentId);
        userPrincipal.setRoleId(roleId);
        userPrincipal.setMainDepartmentId(mainDepartmentId);
        userPrincipal.setPrivileges(privileges);
        return userPrincipal;
    }

    public static UserPrincipal get(User user) {
        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled());
        userPrincipal.setMainDepartmentId(user.getDepartmentId());

        return userPrincipal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMainDepartmentId() {
        return mainDepartmentId;
    }

    public void setMainDepartmentId(Long mainDepartmentId) {
        this.mainDepartmentId = mainDepartmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
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
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (String pr : privileges) {
            authorities.add(new SimpleGrantedAuthority(pr));
        }

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
