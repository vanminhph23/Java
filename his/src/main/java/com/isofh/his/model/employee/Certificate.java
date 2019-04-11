package com.isofh.his.model.employee;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_qualification")
@Audited
public class Certificate extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "qualification_generator")
    @SequenceGenerator(
            name = "qualification_generator",
            sequenceName = "qualification_sq",
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
