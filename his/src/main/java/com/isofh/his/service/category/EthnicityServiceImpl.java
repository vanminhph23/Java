package com.isofh.his.service.category;

import com.isofh.his.dto.category.EthnicityDto;
import com.isofh.his.model.category.Ethnicity;
import com.isofh.his.repository.category.EthnicityRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EthnicityServiceImpl implements EthnicityService {

    private final static Logger logger = LoggerFactory.getLogger(EthnicityServiceImpl.class);

    @Autowired
    private EthnicityRepository repository;

    @Override
    public EthnicityRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Ethnicity> getModelClass() {
        return Ethnicity.class;
    }

    @Override
    public Class<EthnicityDto> getDtoClass() {
        return EthnicityDto.class;
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }

    @Override
    public Ethnicity get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Ethnicity save(Ethnicity model) {
        return EthnicityService.super.save(model);
    }
}
