package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.exception.data.NotFoundException;
import com.isofh.his.exception.data.NullValueException;
import com.isofh.his.exception.patient.DuplicateIdNoException;
import com.isofh.his.map.PropertyMapPatientHistoryToDto;
import com.isofh.his.model.patient.*;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import com.isofh.his.util.Util;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private final static Logger logger = LoggerFactory.getLogger(PatientHistoryServiceImpl.class);

    @Autowired
    private PatientInsuranceService insuranceService;

    @Autowired
    private PatientAddressService addressService;

    @Autowired
    private PatientGuardianService guardianService;

    @Autowired
    private PatientStatisticsService statisticsService;

    @Autowired
    private PatientUtil patientUtil;

    @Autowired
    private PatientHistoryRepository repository;

    @Override
    public PatientHistoryRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientHistory> getModelClass() {
        return PatientHistory.class;
    }

    @Override
    public Class<PatientHistoryDto> getDtoClass() {
        return PatientHistoryDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.addMappings(new PropertyMapPatientHistoryToDto());
        }

        return modelMapper;
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistoryDto historyDto) {
        PatientHistory history = getModel(historyDto);

        // Address
        PatientAddress address = new PatientAddress();
        history.setPatientAddress(address);

        address.setCountryId(historyDto.getCountryId());
        address.setProvinceId(historyDto.getProvinceId());
        address.setDistrictId(historyDto.getDistrictId());
        address.setZoneId(historyDto.getZoneId());
        address.setDetail(historyDto.getDetail());

        if (history.getPatientType() == null) {
            history.setPatientType(PatientTypeEnum.SERVICE.getValue());
        }

        if (history.getPatientType() != PatientTypeEnum.SERVICE.getValue() && history.getPatientType() != PatientTypeEnum.INSURANCE.getValue()) {
            throw new InvalidDataException("Patient type " + history.getPatientType());
        }

        // Address card
        if (history.getPatientType() == PatientTypeEnum.INSURANCE.getValue()) {
            PatientInsurance insurance = new PatientInsurance();
            history.setPatientInsurance(insurance);

            insurance.setAddress(historyDto.getInsuranceAddress());
            insurance.setAppliedToDate(historyDto.getInsuranceAppliedToDate());
            insurance.setAppliedFromDate(historyDto.getInsuranceAppliedFromDate());
            insurance.setAppointment(historyDto.isInsuranceAppointment());
            insurance.setContinuity5Year(historyDto.isInsuranceContinuity5Year());
            insurance.setEmergency(historyDto.isInsuranceEmergency());
            insurance.setExtra(historyDto.isInsuranceExtra());
            insurance.setHundredPercentHightech(historyDto.isInsuranceHundredPercentHightech());
            insurance.setInsuranceNumber(historyDto.getInsuranceNumber());
            insurance.setFromDate(historyDto.getInsuranceFromDate());
            insurance.setToDate(historyDto.getInsuranceToDate());
            insurance.setNotCopayment(historyDto.isInsuranceNotCoPayment());
            insurance.setNotCopaymentDate(historyDto.getInsuranceNotCopaymentDate());
            insurance.setRegAtHospitalId(historyDto.getInsuranceRegAtHospitalId());
            insurance.setPatientFromHospitalId(historyDto.getInsurancePatientFromHospitalId());
            insurance.setPercent(historyDto.getInsurancePercent());
            insurance.setReferral(historyDto.isInsuranceReferral());
            insurance.setRegionValue(historyDto.getInsuranceRegionValue());
            insurance.setKeeping(historyDto.isInsuranceKeeping());
        }

        // guardian
        if (historyDto.getGuardianIdNo() != null || historyDto.getGuardianName() != null || historyDto.getGuardianPhone() != null) {
            PatientGuardian guardian = new PatientGuardian();
            history.setPatientGuardian(guardian);
            guardian.setPatientHistory(history);

            guardian.setIdNo(historyDto.getGuardianIdNo());
            guardian.setName(historyDto.getGuardianName());
            guardian.setPhone(historyDto.getGuardianPhone());
        }

        return create(history);
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistory history) {
        validatePatientName(history);
        validatePhone(history);
        validateIdNo(history);

        PatientAddress address = history.getPatientAddress();
        if (address != null) {
            addressService.setAddress(address);
            addressService.save(address);
        }

        PatientInsurance insurance = history.getPatientInsurance();
        if (insurance != null) {
            insuranceService.save(insurance);
        }

        PatientGuardian guardian = history.getPatientGuardian();
        if (guardian != null) {
            guardianService.validateInfo(guardian);
        }

        if (history.isPatientInHospital() && insurance != null) {
            PatientStatistics statistics = new PatientStatistics();
            history.setPatientStatistics(statistics);
            statistics.setPatientHistory(history);
            statisticsService.countPatientHistoryInHospital(statistics);
        }

        history = save(history);

        return history;
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistoryDto historyDto) {
        PatientHistory ph = repository.findById(historyDto.getId()).orElseThrow(() -> new NotFoundException("Not found patient history id: " + historyDto.getId()));
        return update(ph);
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistory history) {
        return save(history);
    }

    @Override
    public boolean isInsurancePatient(PatientHistory history, Date actDate) {
        return PatientTypeEnum.INSURANCE.getValue() == getPatientType(history, actDate);
    }

    private int getPatientType(PatientHistory history, Date actDate) {
        PatientInsurance insurance = insuranceService.findByValidDate(history.getId(), DateUtil.truncateHour(actDate));

        if (insurance == null) {
            return PatientTypeEnum.SERVICE.getValue();
        }

        if (!history.isInpatient() && insurance.isExtra()) {
            return PatientTypeEnum.SERVICE.getValue();
        }

        return PatientTypeEnum.INSURANCE.getValue();
    }

    private void validatePatientName(PatientHistory history) {
        if (history.getPatientName() == null) {
            throw new NullValueException("Patient name is null");
        }

        history.setPatientName(patientUtil.formatName(history.getPatientName()));
    }

    private void validatePhone(PatientHistory history) {
        String phone = patientUtil.formatPhone(history.getPhone());

        if (phone == null) {
            throw new InvalidDataException("phone " + history.getPhone());
        }

        history.setPhone(phone);
    }

    private void validateIdNo(PatientHistory history) {
        if (history.isContract()) {
            return;
        }

        String idNo = patientUtil.formatIdNo(history.getIdNo());

        if (idNo == null) {
            throw new InvalidDataException("ID No " + history.getIdNo());
        }

        PatientHistory oldHistory = getRepository().findFirstByIdNo(idNo).orElse(null);

        if (oldHistory == null) {
            return;
        }

        String oldName = oldHistory.getPatientName();
        String name = history.getPatientName();

        if (!Util.deleteAccents(oldName).equals(Util.deleteAccents(name))) {
            throw new DuplicateIdNoException("Duplicate ID No: " + idNo + "Ma HS: " + oldHistory.getPatientDocument());
        }

        if (history.getPatientValue() == null || history.getPatientValue().isEmpty()) {
            history.setPatientValue(oldHistory.getPatientValue());
        } else if (!history.getPatientValue().equals(oldHistory.getPatientValue())) {
            throw new DuplicateIdNoException("Duplicate ID No: " + idNo + "Ma HS: " + oldHistory.getPatientDocument());
        }
    }
}
