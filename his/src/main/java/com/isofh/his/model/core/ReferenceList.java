package com.isofh.his.model.core;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_reference_list")
public class ReferenceList extends BaseModel {
    @Id
    @GeneratedValue(generator = "reference_list_generator")
    @SequenceGenerator(
            name = "reference_list_generator",
            sequenceName = "reference_list_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "value", nullable = false)
    @Audited
    private int value;

    @Column(name = "name", nullable = false)
    @Audited
    private String name;

    @ManyToOne
    @JoinColumn(name = "reference_id", nullable = false)
    private Reference reference;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "strict_access", nullable = false)
    @Audited
    private boolean strictAccess;

    @OneToMany
    @JoinColumn(name = "reference_list_id")
    private List<ReferenceListAccess> referenceListAccesses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isStrictAccess() {
        return strictAccess;
    }

    public void setStrictAccess(boolean strictAccess) {
        this.strictAccess = strictAccess;
    }

    public List<ReferenceListAccess> getReferenceListAccesses() {
        return referenceListAccesses;
    }

    public void setReferenceListAccesses(List<ReferenceListAccess> referenceListAccesses) {
        this.referenceListAccesses = referenceListAccesses;
    }
}