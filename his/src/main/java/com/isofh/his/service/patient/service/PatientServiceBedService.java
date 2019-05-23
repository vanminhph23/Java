package com.isofh.his.service.patient.service;

import com.isofh.his.dto.patient.service.PatientServiceBedDto;
import com.isofh.his.dto.patient.service.PatientServiceProductDto;
import com.isofh.his.model.patient.service.PatientServiceBed;
import com.isofh.his.model.patient.service.PatientServiceProduct;
import com.isofh.his.repository.patient.service.PatientServiceBedRepository;
import com.isofh.his.repository.patient.service.PatientServiceProductRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientServiceBedService extends BaseService<PatientServiceBed, PatientServiceBedDto, PatientServiceBedRepository> {
}
