package com.isofh.his.model.base;

import com.isofh.his.model.audit.AuditModel;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel extends AuditModel {
    public abstract Long getId();

    public abstract void setId(Long id);
}