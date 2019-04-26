package com.isofh.his.dto.patient;

import com.isofh.his.dto.base.BaseCategoryDto;

public class PatientStatisticsDto extends BaseCategoryDto {

    public PatientStatisticsDto() {
    }

    private Long patientHistoryId;

    private Integer outpatientTimes;

    private Integer insOutpatientTimes;

    private Integer insOutpatientTimesMonth;

    private Integer insOutpatientTimesYear;

    public Long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(Long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public Integer getOutpatientTimes() {
        return outpatientTimes;
    }

    public void setOutpatientTimes(Integer outpatientTimes) {
        this.outpatientTimes = outpatientTimes;
    }

    public Integer getInsOutpatientTimes() {
        return insOutpatientTimes;
    }

    public void setInsOutpatientTimes(Integer insOutpatientTimes) {
        this.insOutpatientTimes = insOutpatientTimes;
    }

    public Integer getInsOutpatientTimesMonth() {
        return insOutpatientTimesMonth;
    }

    public void setInsOutpatientTimesMonth(Integer insOutpatientTimesMonth) {
        this.insOutpatientTimesMonth = insOutpatientTimesMonth;
    }

    public Integer getInsOutpatientTimesYear() {
        return insOutpatientTimesYear;
    }

    public void setInsOutpatientTimesYear(Integer insOutpatientTimesYear) {
        this.insOutpatientTimesYear = insOutpatientTimesYear;
    }
}
