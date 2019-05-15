package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.service.PatientInvoiceLineDto;
import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.patient.invoice.PatientInvoiceLineRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInvoiceLineServiceImpl implements PatientInvoiceLineService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInvoiceLineServiceImpl.class);

    @Autowired
    private PatientInvoiceLineRepository repository;

    @Override
    public PatientInvoiceLineRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInvoiceLine> getModelClass() {
        return PatientInvoiceLine.class;
    }

    @Override
    public Class<PatientInvoiceLineDto> getDtoClass() {
        return PatientInvoiceLineDto.class;
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
    public List<PatientInvoiceLine> findNotPaidServiceByPatient(Patient patient, Long patientHistoryId) {
        if (patientHistoryId == null) {
            patientHistoryId = Long.valueOf(0);
        }

        return getRepository().findNotPaidServiceByPatient(patient, patientHistoryId);
    }

    @Override
    public List<PatientInvoiceLine> findNotPaidServiceByInsuranceNumber(String insuranceNumber, Long patientHistoryId) {
        if (patientHistoryId == null) {
            patientHistoryId = Long.valueOf(0);
        }

        return getRepository().findNotPaidServiceByInsuranceNumber(insuranceNumber, patientHistoryId);
    }
}
