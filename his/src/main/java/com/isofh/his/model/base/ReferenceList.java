package com.isofh.his.model.base;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_reference_list")
public class ReferenceList extends Base2Model {
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

    @Column(name = "reference_id", nullable = false)
    @Audited
    private Long referenceId;

    @ManyToOne
    @JoinColumn(name = "reference_id", insertable = false, updatable = false)
    private Reference reference;

    @Column(name = "description", unique = true)
    @Audited
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}