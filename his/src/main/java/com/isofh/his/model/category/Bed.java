package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_bed")
@Audited
public class Bed extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "bed_generator")
    @SequenceGenerator(
            name = "bed_generator",
            sequenceName = "bed_sq",
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
