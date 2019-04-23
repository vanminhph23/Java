package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryServiceImpl.class);

    @Autowired
    private PatientHistoryRepository repository;

    @Override
    public PatientHistoryRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientHistory> getModelClass() {
        return PatientHistory.class;
    }

    @Override
    public Class<PatientHistoryDto> getDtoClass() {
        return PatientHistoryDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<PatientHistoryDto, PatientHistory>() {

                @Override
                protected void configure() {
                    map().getPatientAddress().setCountryId(source.getCountryId());
                    map().getPatientAddress().setProvinceId(source.getProvinceId());
                    map().getPatientAddress().setDistrictId(source.getDistrictId());
                    map().getPatientAddress().setZoneId(source.getZoneId());
                    map().getPatientAddress().setDetail(source.getDetail());

                    map().getPatientInsurance().setInsuranceNumber(source.getInsuranceNumber());
                    map().getPatientInsurance().setInsuranceFromDate(source.getInsuranceFromDate());
                    map().getPatientInsurance().setInsuranceAddress(source.getInsuranceAddress());
                }
            });
        }

        return modelMapper;
    }
}
