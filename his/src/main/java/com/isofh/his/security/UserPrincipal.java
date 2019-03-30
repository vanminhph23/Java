package com.isofh.his.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.employee.Privilege;
import com.isofh.his.model.employee.Role;
import com.isofh.his.model.employee.User;
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

    private Collection<SimpleGrantedAuthority> authorities;


    public UserPrincipal(Long id, String username, String email, String password, boolean isEnabled, Long departmentId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.departmentId = departmentId;

        this.roleIds = new ArrayList<>();
        this.departmentIds = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.authorities = new ArrayList<>();
    }

    public static UserPrincipal get(User user) {
        return get(user, null, null);
    }

    public static UserPrincipal get(User user, List<Long> roleIds, List<Long> departmentIds) {

        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled(), user.getDepartmentId());

        userPrincipal.setDepartment(user.getDepartment());

        List<Role> roles = user.getRoles();

        for (Role r : roles) {
            if (roleIds != null && roleIds.size() > 0 && !roleIds.contains(r.getId())) {
                continue;
            }

            userPrincipal.roleIds.add(r.getId());
            userPrincipal.roles.add(r);
            List<Privilege> privileges = r.getPrivileges();
            for (Privilege pr : privileges) {
                userPrincipal.authorities.add(new SimpleGrantedAuthority(pr.getValue()));
            }
        }

        List<Department> departments = user.getDepartments();
        for (Department d : departments) {
           if (departmentIds != null && departmentIds.size() > 0 && !departmentIds.contains(d.getId())) {
               continue;
           }

           userPrincipal.departmentIds.add(d.getId());
           userPrincipal.departments.add(d);
        }

        return userPrincipal;
    }

    private static void validId(List<Long> ids, List<Long> finalIds, Long id) {
        if (ids != null && ids.size() > 0) {

            if (!ids.contains(id)) {
                return;
            }
        }

        finalIds.add(id);
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
