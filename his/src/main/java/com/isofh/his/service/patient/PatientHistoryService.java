package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.sql.Timestamp;
import java.util.Date;

public interface PatientHistoryService extends BaseService<PatientHistory, PatientHistoryDto, PatientHistoryRepository> {

    Long create(PatientHistoryDto historyDto);

    PatientHistory update(PatientHistoryDto historyDto);

    Long create(PatientHistory history);

    PatientHistory update(PatientHistory history);

    PatientHistory findFirstByIdNo(String idNo);

    boolean isInsurancePatient(PatientHistory history, Date actDate);

    enum PatientTypeEnum implements IEnum {
        SERVICE(1, "Service"), INSURANCE(2, "Insurance");

        private int value;
        private String name;

        PatientTypeEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
