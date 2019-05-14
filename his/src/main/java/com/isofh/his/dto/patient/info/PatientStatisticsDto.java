package com.isofh.his.dto.patient.info;

import com.isofh.his.dto.base.BaseDto;

public class PatientStatisticsDto extends BaseDto {

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
