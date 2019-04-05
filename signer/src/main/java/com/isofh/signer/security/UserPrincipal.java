package com.isofh.signer.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.signer.model.User;
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


    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private boolean isEnabled;

    private Collection<SimpleGrantedAuthority> authorities;


    public UserPrincipal(Long id, String username, String email, String password, boolean isEnabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.authorities = new ArrayList<>();
    }

    public static UserPrincipal get(User user) {

        UserPrincipal userPrincipal = new UserPrincipal(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.isEnabled());

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
