package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientInvoiceDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.patient.invoice.PatientInvoiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientInvoiceServiceImpl implements PatientInvoiceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInvoiceServiceImpl.class);

    @Autowired
    private PatientInvoiceRepository repository;

    @Override
    public PatientInvoiceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInvoice> getModelClass() {
        return PatientInvoice.class;
    }

    @Override
    public Class<PatientInvoiceDto> getDtoClass() {
        return PatientInvoiceDto.class;
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
    public PatientInvoice findByPatientHistory(PatientHistory history, Integer invoiceType, Long patientTypeId, boolean contract, boolean paid) {
        if (history == null || history.getId() == null || history.getId() <= 0) {
            return null;
        }

        if (invoiceType == null) {
            return null;
        }

        if (patientTypeId == null) {
            patientTypeId = 0L;
        }

        return getRepository().findByPatientHistory(history, invoiceType, patientTypeId, contract, paid);
    }

}
