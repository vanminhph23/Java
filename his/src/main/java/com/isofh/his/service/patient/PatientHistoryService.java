package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientHistoryService extends BaseService<PatientHistory, PatientHistoryDto, PatientHistoryRepository> {
    default PatientHistoryDto create(PatientHistoryDto dto) {
        return getDto(create(getModel(dto)));
    }

    PatientHistory create(PatientHistory model);

    default PatientHistoryDto update(PatientHistoryDto dto) {
        return getDto(update(getModel(dto)));
    }

    PatientHistory update(PatientHistory model);
}
