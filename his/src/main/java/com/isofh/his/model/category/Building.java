package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_building", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class Building extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "building_generator")
    @SequenceGenerator(
            name = "building_generator",
            sequenceName = "building_sq",
            initialValue = 1000000
    )
    private Long id;

    String description;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
