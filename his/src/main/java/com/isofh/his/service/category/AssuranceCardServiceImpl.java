package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.repository.category.AssuranceCardRepository;
import com.isofh.his.storage.FileSystemStorageService;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AssuranceCardServiceImpl implements AssuranceCardService {

    @Autowired
    private AssuranceCardRepository repository;

    @Override
    public Class<AssuranceCard> getModelClass() {
        return AssuranceCard.class;
    }

    @Override
    public Class<AssuranceCardDto> getDtoClass() {
        return AssuranceCardDto.class;
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
    public AssuranceCard get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AssuranceCard save(AssuranceCard model) {
        return repository.save(model);
    }
}
