package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientVitalSignDto;
import com.isofh.his.model.patient.info.PatientVitalSign;
import com.isofh.his.repository.patient.PatientVitalSignRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientVitalSignService extends BaseService<PatientVitalSign, PatientVitalSignDto, PatientVitalSignRepository> {
}
