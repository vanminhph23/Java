package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientPaymentDto;
import com.isofh.his.model.patient.invoice.PatientPayment;
import com.isofh.his.repository.patient.invoice.PatientPaymentRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientPaymentServiceImpl implements PatientPaymentService {

    private final static Logger logger = LoggerFactory.getLogger(PatientPaymentServiceImpl.class);

    @Autowired
    private PatientPaymentRepository repository;

    @Override
    public PatientPaymentRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientPayment> getModelClass() {
        return PatientPayment.class;
    }

    @Override
    public Class<PatientPaymentDto> getDtoClass() {
        return PatientPaymentDto.class;
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
