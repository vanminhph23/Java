package com.isofh.his.model.patient;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_guardian")
public class Guardian extends BaseModel {
    @Id
    @GeneratedValue(generator = "guardian_generator")
    @SequenceGenerator(
            name = "guardian_generator",
            sequenceName = "guardian_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "name")
    @Audited
    private String name;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
