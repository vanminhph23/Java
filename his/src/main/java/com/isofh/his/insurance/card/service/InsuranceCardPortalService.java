package com.isofh.his.insurance.card.service;

import com.isofh.his.insurance.card.model.TheBH;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.model.patient.PatientInsurance;

public interface InsuranceCardPortalService {

    String URL_LSKCB = "http://egw.baohiemxahoi.gov.vn/api/egw/KQNhanLichSuKCB2019";

    TheBH getInsuranceInfo(PatientHistory patientHistory, PatientInsurance patientInsurance);
}