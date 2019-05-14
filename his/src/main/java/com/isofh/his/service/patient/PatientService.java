package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.info.PatientDto;
import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.repository.patient.PatientRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientService extends BaseService<Patient, PatientDto, PatientRepository> {

    boolean existsByPatientValue(String patientValue);

    Long findIdByPatientValue(String patientValue);

    Patient findByPatientValue(String patientValue);
}
