package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientInsuranceDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.repository.patient.info.PatientInsuranceRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.util.Date;

public interface PatientInsuranceService extends BaseService<PatientInsurance, PatientInsuranceDto, PatientInsuranceRepository> {

    String INSURANCE_PATTERN = "^[A-Z]{2}[0-9]{3}[A-Z0-9]{2}[0-9]{8}$";

    PatientInsurance findByValidDate(Long patientHistoryId, Date actDate);

    void validateInsuranceCard(PatientHistory history, PatientInsurance insurance, boolean ignoreValidatePortalInsurance);

    enum RegionValueEnum implements IEnum {
        K1(1, "K1"), K2(2, "K2"), K3(3, "K2"), Other(4, "Other");

        int value;
        String name;

        RegionValueEnum(int value, String name) {
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
