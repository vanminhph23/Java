package com.isofh.his.service.category;

import com.isofh.his.dto.category.SpecialistDto;
import com.isofh.his.dto.category.ZoneDto;
import com.isofh.his.model.category.Specialist;
import com.isofh.his.model.category.Zone;
import com.isofh.his.repository.category.SpecialistRepository;
import com.isofh.his.repository.category.ZoneRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistServiceImpl implements SpecialistService {

    private final static Logger logger = LoggerFactory.getLogger(SpecialistServiceImpl.class);

    @Autowired
    private SpecialistRepository repository;

    @Override
    public SpecialistRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Specialist> getModelClass() {
        return Specialist.class;
    }

    @Override
    public Class<SpecialistDto> getDtoClass() {
        return SpecialistDto.class;
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
    public Specialist get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Specialist save(Specialist model) {
        return SpecialistService.super.save(model);
    }
}
