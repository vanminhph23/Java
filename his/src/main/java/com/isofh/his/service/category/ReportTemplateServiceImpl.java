package com.isofh.his.service.category;

import com.isofh.his.dto.category.ReportTemplateDto;
import com.isofh.his.model.category.ReportTemplate;
import com.isofh.his.repository.category.ReportTemplateRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final static Logger logger = LoggerFactory.getLogger(ReportTemplateServiceImpl.class);

    @Autowired
    private ReportTemplateRepository repository;

    @Override
    public ReportTemplateRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<ReportTemplate> getModelClass() {
        return ReportTemplate.class;
    }

    @Override
    public Class<ReportTemplateDto> getDtoClass() {
        return ReportTemplateDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
