package com.isofh.his.service.base;

import com.isofh.his.dto.base.ReferenceListDto;
import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.repository.base.ReferenceListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceListServiceImpl implements ReferenceListService {

    @Autowired
    private ReferenceListRepository repository;

    @Override
    public ReferenceList create(ReferenceList model) {
        return repository.save(model);
    }

    @Override
    public ReferenceList get(Long id) {
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

    @Override
    public ReferenceList getModel(ReferenceListDto dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, ReferenceList.class);
    }

    @Override
    public ReferenceListDto getDto(ReferenceList model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, ReferenceListDto.class);
    }
}
