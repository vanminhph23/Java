package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class InsuranceCardDto extends BaseCategoryDto {

    public InsuranceCardDto() {
    }

    private int percent;

    private Long jobId;

    private JobDto job;

    private String description;

    private boolean checkIgnore;
}
