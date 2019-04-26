package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

public interface PatientHistoryService extends BaseService<PatientHistory, PatientHistoryDto, PatientHistoryRepository> {

    PatientHistory create(PatientHistoryDto phDto);

    PatientHistory update(PatientHistoryDto phDto);

    PatientHistory create(PatientHistory ph);

    PatientHistory update(PatientHistory ph);

    enum PatientType implements IEnum {
        SERVICE(1, "Service"), INSURANCE(2, "Insurance");

        int value;
        String name;

        PatientType(int value, String name) {
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
