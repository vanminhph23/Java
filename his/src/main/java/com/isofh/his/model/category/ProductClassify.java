package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_product_classify", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class ProductClassify extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "product_classify_generator")
    @SequenceGenerator(
            name = "product_classify_generator",
            sequenceName = "product_classify_sq",
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
