package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class ResultTemplateDto extends BaseCategoryDto {

    public ResultTemplateDto() {
    }

    private int conclusion;

    private int result;

    public int getConclusion() {
        return conclusion;
    }

    public void setConclusion(int conclusion) {
        this.conclusion = conclusion;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
