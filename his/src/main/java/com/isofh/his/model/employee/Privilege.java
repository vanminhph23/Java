package com.isofh.his.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;
import com.isofh.his.model.employee.Role;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "his_privilege")
public class Privilege extends Base2Model {

    @Id
    @GeneratedValue(generator = "privilege_generator")
    @SequenceGenerator(
            name = "privilege_generator",
            sequenceName = "privilege_sq",
            initialValue = 1000000
    )
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
