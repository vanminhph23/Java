package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_active_ingredient", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class ActiveIngredient extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "active_ingredient_generator")
    @SequenceGenerator(
            name = "active_ingredient_generator",
            sequenceName = "active_ingredient_sq",
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
}
