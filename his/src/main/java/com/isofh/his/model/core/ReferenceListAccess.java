package com.isofh.his.model.core;

import com.isofh.his.model.base.BaseModel;
import com.isofh.his.model.employee.Privilege;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_reference_list_access")
public class ReferenceListAccess extends BaseModel {
    @Id
    @GeneratedValue(generator = "reference_list_access_generator")
    @SequenceGenerator(
            name = "reference_list_access_generator",
            sequenceName = "reference_list_access_sq",
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_list_id")
    @Audited
    private ReferenceList referenceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privilege_id")
    @Audited
    private Privilege privilege;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "access")
    @Audited
    private boolean access;

    public ReferenceList getReferenceList() {
        return referenceList;
    }

    public void setReferenceList(ReferenceList referenceList) {
        this.referenceList = referenceList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}