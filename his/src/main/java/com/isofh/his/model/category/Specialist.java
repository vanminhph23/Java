package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_specialist", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
@Audited
public class Specialist extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "specialist_generator")
    @SequenceGenerator(
            name = "specialist_generator",
            sequenceName = "specialist_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "note")
    @Audited
    private String note;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
