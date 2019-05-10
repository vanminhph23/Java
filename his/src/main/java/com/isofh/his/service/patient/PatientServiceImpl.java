package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientDto;
import com.isofh.his.model.patient.Patient;
import com.isofh.his.repository.patient.PatientRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final static Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientRepository repository;

    @Override
    public PatientRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<Patient> getModelClass() {
        return Patient.class;
    }

    @Override
    public Class<PatientDto> getDtoClass() {
        return PatientDto.class;
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
    public boolean existsByPatientValue(String patientValue) {
        return repository.existsByPatientValue(patientValue);
    }

    @Override
    public Long findIdByPatientValue(String patientValue) {
        return getRepository().findIdByPatientValue(patientValue).orElse(null);
    }

    @Override
    public Patient findByPatientValue(String patientValue) {
        return getRepository().findByPatientValue(patientValue).orElse(null);
    }
}
