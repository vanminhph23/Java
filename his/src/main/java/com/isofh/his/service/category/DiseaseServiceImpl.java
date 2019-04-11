package com.isofh.his.service.category;

import com.isofh.his.dto.category.DiseaseDto;
import com.isofh.his.model.category.Disease;
import com.isofh.his.repository.category.DiseaseRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    private final static Logger logger = LoggerFactory.getLogger(DiseaseServiceImpl.class);

    @Autowired
    private DiseaseRepository repository;

    @Override
    public DiseaseRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Disease> getModelClass() {
        return Disease.class;
    }

    @Override
    public Class<DiseaseDto> getDtoClass() {
        return DiseaseDto.class;
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
    public Disease get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Disease save(Disease model) {
        return DiseaseService.super.save(model);
    }
}
