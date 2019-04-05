package com.isofh.signer.model;

import org.hibernate.envers.Audited;

import javax.persistence.*;

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

    @Column(name = "password", nullable = false)
    @Audited
    private String password;

    @Column(name = "first_name", nullable = false)
    @Audited
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Audited
    private String lastName;

    @Column(name = "name", nullable = false)
    @Audited
    private String name;

    @Column(name = "email")
    @Audited
    private String email;

    @Column(name = "enabled")
    @Audited
    private boolean enabled;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
