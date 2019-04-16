package com.isofh.his.model.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "his_privilege")
@Audited
public class Privilege extends BaseCategoryModel {

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
