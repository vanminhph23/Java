package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientTypeDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.repository.patient.info.PatientTypeRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientTypeServiceImpl implements PatientTypeService {

    private final static Logger logger = LoggerFactory.getLogger(PatientTypeServiceImpl.class);

    @Autowired
    private PatientTypeRepository repository;

    @Override
    public PatientTypeRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientType> getModelClass() {
        return PatientType.class;
    }

    @Override
    public Class<PatientTypeDto> getDtoClass() {
        return PatientTypeDto.class;
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

    @Override
    public PatientType findByValidDate(Long patientHistoryId, Date actDate) {
        List<PatientType> list = getRepository().findByValidDate(patientHistoryId, DateUtil.truncateHour(actDate), PageRequest.of(0, 1, Sort.by("percent").descending()));

        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }
}
