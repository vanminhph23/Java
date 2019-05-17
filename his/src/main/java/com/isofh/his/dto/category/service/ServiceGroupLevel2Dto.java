package com.isofh.his.dto.category.service;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ServiceGroupLevel2Dto extends BaseCategoryDto {

    public ServiceGroupLevel2Dto() {
    }

    private int sequenceNo;

    private Long serviceGroupLevel1Id;

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getServiceGroupLevel1Id() {
        return serviceGroupLevel1Id;
    }

    public void setServiceGroupLevel1Id(Long serviceGroupLevel1Id) {
        this.serviceGroupLevel1Id = serviceGroupLevel1Id;
    }
}
