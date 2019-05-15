package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientInsuranceDto;
import com.isofh.his.dto.patient.info.SimpleInsurancePatientHistoryDto;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.exception.insurance.InsurancePortalException;
import com.isofh.his.exception.insurance.NotReturnInsuranceException;
import com.isofh.his.exception.insurance.RegisterSameDayException;
import com.isofh.his.exception.patient.InsuranceNumberNotPaidException;
import com.isofh.his.insurance.card.model.TheBH;
import com.isofh.his.insurance.card.service.InsuranceCardPortalService;
import com.isofh.his.model.category.InsuranceCard;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.patient.info.PatientInsuranceRepository;
import com.isofh.his.service.category.ConstService;
import com.isofh.his.service.category.InsuranceCardService;
import com.isofh.his.service.patient.invoice.PatientInvoiceLineService;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientInsuranceServiceImpl implements PatientInsuranceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInsuranceServiceImpl.class);

    @Autowired
    private PatientInsuranceRepository repository;

    @Autowired
    private ConstService constService;

    @Autowired
    private InsuranceCardService insuranceCardService;

    @Autowired
    private PatientInvoiceLineService invoiceLineService;

    @Autowired
    private InsuranceCardPortalService insuranceCardPortalService;

    @Override
    public PatientInsuranceRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInsurance> getModelClass() {
        return PatientInsurance.class;
    }

    @Override
    public Class<PatientInsuranceDto> getDtoClass() {
        return PatientInsuranceDto.class;
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
    public PatientInsurance findByValidDate(Long patientHistoryId, Date actDate) {
        List<PatientInsurance> list = getRepository().findByValidDate(patientHistoryId, DateUtil.truncateHour(actDate), PageRequest.of(0, 1, Sort.by("percent").descending()));

        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public void validateInsuranceCard(PatientHistory history, PatientInsurance insurance, boolean ignoreValidatePortalInsurance) {

        validateInsuranceNumber(insurance);

        validateInsuranceDate(history, insurance);

        if (!ignoreValidatePortalInsurance) {
            validateInsuranceCardPortal(history, insurance);
        }

        validateRegisterOfInsuranceNumber(history, insurance);

        setExtraInsurance(insurance);

        setInsurancePercent(insurance);
    }

    @Override
    public SimpleInsurancePatientHistoryDto getSimpleInsurancePatientHistoryDto(PatientInsurance insurance) {
        ModelMapper patientHistoryMapper = new ModelMapper();
        patientHistoryMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        SimpleInsurancePatientHistoryDto historyDto = patientHistoryMapper.map(insurance.getPatientType().getPatientHistory(), SimpleInsurancePatientHistoryDto.class);

        historyDto.setInsuranceAddress(insurance.getAddress());
        historyDto.setInsuranceAppliedToDate(insurance.getAppliedToDate());
        historyDto.setInsuranceAppliedFromDate(insurance.getAppliedFromDate());
        historyDto.setInsuranceAppointment(insurance.isAppointment());
        historyDto.setInsuranceContinuity5Year(insurance.isContinuity5Year());
        historyDto.setInsuranceEmergency(insurance.isEmergency());
        historyDto.setInsuranceExtra(insurance.isExtra());
        historyDto.setInsuranceHundredPercentHightech(insurance.isHundredPercentHightech());
        historyDto.setInsuranceNumber(insurance.getInsuranceNumber());
        historyDto.setInsuranceFromDate(insurance.getFromDate());
        historyDto.setInsuranceToDate(insurance.getToDate());
        historyDto.setInsuranceNotCoPayment(insurance.isNotCopayment());
        historyDto.setInsuranceNotCopaymentDate(insurance.getNotCopaymentDate());
        historyDto.setInsuranceRegAtHospitalId(insurance.getRegAtHospitalId());
        historyDto.setInsurancePatientFromHospitalId(insurance.getPatientFromHospitalId());
        historyDto.setInsurancePercent(insurance.getPercent());
        historyDto.setInsuranceReferral(insurance.isReferral());
        historyDto.setInsuranceRegionValue(insurance.getRegionValue());
        historyDto.setInsuranceKeeping(insurance.isKeeping());

        return historyDto;
    }

    private void validateInsuranceNumber(PatientInsurance insurance) {
        String insuranceNumber = formatInsuranceNumber(insurance.getInsuranceNumber());

        insurance.setInsuranceNumber(insuranceNumber);
    }

    private void setExtraInsurance(PatientInsurance insurance) {
        boolean isExtra = isExtraInsurance(insurance.getRegAtHospitalId(), insurance.getPatientFromHospitalId(), insurance.isEmergency(), insurance.isAppointment(), insurance.getRegionValue());

        if (insurance.getPatientFromHospitalId() != null && insurance.getPatientFromHospitalId() > 0) {
            insurance.setReferral(true);
        }

        insurance.setExtra(isExtra);
    }

    private void setInsurancePercent(PatientInsurance insurance) {
        int percent = calInsurancePercent(insurance.getInsuranceNumber(), insurance.isExtra(), insurance.isNotCopayment());

        insurance.setPercent(percent);
    }

    private void validateInsuranceDate(PatientHistory history, PatientInsurance insurance) {
        Date regDate = history.getRegDate();

        Date fromDate = insurance.getFromDate();
        Date toDate = insurance.getToDate();

        Date appliedFromDate = insurance.getAppliedFromDate();
        Date appliedToDate = insurance.getAppliedToDate();

        if (fromDate != null) {
            fromDate = DateUtil.truncateHour(fromDate);
        }

        if (toDate != null) {
            toDate = DateUtil.truncateHour(toDate);
        }

        if (appliedFromDate != null) {
            appliedFromDate = DateUtil.truncateHour(appliedFromDate);
        }

        if (appliedToDate != null) {
            appliedToDate = DateUtil.truncateHour(appliedToDate);
        }

        if (fromDate == null || (!history.isInpatient() && DateUtil.truncatedHourCompareTo(fromDate, regDate) > 0)) {
            throw new InvalidDataException("Insurance from date " + fromDate);
        }


        if (toDate == null || (!history.isInpatient() && DateUtil.truncatedHourCompareTo(toDate, regDate) < 0)) {
            throw new InvalidDataException("Insurance to date " + toDate);
        }

        if (DateUtil.truncatedHourCompareTo(fromDate, toDate) > 0) {
            throw new InvalidDataException("Insurance from date, to date " + fromDate + ", " + toDate);
        }

        if (!history.isInpatient() || appliedFromDate == null) {
            appliedFromDate = fromDate;
        } else if (DateUtil.truncatedHourCompareTo(appliedFromDate, fromDate) < 0) {
            throw new InvalidDataException("Insurance applied from date " + appliedFromDate + ", " + fromDate);
        }

        if (!history.isInpatient() || appliedToDate == null) {
            appliedToDate = toDate;
        } else if (DateUtil.truncatedHourCompareTo(appliedToDate, toDate) > 0) {
            throw new InvalidDataException("Insurance applied from date " + appliedToDate + ", " + toDate);
        }

        insurance.setFromDate(fromDate);
        insurance.setToDate(toDate);
        insurance.setAppliedFromDate(appliedFromDate);
        insurance.setAppliedToDate(appliedToDate);
    }

    void validateRegisterOfInsuranceNumber(PatientHistory history, PatientInsurance insurance) {
        validateRegDateOfInsuranceNumber(history, insurance);

        validateReturnedInsuranceNumber(history, insurance);

        validatePreviousPayment(history, insurance);

        validatePayTimeOfInsuranceNumber(history, insurance);
    }

    private void validateReturnedInsuranceNumber(PatientHistory history, PatientInsurance insurance) {
        Long id = history.getId();
        if (id == null) {
            id = Long.valueOf(0);
        }

        List<PatientInsurance> list = getRepository().findByKeeping(insurance.getInsuranceNumber(), true, id, PageRequest.of(0, 1));

        if (list != null && list.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("patientHistory", getSimpleInsurancePatientHistoryDto(list.get(0)));
            throw new NotReturnInsuranceException("Patient not return insurance card", data);
        }
    }

    void validateRegDateOfInsuranceNumber(PatientHistory history, PatientInsurance insurance) {
        Long id = history.getId();
        if (id == null) {
            id = Long.valueOf(0);
        }

        List<PatientInsurance> list = getRepository().findByRegDate(insurance.getInsuranceNumber(), DateUtil.truncateHour(history.getRegDate()), id, PageRequest.of(0, 1));

        if (list != null && list.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("patientHistory", getSimpleInsurancePatientHistoryDto(list.get(0)));
            throw new RegisterSameDayException("Patient has register same day", data);
        }
    }

    void validatePayTimeOfInsuranceNumber(PatientHistory history, PatientInsurance insurance) {
        Long id = history.getId();
        if (id == null) {
            id = Long.valueOf(0);
        }

        List<PatientInsurance> list = getRepository().findByInsuranceNumberAndPayTime(insurance.getInsuranceNumber(), DateUtil.truncateHour(history.getRegDate()), id, PageRequest.of(0, 1));

        if (list != null && list.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("patientHistory", getSimpleInsurancePatientHistoryDto(list.get(0)));
            throw new RegisterSameDayException("Patient has register same day", data);
        }
    }

    private void validatePreviousPayment(PatientHistory history, PatientInsurance insurance) {
        String insuranceNumber = insurance.getInsuranceNumber();

        if (insuranceNumber == null) {
            return;
        }

        List<PatientInvoiceLine> invoiceLines = invoiceLineService.findNotPaidServiceByInsuranceNumber(insurance.getInsuranceNumber(), history.getId());
        if (invoiceLines != null && invoiceLines.size() > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("invoiceLines", invoiceLines);
            throw new InsuranceNumberNotPaidException("Insurance number " + insurance.getInsuranceNumber() + " not paid", data);
        }
    }

    private void validateInsuranceCardPortal(PatientHistory history, PatientInsurance insurance) {
        TheBH bh = insuranceCardPortalService.getPatientInsuranceCard(history, insurance);
        if (bh == null || !"000".equals(bh.getMaKetQua())) {
            throw new InsurancePortalException("Invalid insurance card", bh);
        }
    }

    private int calInsurancePercent(String insuranceNumber, boolean extra, boolean notCoPayment) {
        if (insuranceNumber == null || insuranceNumber.isEmpty()) {
            return 0;
        }

        if (notCoPayment) {
            return 100;
        }

        InsuranceCard card = insuranceCardService.findByInsuranceNumber(insuranceNumber);

        if (card == null) {
            throw new InvalidDataException("Insurance number " + insuranceNumber);
        }

        int percent = card.getPercent();

        int extraInsurancePercent = constService.getExtraInsurancePercent();

        if (extra) {
            percent = extraInsurancePercent * percent / 100;
        }

        return percent;
    }

    private boolean isCurrentHospital(Long hospitalId) {
        Long currentId = constService.getCurrentHospital();
        if (currentId == null || currentId < 0 || hospitalId == null || hospitalId < 0){
            return false;
        }

        return currentId == hospitalId;
    }

    private boolean isExtraInsurance(Long regAtHospitalId, Long patientFromHospitalId, boolean emergency, boolean appointment, Integer regionValue) {
        return !isCurrentHospital(regAtHospitalId) && (patientFromHospitalId == null || patientFromHospitalId <= 0) && !emergency && !appointment
                && (regionValue == null || RegionValueEnum.Other.getValue() == regionValue);
    }

    private String formatInsuranceNumber(String insuranceNumber) {
        if (insuranceNumber == null || insuranceNumber.isEmpty()) {
            throw new InvalidDataException("Insurance number " + insuranceNumber);
        }

        if (!insuranceNumber.matches(INSURANCE_PATTERN)) {
            throw new InvalidDataException("Insurance number " + insuranceNumber);
        }

        return insuranceNumber.toUpperCase();
    }
}
