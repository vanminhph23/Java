package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.info.PatientGuardianDto;
import com.isofh.his.model.patient.info.PatientGuardian;
import com.isofh.his.repository.patient.PatientGuardianRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientGuardianService extends BaseService<PatientGuardian, PatientGuardianDto, PatientGuardianRepository> {

    void validateInfo(PatientGuardian guardian);
}
