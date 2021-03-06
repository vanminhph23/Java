package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientInsuranceDto;
import com.isofh.his.dto.patient.info.SimpleInsurancePatientHistoryDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.repository.patient.info.PatientInsuranceRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.util.Date;

public interface PatientInsuranceService extends BaseService<PatientInsurance, PatientInsuranceDto, PatientInsuranceRepository> {

    String INSURANCE_PATTERN = "^[A-Z]{2}[0-9]{3}[A-Z0-9]{2}[0-9]{8}$";

    void validateInsuranceCard(PatientHistory history, PatientInsurance insurance, boolean ignoreValidatePortalInsurance);

    SimpleInsurancePatientHistoryDto getSimpleInsurancePatientHistoryDto(PatientInsurance insurance);

    enum RegionValueEnum implements IEnum {
        K1(10), K2(20), K3(30), KHAC(40);

        int value;

        RegionValueEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
}
