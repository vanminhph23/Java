package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientAddressDto;
import com.isofh.his.model.patient.info.PatientAddress;
import com.isofh.his.repository.patient.PatientAddressRepository;
import com.isofh.his.service.category.CountryService;
import com.isofh.his.service.category.DistrictService;
import com.isofh.his.service.category.ProvinceService;
import com.isofh.his.service.category.ZoneService;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientAddressServiceImpl implements PatientAddressService {

    private final static Logger logger = LoggerFactory.getLogger(PatientAddressServiceImpl.class);

    @Autowired
    private PatientAddressRepository repository;

    @Override
    public PatientAddressRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CountryService countryService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientAddress> getModelClass() {
        return PatientAddress.class;
    }

    @Override
    public Class<PatientAddressDto> getDtoClass() {
        return PatientAddressDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    public void setAddress(PatientAddress address) {
        address.setAddress(getAddress(address.getCountryId(), address.getProvinceId(), address.getDistrictId(), address.getZoneId(), address.getDetail()));
    }

    public String getAddress(Long countryId, Long provinceId, Long districtId, Long zoneId, String detail) {
        StringBuilder address = new StringBuilder();
        if (detail != null && !detail.isEmpty()) {
            address.append(detail + ", ");
        }

        if (zoneId > 0) {
            String zone = zoneService.findNameById(zoneId);
            if (zone != null) {
                address.append(zone + ", ");
            }
        }

        if (districtId > 0) {
            String district = districtService.findNameById(districtId);
            if (district != null) {
                address.append(district + ", ");
            }
        }

        if (provinceId > 0) {
            String province = provinceService.findNameById(provinceId);
            if (province != null) {
                address.append(province + ", ");
            }
        }

        if (countryId > 0) {
            String country = countryService.findNameById(provinceId);
            if (country != null) {
                address.append(country);
            }
        }
        return address.toString();
    }
}
