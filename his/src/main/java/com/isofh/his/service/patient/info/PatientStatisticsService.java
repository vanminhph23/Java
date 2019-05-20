package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientStatisticsDto;
import com.isofh.his.model.patient.info.PatientStatistics;
import com.isofh.his.repository.patient.info.PatientStatisticsRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientStatisticsService extends BaseService<PatientStatistics, PatientStatisticsDto, PatientStatisticsRepository> {
    void countPatientHistoryInHospital(PatientStatistics statistics);
}
