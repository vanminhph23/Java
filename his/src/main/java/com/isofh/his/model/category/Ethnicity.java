package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_ethnicity")
@Audited
public class Ethnicity extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "ethnicity_generator")
    @SequenceGenerator(
            name = "ethnicity_generator",
            sequenceName = "ethnicity_sq",
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
