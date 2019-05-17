package com.isofh.his.dto.category.service;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ServiceGroupLevel3Dto extends BaseCategoryDto {

    public ServiceGroupLevel3Dto() {
    }

    private int sequenceNo;

    private Long serviceGroupLevel2Id;

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getServiceGroupLevel2Id() {
        return serviceGroupLevel2Id;
    }

    public void setServiceGroupLevel2Id(Long serviceGroupLevel2Id) {
        this.serviceGroupLevel2Id = serviceGroupLevel2Id;
    }
}
