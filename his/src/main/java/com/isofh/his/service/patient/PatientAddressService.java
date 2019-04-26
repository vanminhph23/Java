package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientAddressDto;
import com.isofh.his.model.patient.PatientAddress;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientAddressRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientAddressService extends BaseService<PatientAddress, PatientAddressDto, PatientAddressRepository> {

    void setAddress(PatientAddress address);

    String getAddress(Long countryId, Long provinceId, Long districtId, Long zoneId, String detail);

}
