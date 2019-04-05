package com.isofh.signer.model;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel extends AuditModel {
    public abstract Long getId();

    public abstract void setId(Long id);

    @Column(name = "active", nullable = false)
    @Audited
    private boolean active = true;

    @Column(name = "deleted", nullable = false)
    @Audited
    private boolean deleted = false;

    @Column(name = "dev")
    private String dev;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}