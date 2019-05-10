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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
    private PatientTypeService typeService;

    @Autowired
    private PatientService patientService;

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

        // birthday
        if (historyDto.getBirthdayStr() != null) {
            String birthdayStr = historyDto.getBirthdayStr();
            if (birthdayStr.length() == 4) {
                history.setOnlyYearBirth(true);
            } else {
                history.setOnlyYearBirth(false);
            }

            try {
                history.setBirthday(DateUtil.parseValidDate(birthdayStr));
            } catch (ParseException e) {
                throw new InvalidDataException("Birthday " + birthdayStr);
            }
        }

        return create(history);
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistory history) {
        autoFillDefaultFields(history);

        validatePatientName(history);
        validatePhone(history);
        validateIdNo(history);

        createPatientAddress(history);
        createPatientInsurance(history);
        createPatientGuardian(history);
        createPatientStatistics(history);

        createPatient(history);

        history = save(history);

        createPatientType(history);

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
    public PatientHistory findFirstByIdNo(String idNo) {
        List<PatientHistory> list = getRepository().findByIdNo(idNo, PageRequest.of(0, 1, Sort.by("id").descending()));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean isInsurancePatient(PatientHistory history, Date actDate) {
        return PatientTypeEnum.INSURANCE.getValue() == getPatientType(history, actDate);
    }

    private Patient createPatient(PatientHistory history) {
        String patientValue = history.getPatientValue();
        if (patientValue != null) {
            Patient patient = history.getPatient();

            if (patient == null) {
                patient = patientService.findByPatientValue(patientValue);
                if (patient == null) {
                    throw new NotFoundException("Not found patient value: " + patientValue);
                }

                history.setPatient(patient);
                return patient;
            } else if (patient != null && !patientValue.equals(patient.getPatientValue())) {
                throw new InvalidDataException("Not match patient value: " + patientValue + " and " + patient.getPatientValue());
            } else {
                return patient;
            }
        } else {
            Patient patient = new Patient();

            PatientAddress address = history.getPatientAddress();
            patient.setAddress(address == null ? null : address.getAddress());

            patient.setBirthday(history.getBirthday());
            patient.setGender(history.getGender());
            patient.setIdNo(history.getIdNo());

            PatientInsurance insurance = history.getPatientInsurance();
            patient.setInsuranceNumber(insurance == null ? null : insurance.getInsuranceNumber());

            patient.setPatientName(history.getPatientName());
            patient.setPatientValue(history.getPatientValue());

            patient.setRegDate(history.getRegDate());

            patientService.save(patient);

            history.setPatient(patient);
            return patient;
        }
    }

    private PatientAddress createPatientAddress(PatientHistory history) {
        PatientAddress address = history.getPatientAddress();
        if (address != null) {
            addressService.setAddress(address);
            addressService.save(address);
        }

        return address;
    }

    private PatientInsurance createPatientInsurance(PatientHistory history) {
        PatientInsurance insurance = history.getPatientInsurance();
        if (insurance != null) {
            insuranceService.validateInsuranceCard(history, insurance);
            insuranceService.save(insurance);
        }

        return insurance;
    }

    private PatientGuardian createPatientGuardian(PatientHistory history) {
        PatientGuardian guardian = history.getPatientGuardian();
        if (guardian != null) {
            guardianService.validateInfo(guardian);
        }

        return guardian;
    }

    private PatientStatistics createPatientStatistics(PatientHistory history) {
        if (!history.isPatientInHospital()) {
            return null;
        }

        PatientStatistics statistics = new PatientStatistics();
        history.setPatientStatistics(statistics);
        statistics.setPatientHistory(history);
        statisticsService.countPatientHistoryInHospital(statistics);

        return statistics;
    }

    private PatientType createPatientType(PatientHistory history) {
        PatientInsurance insurance = history.getPatientInsurance();

        PatientType type = new PatientType();
        type.setPatientHistory(history);
        if (insurance != null) {
            type.setPatientInsurance(insurance);
            type.setPatientType(PatientTypeEnum.INSURANCE.getValue());
        } else {
            type.setPatientType(PatientTypeEnum.SERVICE.getValue());
        }

        typeService.save(type);

        return type;
    }

    private void autoFillDefaultFields(PatientHistory history) {
        if (history.getTimeGoIn() == null) {
            history.setTimeGoIn(DateUtil.getNow());
        }

        if (history.getRegDate() == null) {
            history.setRegDate(history.getTimeGoIn());
        }
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

        PatientHistory oldHistory = findFirstByIdNo(idNo);

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
            history.setPatient(oldHistory.getPatient());
        } else if (!history.getPatientValue().equals(oldHistory.getPatientValue())) {
            throw new DuplicateIdNoException("Duplicate ID No: " + idNo + "Ma HS: " + oldHistory.getPatientDocument());
        }
    }
}
