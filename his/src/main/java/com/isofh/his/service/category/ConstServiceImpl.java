package com.isofh.his.service.category;

import com.isofh.his.dto.category.ConstDto;
import com.isofh.his.model.category.Const;
import com.isofh.his.repository.category.ConstRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstServiceImpl implements ConstService {

    private final static Logger logger = LoggerFactory.getLogger(ConstServiceImpl.class);

    @Autowired
    private ConstRepository repository;

    @Autowired
    private HospitalService hospitalService;

    @Override
    public ConstRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Const> getModelClass() {
        return Const.class;
    }

    @Override
    public Class<ConstDto> getDtoClass() {
        return ConstDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    private Const get(String key) {
        return getRepository().findByName(key).orElse(null);
    }

    public Long getCurrentHospital() {
        Const c = get("CURRENT_HOSPITAL_VALUE");

        if (c != null && c.getValue() != null) {
            return hospitalService.findIdByValue(c.getValue());
        }

        return null;
    }

    public int getExtraInsurancePercent() {
        Const c = get("EXTRA_ASSURANCE_PERCENT");

        if (c != null && c.getValue() != null) {
            return Integer.parseInt(c.getValue());
        }

        return 40;
    }

    @Override
    public String getInsuranceUsername() {
        Const c = get("INSURANCE_USERNAME");

        if (c != null && c.getValue() != null){
            return  c.getValue();
        }

        return "01910_BV";
    }

    @Override
    public String getInsurancePassword() {
        Const c = get("INSURANCE_PASSWORD");

        if (c != null && c.getValue() != null){
            return  c.getValue();
        }

        return "93c674bbea62adf2a5d70252e612cccd";
    }
}
