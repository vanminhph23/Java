package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_medical_record_type", indexes = {@Index(name = "medical_record_type_idx_value", columnList = "value")})
@Audited
public class MedicalRecordType extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "medical_record_type_generator")
    @SequenceGenerator(
            name = "medical_record_type_generator",
            sequenceName = "medical_record_type_sq",
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
