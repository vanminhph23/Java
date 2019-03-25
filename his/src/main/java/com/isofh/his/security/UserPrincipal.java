package com.isofh.his.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.Department;
import com.isofh.his.model.Privilege;
import com.isofh.his.model.Role;
import com.isofh.his.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    private Long departmentId;

    private Department department;

    private List<Long> roleIds;

    private List<Role> roles;

    private List<Long> departmentIds;

    private List<Department> departments;



    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private boolean isEnabled;

    private Collection<? extends GrantedAuthority> authorities;


    public UserPrincipal(Long id, String username, String email, String password, boolean isEnabled, Long departmentId, List<Long> departmentIds, List<Long> roleIds, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
        this.departmentId = departmentId;
        this.roleIds = roleIds;
        this.departmentIds = departmentIds;
    }

    public static UserPrincipal get(User user) {
        return get(user, null, null);
    }

    public static UserPrincipal get(User user, List<Long> roleIds, List<Long> departmentIds) {

        List<Role> roles = user.getRoles();
        List<Long> finalRoleIds = new ArrayList<>();
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role r : roles) {
            validId(roleIds, finalRoleIds, r.getId());

            List<Privilege> privileges = r.getPrivileges();
            for (Privilege pr : privileges) {
                authorities.add(new SimpleGrantedAuthority(pr.getValue()));
            }
        }

        List<Department> departments = user.getDepartments();
        List<Long> finalDepartmentIds = new ArrayList<>();
        for (Department d : departments) {
            validId(departmentIds, finalDepartmentIds, d.getId());
        }

        return new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getDepartmentId(), finalDepartmentIds, finalRoleIds, authorities);
    }

    private static void validId(List<Long> departmentIds, List<Long> finalDepartmentIds, Long id) {
        if (departmentIds != null && departmentIds.size() > 0) {

            if (!departmentIds.contains(id)) {
                return;
            }
        }

        finalDepartmentIds.add(id);
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
