package com.isofh.his.insurance.card.service;

import com.isofh.his.client.RestClientService;
import com.isofh.his.insurance.card.model.BenhNhan;
import com.isofh.his.insurance.card.model.TheBH;
import com.isofh.his.insurance.model.APIKey;
import com.isofh.his.insurance.service.TokenService;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.service.category.ConstService;
import com.isofh.his.service.category.HospitalService;
import com.isofh.his.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InsuranceCardPortalServiceImpl implements InsuranceCardPortalService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ConstService constService;

    @Autowired
    private RestClientService restClientService;

    @Autowired
    private HospitalService hospitalService;

    @Override
    public TheBH getInsuranceInfo(PatientHistory patientHistory, PatientInsurance patientInsurance) {
        APIKey apiKey = tokenService.getToken();

        Map<String, String> paras = new HashMap<>();
        paras.put("token", apiKey.getAccess_token());
        paras.put("id_token", apiKey.getId_token());
        paras.put("username", apiKey.getUsername());
        paras.put("password", constService.getInsurancePassword());

        BenhNhan bn = convert(patientHistory, patientInsurance);

        ResponseEntity<TheBH> bh = restClientService.doPost(URL_LSKCB, paras, bn, TheBH.class);

        return bh.getBody();
    }

    private BenhNhan convert(PatientHistory patientHistory, PatientInsurance patientInsurance) {
        BenhNhan bn = new BenhNhan();
        bn.setMaThe(patientInsurance.getInsuranceNumber());
        bn.setHoTen(patientHistory.getPatientName());
        bn.setGioiTinh(patientHistory.getGender() + "");
        bn.setMaCSKCB(hospitalService.findValueById(patientInsurance.getRegAtHospitalId()));

        if(patientInsurance.getFromDate() != null) {
            bn.setNgayBD(DateUtil.format(patientInsurance.getFromDate(), "dd/MM/yyyy"));
        }

        if (patientHistory.isOnlyYearBirth()) {
            bn.setNgaySinh(DateUtil.formatYear(patientHistory.getBirthday()));
        } else {
            bn.setNgaySinh(DateUtil.format(patientHistory.getBirthday(), "dd/MM/yyyy"));
        }

        return bn;
    }
}