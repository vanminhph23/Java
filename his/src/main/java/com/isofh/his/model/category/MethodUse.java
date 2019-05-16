package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_method_use", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class MethodUse extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "method_use_generator")
    @SequenceGenerator(
            name = "method_use_generator",
            sequenceName = "method_use_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "order")
    @Audited
    private int order;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
