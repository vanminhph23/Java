package com.isofh.his.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "his_user")
public class User extends BaseModel {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "username", nullable = false)
    @Audited
    private String username;

    @Column(name = "password", nullable = false)
    @Audited
    private String password;

    @Column(name = "first_name", nullable = false)
    @Audited
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Audited
    private String lastName;

    @Column(name = "email")
    @Audited
    private String email;

    @Column(name = "enabled", nullable = false)
    @Audited
    private boolean enabled = true;

    @ManyToMany
    @JoinTable(
            name = "his_users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
