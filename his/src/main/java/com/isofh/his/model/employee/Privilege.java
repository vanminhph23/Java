package com.isofh.his.model.employee;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "his_privilege", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Where(clause = "deleted=0")
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "privileges")
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
