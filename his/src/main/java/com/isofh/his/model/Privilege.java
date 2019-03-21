package com.isofh.his.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "his_privilege")
public class Privilege extends BaseModel {

    @Id
    @GeneratedValue(generator = "privilege_generator")
    @SequenceGenerator(
            name = "privilege_generator",
            sequenceName = "privilege_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
