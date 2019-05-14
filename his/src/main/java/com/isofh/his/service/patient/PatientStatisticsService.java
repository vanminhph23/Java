package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.info.PatientStatisticsDto;
import com.isofh.his.repository.patient.PatientStatisticsRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientStatisticsService extends BaseService<PatientStatistics, PatientStatisticsDto, PatientStatisticsRepository> {
    void countPatientHistoryInHospital(PatientStatistics statistics);
}
