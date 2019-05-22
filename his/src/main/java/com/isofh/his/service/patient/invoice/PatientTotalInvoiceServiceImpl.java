package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientTotalInvoiceDto;
import com.isofh.his.model.patient.invoice.PatientTotalInvoice;
import com.isofh.his.repository.patient.invoice.PatientTotalInvoiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientTotalInvoiceServiceImpl implements PatientTotalInvoiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientTotalInvoiceServiceImpl.class);

    @Autowired
    private PatientTotalInvoiceRepository repository;

    @Override
    public PatientTotalInvoiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientTotalInvoice> getModelClass() {
        return PatientTotalInvoice.class;
    }

    @Override
    public Class<PatientTotalInvoiceDto> getDtoClass() {
        return PatientTotalInvoiceDto.class;
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
