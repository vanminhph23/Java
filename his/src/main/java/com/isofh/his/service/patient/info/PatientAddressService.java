package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientAddressDto;
import com.isofh.his.model.patient.info.PatientAddress;
import com.isofh.his.repository.patient.info.PatientAddressRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientAddressService extends BaseService<PatientAddress, PatientAddressDto, PatientAddressRepository> {

    void setAddress(PatientAddress address);

    String getAddress(Long countryId, Long provinceId, Long districtId, Long zoneId, String detail);

}
