package com.isofh.his.map;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import org.modelmapper.PropertyMap;

public class PropertyMapPatientHistoryToDto extends PropertyMap<PatientHistory, PatientHistoryDto> {
    @Override
    protected void configure() {
        // address
        map().setCountryId(source.getPatientAddress().getCountryId());
        map().setProvinceId(source.getPatientAddress().getProvinceId());
        map().setDistrictId(source.getPatientAddress().getDistrictId());
        map().setZoneId(source.getPatientAddress().getZoneId());
        map().setDetail(source.getPatientAddress().getDetail());
        // insurance
        map().setInsuranceAddress(source.getPatientInsurance().getAddress());
        map().setInsuranceAppliedToDate(source.getPatientInsurance().getAppliedToDate());
        map().setInsuranceAppliedFromDate(source.getPatientInsurance().getAppliedFromDate());
        map().setInsuranceAppointment(source.getPatientInsurance().isAppointment());
        map().setInsuranceContinuity5Year(source.getPatientInsurance().isContinuity5Year());
        map().setInsuranceEmergency(source.getPatientInsurance().isEmergency());
        map().setInsuranceExtra(source.getPatientInsurance().isExtra());
        map().setInsuranceHundredPercentHightech(source.getPatientInsurance().isHundredPercentHightech());
        map().setInsuranceNumber(source.getPatientInsurance().getInsuranceNumber());
        map().setInsuranceFromDate(source.getPatientInsurance().getFromDate());
        map().setInsuranceToDate(source.getPatientInsurance().getToDate());
        map().setInsuranceNotCoPayment(source.getPatientInsurance().isNotCopayment());
        map().setInsuranceNotCopaymentDate(source.getPatientInsurance().getNotCopaymentDate());
        map().setInsuranceRegAtHospitalId(source.getPatientInsurance().getRegAtHospitalId());
        map().setInsurancePatientFromHospitalId(source.getPatientInsurance().getPatientFromHospitalId());
        map().setInsurancePercent(source.getPatientInsurance().getPercent());
        map().setInsuranceReferral(source.getPatientInsurance().isReferral());
        map().setInsuranceRegionValue(source.getPatientInsurance().getRegionValue());
        map().setInsuranceKeeping(source.getPatientInsurance().isKeeping());
        // guardian
        map().setGuardianIdNo(source.getPatientGuardian().getIdNo());
        map().setGuardianName(source.getPatientGuardian().getName());
        map().setGuardianPhone(source.getPatientGuardian().getPhone());
    }
}
