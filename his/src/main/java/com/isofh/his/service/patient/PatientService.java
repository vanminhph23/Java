package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientDto;
import com.isofh.his.model.patient.Patient;
import com.isofh.his.repository.patient.PatientRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientService extends BaseService<Patient, PatientDto, PatientRepository> {
}
