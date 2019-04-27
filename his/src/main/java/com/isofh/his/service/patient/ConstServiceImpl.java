package com.isofh.his.service.patient;

import com.isofh.his.dto.core.ConstDto;
import com.isofh.his.model.core.Const;
import com.isofh.his.repository.core.ConstRepository;
import com.isofh.his.service.category.HospitalService;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
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
        }

        return modelMapper;
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
}
