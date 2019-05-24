package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientHistoryDto;
import com.isofh.his.dto.patient.info.SimpleInsurancePatientHistoryDto;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.exception.data.NotFoundException;
import com.isofh.his.exception.data.NullValueException;
import com.isofh.his.exception.patient.DuplicateIdNoException;
import com.isofh.his.exception.patient.PatientNotPaidException;
import com.isofh.his.map.PropertyMapPatientHistoryToDto;
import com.isofh.his.model.patient.info.*;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.patient.info.PatientHistoryRepository;
import com.isofh.his.service.patient.invoice.PatientInvoiceLineService;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import com.isofh.his.util.PatientUtil;
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
import java.util.*;

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
    private PatientInvoiceLineService invoiceLineService;

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

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public SimpleInsurancePatientHistoryDto getSimpleInsurancePatientHistoryDto(PatientHistory history) {
        ModelMapper patientHistoryMapper = new ModelMapper();
        patientHistoryMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return patientHistoryMapper.map(history, SimpleInsurancePatientHistoryDto.class);
    }

    @Transactional
    @Override
    public PatientHistoryDto createDto(PatientHistoryDto historyDto) {
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
            history.setPatientType(PatientTypeEnum.DICH_VU.getValue());
        }

        if (history.getPatientType() != PatientTypeEnum.DICH_VU.getValue() && history.getPatientType() != PatientTypeEnum.BAO_HIEM.getValue()) {
            throw new InvalidDataException("Patient type " + history.getPatientType());
        }

        // Address card
        if (history.getPatientType() == PatientTypeEnum.BAO_HIEM.getValue()) {
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

        history = create(history, historyDto.isIgnoreValidatePortalInsurance());

        return getDto(findById(history.getId()));
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistory history, boolean ignoreValidatePortalInsurance) {
        validateIdBeforeCreate(history);

        autoFillDefaultFields(history);

        validatePatientName(history);
        validatePhone(history);
        validateIdNo(history);

        createPatientAddress(history);
        createPatientInsurance(history, ignoreValidatePortalInsurance);
        createPatientGuardian(history);
        createPatientStatistics(history);

        validatePreviousPayment(history);

        validatePreviousInpatientInHospital(history);

        createPatient(history);

        history = save(history);

        createPatientType(history);

        return history;
    }

    @Transactional
    @Override
    public PatientHistoryDto updateDto(PatientHistoryDto historyDto) {
        PatientHistory history = getModel(historyDto);

        history = update(history, historyDto.isIgnoreValidatePortalInsurance());

        return getDto(history);
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistory history, boolean ignoreValidatePortalInsurance) {
        validateIdBeforeUpdate(history);

        return save(history);
    }

    @Override
    public PatientHistory findLastByIdNo(String idNo) {
        List<PatientHistory> list = getRepository().findByIdNo(idNo, PageRequest.of(0, 1, Sort.by("id").descending()));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public PatientHistory findLastByPatientValue(String patientValue) {
        List<PatientHistory> list = getRepository().findByPatientValue(patientValue, PageRequest.of(0, 1, Sort.by("id").descending()));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean isInsurancePatient(PatientHistory history, Date actDate) {
        return PatientTypeEnum.BAO_HIEM.getValue() == getPatientType(history, actDate);
    }

    @Override
    public boolean isInsurancePatient(PatientType patientType, boolean inPatient) {
        return PatientTypeEnum.BAO_HIEM.getValue() == getPatientType(patientType, inPatient);
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

            history.setPatient(patient);
            return patient;
        }
    }

    private PatientAddress createPatientAddress(PatientHistory history) {
        PatientAddress address = history.getPatientAddress();
        if (address != null) {
            addressService.setAddress(address);
        }

        return address;
    }

    private PatientInsurance createPatientInsurance(PatientHistory history, boolean ignoreValidatePortalInsurance) {
        PatientInsurance insurance = history.getPatientInsurance();
        if (insurance != null) {
            insuranceService.validateInsuranceCard(history, insurance, ignoreValidatePortalInsurance);
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
            type.setPatientType(PatientTypeEnum.BAO_HIEM.getValue());
        } else {
            type.setPatientType(PatientTypeEnum.DICH_VU.getValue());
        }

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
        PatientType patientType = typeService.findByValidDate(history.getId(), DateUtil.truncateHour(actDate));

        return getPatientType(patientType, history.isInpatient());
    }

    private int getPatientType(PatientType patientType, boolean inpatient) {

        if (patientType == null || patientType.getPatientType() == PatientTypeEnum.DICH_VU.getValue()) {
            return PatientTypeEnum.DICH_VU.getValue();
        }

        if (!inpatient && patientType.getPatientInsurance().isExtra()) {
            return PatientTypeEnum.DICH_VU.getValue();
        }

        return PatientTypeEnum.BAO_HIEM.getValue();
    }

    private void validatePatientName(PatientHistory history) {
        if (history.getPatientName() == null) {
            throw new NullValueException("Patient name is null");
        }

        history.setPatientName(PatientUtil.formatName(history.getPatientName()));
    }

    private void validatePhone(PatientHistory history) {
        String phone = PatientUtil.formatPhone(history.getPhone());

        if (phone == null) {
            throw new InvalidDataException("phone " + history.getPhone());
        }

        history.setPhone(phone);
    }

    private void validateIdNo(PatientHistory history) {
        if (history.isContract()) {
            return;
        }

        String idNo = PatientUtil.formatIdNo(history.getIdNo());

        if ("0".equals(idNo)) {
            return;
        }

        if (idNo == null) {
            throw new InvalidDataException("ID No " + history.getIdNo());
        }

        PatientHistory oldHistory = findLastByIdNo(idNo);

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

    private void validatePreviousPayment(PatientHistory history) {
        Patient patient = history.getPatient();

        if (patient == null || patient.getId() == null) {
            return;
        }

        List<PatientInvoiceLine> invoiceLines = invoiceLineService.findNotPaidServiceByPatient(patient, history.getId());
        if (invoiceLines != null && invoiceLines.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("invoiceLines", invoiceLines);
            throw new PatientNotPaidException("Patient value " + patient.getPatientValue() + " not paid", data);
        }
    }

    private void validatePreviousInpatientInHospital(PatientHistory history) {
        String patientValue = history.getPatientValue();
        if (patientValue == null) {
            return;
        }

        Long id = history.getId();
        if (id == null) {
            id = 0L;
        }

        List<Integer> states = Arrays.asList(PatientStateEnum.TRONG_VIEN.getValue());

        List<PatientHistory> list = getRepository().findByPatientValueAndPatientSate(patientValue, states, id, PageRequest.of(0, 1));

        if (list != null && list.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("patientHistory", getSimpleInsurancePatientHistoryDto(list.get(0)));
        }
    }
}
