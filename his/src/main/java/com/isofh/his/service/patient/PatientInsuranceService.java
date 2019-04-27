package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientInsuranceDto;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface PatientInsuranceService extends BaseService<PatientInsurance, PatientInsuranceDto, PatientInsuranceRepository> {

    String INSURANCE_PATTERN = "^[A-Z]{2}[0-9]{3}[A-Z0-9]{2}[0-9]{8}$";

    PatientInsurance findByValidDate(Long patientHistoryId, Date actDate);

    void validateInsuranceCard(PatientInsurance insurance);

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
