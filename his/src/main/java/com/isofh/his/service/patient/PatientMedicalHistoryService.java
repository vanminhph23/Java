package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.info.PatientMedicalHistoryDto;
import com.isofh.his.model.patient.info.PatientMedicalHistory;
import com.isofh.his.repository.patient.PatientMedicalHistoryRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientMedicalHistoryService extends BaseService<PatientMedicalHistory, PatientMedicalHistoryDto, PatientMedicalHistoryRepository> {
}
