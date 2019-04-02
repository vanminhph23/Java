package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.dto.category.DepartmentDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.model.category.Department;
import com.isofh.his.repository.category.AssuranceCardRepository;
import com.isofh.his.repository.category.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceCardServiceImpl implements AssuranceCardService {

    @Autowired
    private AssuranceCardRepository repository;

    @Override
    public AssuranceCard get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AssuranceCard save(AssuranceCard model) {
        return repository.save(model);
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
    public AssuranceCard getModel(AssuranceCardDto dto) {
        if (dto == null) {
            return null;
        }
        return getModelMapper().map(dto, AssuranceCard.class);
    }

    @Override
    public AssuranceCardDto getDto(AssuranceCard model) {
        if (model == null) {
            return null;
        }
        return getModelMapper().map(model, AssuranceCardDto.class);
    }
}
