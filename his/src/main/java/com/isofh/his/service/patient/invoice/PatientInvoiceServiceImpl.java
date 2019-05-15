package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientInvoiceDto;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.patient.invoice.PatientInvoiceRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        }

        return modelMapper;
    }

    @Override
    public List<PatientInvoice> findByInsuranceNumberAndPayTime(String insuranceNumber, Date regDate, Long patientHistoryId, Pageable pageable) {
        return getRepository().findByInsuranceNumberAndPayTime(insuranceNumber, regDate, patientHistoryId, pageable);
    }
}
