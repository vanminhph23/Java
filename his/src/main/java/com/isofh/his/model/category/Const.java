package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_const", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class Const extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "const_generator")
    @SequenceGenerator(
            name = "const_generator",
            sequenceName = "const_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description")
    @Audited
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
