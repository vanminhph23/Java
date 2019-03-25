package com.isofh.his.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.Base2Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_department")
public class Department extends Base2Model {
    @Id
    @GeneratedValue(generator = "department_generator")
    @SequenceGenerator(
            name = "department_generator",
            sequenceName = "department_sq",
            initialValue = 1000000
    )
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<User> users;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
