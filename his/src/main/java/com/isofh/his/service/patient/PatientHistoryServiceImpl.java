package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.exception.data.NotFoundException;
import com.isofh.his.exception.data.NullValueException;
import com.isofh.his.map.PropertyMapPatientHistoryToDto;
import com.isofh.his.model.patient.PatientAddress;
import com.isofh.his.model.patient.PatientGuardian;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientHistoryRepository;
import com.isofh.his.storage.StorageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public PatientHistory create(PatientHistoryDto phDto) {
        PatientHistory ph = getModel(phDto);

        // Address
        PatientAddress address = new PatientAddress();
        ph.setPatientAddress(address);
        address.setCountryId(phDto.getCountryId());
        address.setProvinceId(phDto.getProvinceId());
        address.setDistrictId(phDto.getDistrictId());
        address.setZoneId(phDto.getZoneId());
        address.setDetail(phDto.getDetail());

        if (ph.getPatientType() == null) {
            ph.setPatientType(PatientType.SERVICE.getValue());
        }

        if (ph.getPatientType() != PatientType.SERVICE.getValue() && ph.getPatientType() != PatientType.INSURANCE.getValue()) {
            throw new InvalidDataException("Patient type " + ph.getPatientType());
        }

        // Address card
        if (ph.getPatientType() == PatientType.INSURANCE.getValue()) {
            PatientInsurance insurance = new PatientInsurance();
            ph.setPatientInsurance(insurance);

            insurance.setAddress(phDto.getInsuranceAddress());
            insurance.setAppliedToDate(phDto.getInsuranceAppliedToDate());
            insurance.setAppliedFromDate(phDto.getInsuranceAppliedFromDate());
            insurance.setAppointment(phDto.isInsuranceAppointment());
            insurance.setContinuity5Year(phDto.isInsuranceContinuity5Year());
            insurance.setEmergency(phDto.isInsuranceEmergency());
            insurance.setExtra(phDto.isInsuranceExtra());
            insurance.setHundredPercentHightech(phDto.isInsuranceHundredPercentHightech());
            insurance.setInsuranceNumber(phDto.getInsuranceNumber());
            insurance.setFromDate(phDto.getInsuranceFromDate());
            insurance.setToDate(phDto.getInsuranceToDate());
            insurance.setNotCopayment(phDto.isInsuranceNotCoPayment());
            insurance.setNotCopaymentDate(phDto.getInsuranceNotCopaymentDate());
            insurance.setRegAtHospitalId(phDto.getInsuranceRegAtHospitalId());
            insurance.setPatientFromHospitalId(phDto.getInsurancePatientFromHospitalId());
            insurance.setPercent(phDto.getInsurancePercent());
            insurance.setReferral(phDto.isInsuranceReferral());
            insurance.setRegionValue(phDto.getInsuranceRegionValue());
            insurance.setKeeping(phDto.isInsuranceKeeping());
        }

        // guardian
        if (phDto.getGuardianIdNo() != null || phDto.getGuardianName() != null || phDto.getGuardianPhone() != null) {
            PatientGuardian guardian = new PatientGuardian();
            guardian.setPatientHistory(ph);

            guardian.setIdNo(phDto.getGuardianIdNo());
            guardian.setName(phDto.getGuardianName());
            guardian.setPhone(phDto.getGuardianPhone());
        }

        return create(ph);
    }

    @Transactional
    @Override
    public PatientHistory create(PatientHistory ph) {
        if (ph.getPatientAddress() != null) {
            addressService.save(ph.getPatientAddress());
        }

        if (ph.getPatientInsurance() != null) {
            insuranceService.save(ph.getPatientInsurance());
        }

        ph = save(ph);

        return ph;
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistoryDto phDto) {
        PatientHistory ph = repository.findById(phDto.getId()).orElseThrow(() -> new NotFoundException("Not found patient history id: " + phDto.getId()));
        return update(ph);
    }

    @Transactional
    @Override
    public PatientHistory update(PatientHistory ph) {
        return save(ph);
    }

    private void validatePatientName(PatientHistory ph) {
        if (ph.getPatientName() == null) {
            throw new NullValueException("Patient name is null");
        }

        ph.setPatientName(ph.getPatientName().toUpperCase());
    }
}
