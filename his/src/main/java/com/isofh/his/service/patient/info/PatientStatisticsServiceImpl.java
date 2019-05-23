package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientStatisticsDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientStatistics;
import com.isofh.his.repository.patient.info.PatientStatisticsRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public void countPatientHistoryInHospital(PatientStatistics statistics) {
        PatientHistory history = statistics.getPatientHistory();

        int countIns = PatientHistoryService.PatientTypeEnum.BAO_HIEM.getValue() == history.getPatientType() ? 1 : 0;
        statistics.setOutpatientTimes(repository.countOutPatientByPatientValue(history.getPatientValue()) + 1);
        statistics.setInsOutpatientTimes(repository.countInsOutPatientByPatientValue(history.getPatientValue()) + countIns);
        statistics.setInsOutpatientTimesMonth(repository.countInsOutPatientByPatientValueMonth(history.getPatientValue(), DateUtil.getMonth(history.getRegDate())) + countIns);
        statistics.setInsOutpatientTimesYear(repository.countInsOutPatientByPatientValueYear(history.getPatientValue(), DateUtil.getYear(history.getRegDate())) + countIns);
    }
}
