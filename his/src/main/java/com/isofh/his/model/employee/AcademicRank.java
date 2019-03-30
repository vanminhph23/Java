package com.isofh.his.model.employee;

import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_academic_rank")
public class AcademicRank extends Base2Model {
    @Id
    @GeneratedValue(generator = "academic_rank_generator")
    @SequenceGenerator(
            name = "academic_rank_generator",
            sequenceName = "academic_rank_sq",
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

    @Column(name = "description")
    @Audited
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
