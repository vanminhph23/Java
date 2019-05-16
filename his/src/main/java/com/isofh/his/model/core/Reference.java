package com.isofh.his.model.core;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_reference", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class Reference extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "reference_generator")
    @SequenceGenerator(
            name = "reference_generator",
            sequenceName = "reference_sq",
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reference")
    private List<ReferenceList> referenceLists;

    @Column(name = "description")
    @Audited
    private String description;

    public List<ReferenceList> getReferenceLists() {
        return referenceLists;
    }

    public void setReferenceLists(List<ReferenceList> referenceLists) {
        this.referenceLists = referenceLists;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
