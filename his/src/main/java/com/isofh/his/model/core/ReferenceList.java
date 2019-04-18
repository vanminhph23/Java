package com.isofh.his.model.core;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_reference_list")
public class ReferenceList extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "reference_list_generator")
    @SequenceGenerator(
            name = "reference_list_generator",
            sequenceName = "reference_list_sq",
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

    @ManyToOne
    @JoinColumn(name = "reference_id")
    private Reference reference;

    @Column(name = "description")
    @Audited
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}