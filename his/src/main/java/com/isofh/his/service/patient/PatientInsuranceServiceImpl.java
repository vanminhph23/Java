package com.isofh.his.service.patient;

import com.isofh.his.dto.patient.PatientInsuranceDto;
import com.isofh.his.model.category.InsuranceCard;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.patient.PatientInsuranceRepository;
import com.isofh.his.service.category.InsuranceCardService;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PatientInsuranceServiceImpl implements PatientInsuranceService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInsuranceServiceImpl.class);

    @Autowired
    private PatientInsuranceRepository repository;

    @Autowired
    private InsuranceCardService insuranceCardService;

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
        return getRepository().findByValidDate(patientHistoryId, actDate).orElse(null);
    }

    @Override
    public void validateInsuranceCard(PatientInsurance insurance) {
        PatientHistory history = insurance.getPatientHistory();

        Date fromDate = insurance.getFromDate();
        Date regDate = history.getRegDate();
        if(fromDate == null || (!history.isInpatient() && DateUtil.truncatedHourCompareTo(fromDate, regDate) > 0)) {

        }

        Date toDate = insurance.getToDate();
        if(toDate == null || (!history.isInpatient() && DateUtil.truncatedHourCompareTo(toDate, regDate) < 0)) {

        }

        if (DateUtil.truncatedHourCompareTo(fromDate, toDate) > 0) {

        }

        if((newRecord || is_ValueChanged(COLUMNNAME_AssuranceNumber))
                && !HISPatientHistoryUtil.validateAssuranceCardInfo(this)) {
            return false;
        }

        if((newRecord || is_ValueChanged(COLUMNNAME_HIS_PatientType) || is_ValueChanged(COLUMNNAME_AssuranceNumber))
                && HISPatientHistoryUtil.isExistsRegisterSameDay(getCtx(), getAssuranceNumber(), getTimeGoIn(), isInpatient(), get_TrxName(), get_Logger())) {
            return false;
        }

        setIsExtra(HISPatientHistoryUtil.isExtraAssurance(getAssurance_RegAtHospital_ID(), getPatientFrom_Hospital_ID(), isEmergency(), isAppointment(), getRegionValue()));
        if(getPatientFrom_Hospital_ID() > 0) {
            setIsReferral(true);
        }

        setAssurancePercent(HISPatientHistoryUtil.calAssurancePercent(getAssuranceNumber(), isExtra(), isNotCoPayment()));

        return true;
    }

    private int calAssurancePercent(String insuranceNumber, boolean extra, boolean notCoPayment){
        if(insuranceNumber == null || insuranceNumber.isEmpty()) {
            return 0;
        }

        if(notCoPayment){
            return 100;
        }

        MHISAssuranceCard card = MHISAssuranceCard.get(Env.getCtx(), assuranceNumber, null);

        if(card == null) {
            return 0;
        }

        int percent = card.getAssurancePercent();
        if(isExtra){
            percent = 40 * percent / 100;
        }

        return percent;
    }
}
