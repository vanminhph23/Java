package com.isofh.his.service.core;

import com.isofh.his.dto.core.ReferenceDto;
import com.isofh.his.model.core.Reference;
import com.isofh.his.repository.core.ReferenceRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceImpl implements ReferenceService {

    private final static Logger logger = LoggerFactory.getLogger(ReferenceServiceImpl.class);

    @Autowired
    private ReferenceRepository repository;

    @Override
    public ReferenceRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Reference> getModelClass() {
        return Reference.class;
    }

    @Override
    public Class<ReferenceDto> getDtoClass() {
        return ReferenceDto.class;
    }

    @Override
    public Reference save(Reference model) {
        return repository.save(model);
    }

    @Override
    public Reference get(Long id) {
        return repository.findById(id).orElse(null);
    }

    ModelMapper modelMapper = null;
    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
        }

        return modelMapper;
    }
}
