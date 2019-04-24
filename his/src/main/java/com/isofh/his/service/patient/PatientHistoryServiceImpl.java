package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientAddressRepository;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.repository.patient.PatientVitalSignRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
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
    private PatientInsuranceRepository insuranceRepository;

    @Autowired
    private PatientAddressService addressService;

    @Autowired
    private PatientVitalSignService vitalSignService;

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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.addMappings(new PropertyMap<PatientHistoryDto, PatientHistory>() {

                @Override
                protected void configure() {
                    map().getPatientAddress().setCountryId(source.getCountryId());
                    map().getPatientAddress().setProvinceId(source.getProvinceId());
                    map().getPatientAddress().setDistrictId(source.getDistrictId());
                    map().getPatientAddress().setZoneId(source.getZoneId());
                    map().getPatientAddress().setDetail(source.getDetail());
                }
            });
        }

        return modelMapper;
    }

    @Override
    public void beforeSave(PatientHistory model) {
        if (model.getPatientAddress() != null) {
            addressService.save(model.getPatientAddress());
        }

        model.getPatientAddress().setPatientHistory(model);
    }
}
