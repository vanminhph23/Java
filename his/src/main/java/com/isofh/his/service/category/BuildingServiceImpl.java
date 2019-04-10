package com.isofh.his.service.category;

import com.isofh.his.dto.category.BuildingDto;
import com.isofh.his.model.category.Building;
import com.isofh.his.repository.category.BuildingRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final static Logger logger = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private BuildingRepository repository;

    @Override
    public BuildingRepository getRepository() {
        return repository;
    }

    @Override
    public Class<Building> getModelClass() {
        return Building.class;
    }

    @Override
    public Class<BuildingDto> getDtoClass() {
        return BuildingDto.class;
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
    public Building get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Building save(Building model) {
        return BuildingService.super.save(model);
    }
}
