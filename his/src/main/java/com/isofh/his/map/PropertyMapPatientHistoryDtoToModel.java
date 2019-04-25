package com.isofh.his.map;

import com.isofh.his.dto.patient.PatientHistoryDto;
import com.isofh.his.model.patient.PatientHistory;
import org.modelmapper.PropertyMap;

public class PropertyMapPatientHistoryDtoToModel extends PropertyMap<PatientHistoryDto, PatientHistory> {
    @Override
    protected void configure() {
        // address
        map().getPatientAddress().setCountryId(source.getCountryId());
        map().getPatientAddress().setProvinceId(source.getProvinceId());
        map().getPatientAddress().setDistrictId(source.getDistrictId());
        map().getPatientAddress().setZoneId(source.getZoneId());
        map().getPatientAddress().setDetail(source.getDetail());
        // insurance
        map().getPatientInsurance().setAddress(source.getInsuranceAddress());
        map().getPatientInsurance().setAppliedToDate(source.getInsuranceAppliedToDate());
        map().getPatientInsurance().setAppliedFromDate(source.getInsuranceAppliedFromDate());
        map().getPatientInsurance().setAppointment(source.isInsuranceAppointment());
        map().getPatientInsurance().setContinuity5Year(source.isInsuranceContinuity5Year());
        map().getPatientInsurance().setEmergency(source.isInsuranceEmergency());
        map().getPatientInsurance().setExtra(source.isInsuranceExtra());
        map().getPatientInsurance().setHundredPercentHightech(source.isInsuranceHundredPercentHightech());
        map().getPatientInsurance().setInsuranceNumber(source.getInsuranceNumber());
        map().getPatientInsurance().setFromDate(source.getInsuranceFromDate());
        map().getPatientInsurance().setToDate(source.getInsuranceToDate());
        map().getPatientInsurance().setNotCopayment(source.isInsuranceNotCoPayment());
        map().getPatientInsurance().setNotCopaymentDate(source.getInsuranceNotCopaymentDate());
        map().getPatientInsurance().setRegAtHospitalId(source.getInsuranceRegAtHospitalId());
        map().getPatientInsurance().setPatientFromHospitalId(source.getInsurancePatientFromHospitalId());
        map().getPatientInsurance().setPercent(source.getInsurancePercent());
        map().getPatientInsurance().setReferral(source.isInsuranceReferral());
        map().getPatientInsurance().setRegionValue(source.getInsuranceRegionValue());
        map().getPatientInsurance().setKeeping(source.isInsuranceKeeping());
        // guardian
        map().getPatientGuardian().setIdNo(source.getGuardianIdNo());
        map().getPatientGuardian().setName(source.getGuardianName());
        map().getPatientGuardian().setPhone(source.getGuardianPhone());
    }
}
