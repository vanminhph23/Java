package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_ethnic")
@Audited
public class Ethnicity extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "ethnic_generator")
    @SequenceGenerator(
            name = "ethnic_generator",
            sequenceName = "ethnic_sq",
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
