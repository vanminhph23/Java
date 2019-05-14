package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientMedicalHistoryDto;
import com.isofh.his.model.patient.info.PatientMedicalHistory;
import com.isofh.his.repository.patient.info.PatientMedicalHistoryRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientMedicalHistoryService extends BaseService<PatientMedicalHistory, PatientMedicalHistoryDto, PatientMedicalHistoryRepository> {
}
