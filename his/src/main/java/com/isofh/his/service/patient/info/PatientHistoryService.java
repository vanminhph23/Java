package com.isofh.his.service.patient.info;

import com.isofh.his.dto.patient.info.PatientHistoryDto;
import com.isofh.his.dto.patient.info.SimpleInsurancePatientHistoryDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.repository.patient.info.PatientHistoryRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.util.Date;

public interface PatientHistoryService extends BaseService<PatientHistory, PatientHistoryDto, PatientHistoryRepository> {

    PatientHistory create(PatientHistory history, boolean ignoreValidatePortalInsurance);

    PatientHistory update(PatientHistory history, boolean ignoreValidatePortalInsurance);

    PatientHistory findLastByIdNo(String idNo);

    PatientHistory findLastByPatientValue(String patientValue);

    SimpleInsurancePatientHistoryDto getSimpleInsurancePatientHistoryDto(PatientHistory history);

    boolean isInsurancePatient(PatientHistory history, Date actDate);

    boolean isInsurancePatient(PatientType patientType, boolean inPatient);

    enum PatientTypeEnum implements IEnum {
        DICH_VU(1), BAO_HIEM(2);

        private int value;

        PatientTypeEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    enum PatientStateEnum implements IEnum {
        NGOAI_TRU(0), NHAP_VIEN(10), DA_LAP_BENH_AN(20), TRONG_VIEN(30), CHUYEN_KHOA(40),
        RA_VIEN_TAM_THOI(50), RA_VIEN(60), RA_VIEN_HIEN_DIEU_TRI(70), DA_THANH_TOAN(80), DA_THANH_TOAN_HEN_DIEU_TRI(90),
        DIEU_TRI_NGOAI_TRU(100), HUY_BENH_AN(110);

        private int value;

        PatientStateEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
}
