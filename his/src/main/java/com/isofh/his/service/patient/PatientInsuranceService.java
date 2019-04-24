package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientInsuranceDto;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientInsuranceService extends BaseService<PatientInsurance, PatientInsuranceDto, PatientInsuranceRepository> {
}
