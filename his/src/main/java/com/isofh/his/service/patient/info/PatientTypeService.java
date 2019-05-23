package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientTypeDto;
import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.repository.patient.info.PatientTypeRepository;
import com.isofh.his.service.base.BaseService;

import java.util.Date;

public interface PatientTypeService extends BaseService<PatientType, PatientTypeDto, PatientTypeRepository> {

    PatientType findByValidDate(Long patientHistoryId, Date actDate);
}
