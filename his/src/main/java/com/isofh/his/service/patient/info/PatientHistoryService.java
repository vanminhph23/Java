package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientHistoryDto;
import com.isofh.his.dto.patient.info.SimpleInsurancePatientHistoryDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.repository.patient.info.PatientHistoryRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.util.Date;

public interface PatientHistoryService extends BaseService<PatientHistory, PatientHistoryDto, PatientHistoryRepository> {

    PatientHistory create(PatientHistory history, boolean ignoreValidatePortalInsurance);

    PatientHistory update(PatientHistory history, boolean ignoreValidatePortalInsurance);

    PatientHistory findLastByIdNo(String idNo);

    PatientHistory findLastByPatientValue(String patientValue);

    SimpleInsurancePatientHistoryDto getSimpleInsurancePatientHistoryDto(PatientHistory history);

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

    enum PatientStateEnum implements IEnum {
        NEW(1, "New"), PAID_OUT(30, "PaidOut"), PAID_OUT_AND_APPOINTMENT(31, "PaidOutAndAppointment");

        private int value;
        private String name;

        PatientStateEnum(int value, String name) {
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
