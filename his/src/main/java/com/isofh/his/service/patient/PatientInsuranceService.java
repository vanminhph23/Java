package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientInsuranceDto;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.service.base.BaseService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface PatientInsuranceService extends BaseService<PatientInsurance, PatientInsuranceDto, PatientInsuranceRepository> {

    PatientInsurance findByValidDate(Long patientHistoryId, Date actDate);

    void validateInsuranceCard(PatientInsurance insurance);
}
