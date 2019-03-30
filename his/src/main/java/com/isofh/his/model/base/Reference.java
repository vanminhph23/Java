package com.isofh.his.model.base;

import com.isofh.his.model.core.ReferenceList;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "his_reference")
public class Reference extends Base2Model {
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

    @OneToMany
    @JoinColumn(name = "reference_id")
    private List<ReferenceList> referenceLists;

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
