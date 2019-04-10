package com.isofh.his.service.category;

import com.isofh.his.dto.category.AssuranceCardDto;
import com.isofh.his.model.category.AssuranceCard;
import com.isofh.his.repository.category.AssuranceCardRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceCardServiceImpl implements AssuranceCardService {

    private final static Logger logger = LoggerFactory.getLogger(AssuranceCardServiceImpl.class);

    @Autowired
    private AssuranceCardRepository repository;

    @Autowired
    private JobService jobService;

    @Override
    public AssuranceCardRepository getRepository() {
        return repository;
    }

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

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }

    @Override
    public AssuranceCard get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AssuranceCard save(AssuranceCard model) {
        return AssuranceCardService.super.save(model);
    }

    @Override
    public Long convert(String header, String value) {
        if (value == null) {
            return null;
        }

        if ("jobId[value]".equals(header)) {
            return jobService.findIdByValue(value);
        } else if ("jobId[name]".equals(header)) {
            return jobService.findIdByName(value);
        }

        return null;
    }
}
