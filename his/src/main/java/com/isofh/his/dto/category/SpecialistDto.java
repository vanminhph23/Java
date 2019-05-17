package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class SpecialistDto extends BaseCategoryDto {

    public SpecialistDto() {
    }

    private int sequenceNo;

    private String note;

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
