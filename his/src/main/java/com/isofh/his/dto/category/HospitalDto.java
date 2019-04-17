package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;
import com.isofh.his.model.category.District;
import com.isofh.his.model.category.Province;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class HospitalDto extends BaseCategoryDto {

    public HospitalDto() {
    }

    private Long provinceId;

    private ProvinceDto provinceDto;

    private int level;

    private String rank;

    private String address;

    private int note;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public ProvinceDto getProvinceDto() {
        return provinceDto;
    }

    public void setProvinceDto(ProvinceDto provinceDto) {
        this.provinceDto = provinceDto;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
