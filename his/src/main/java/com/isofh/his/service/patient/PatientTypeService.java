package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientTypeDto;
import com.isofh.his.model.patient.Patient;
import com.isofh.his.model.patient.PatientType;
import com.isofh.his.repository.patient.PatientTypeRepository;
import com.isofh.his.service.base.BaseService;

import java.util.Date;

public interface PatientTypeService extends BaseService<PatientType, PatientTypeDto, PatientTypeRepository> {

    PatientType getByActDate(int patientHistoryId, Date actDate);
}
