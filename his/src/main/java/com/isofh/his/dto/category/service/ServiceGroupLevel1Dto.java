package com.isofh.his.dto.category.service;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ServiceGroupLevel1Dto extends BaseCategoryDto {

    public ServiceGroupLevel1Dto() {
    }

    private int sequenceNo;

    private int serviceType;

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }
}
