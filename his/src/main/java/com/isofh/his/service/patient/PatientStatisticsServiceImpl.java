package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientStatisticsDto;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.patient.PatientStatisticsRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientStatisticsServiceImpl implements PatientStatisticsService {

    private final static Logger logger = LoggerFactory.getLogger(PatientStatisticsServiceImpl.class);

    @Autowired
    private PatientStatisticsRepository repository;

    @Override
    public PatientStatisticsRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Autowired
    private PatientHistoryService historyService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientStatistics> getModelClass() {
        return PatientStatistics.class;
    }

    @Override
    public Class<PatientStatisticsDto> getDtoClass() {
        return PatientStatisticsDto.class;
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
    public void countPatientHistoryInHospital(PatientStatistics statistics) {
        PatientHistory history = statistics.getPatientHistory();

        int countIns = historyService.isInsurancePatient(history, history.getTimeGoIn()) ? 1 : 0;
        statistics.setOutpatientTimes(repository.countOutPatientByPatientValue(history.getPatientValue()) + 1);
        statistics.setInsOutpatientTimes(repository.countInsOutPatientByPatientValue(history.getPatientValue()) + countIns);
        statistics.setInsOutpatientTimesMonth(repository.countInsOutPatientByPatientValueMonth(history.getPatientValue(), history.getRegDate()) + countIns);
        statistics.setInsOutpatientTimesYear(repository.countInsOutPatientByPatientValueYear(history.getPatientValue(), history.getRegDate()) + countIns);
    }
}
