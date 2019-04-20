package com.isofh.his.service.category;

import com.isofh.his.dto.category.InsuranceCardDto;
import com.isofh.his.model.category.InsuranceCard;
import com.isofh.his.repository.category.InsuranceCardRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.importdata.Header;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceCardServiceImpl implements InsuranceCardService {

    private final static Logger logger = LoggerFactory.getLogger(InsuranceCardServiceImpl.class);

    @Autowired
    private InsuranceCardRepository repository;

    @Autowired
    private JobService jobService;

    @Override
    public InsuranceCardRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<InsuranceCard> getModelClass() {
        return InsuranceCard.class;
    }

    @Override
    public Class<InsuranceCardDto> getDtoClass() {
        return InsuranceCardDto.class;
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
    public Long convert(Header header, String value) {
        if (value == null) {
            return null;
        }

        if ("jobId".equals(header.getColumnName())) {
            if ("value".equals(header.getLinkColumnName())) {
                return jobService.findIdByValue(value);
            } else if ("name".equals(header.getLinkColumnName())) {
                return jobService.findIdByName(value);
            }
        }

        return null;
    }
}
