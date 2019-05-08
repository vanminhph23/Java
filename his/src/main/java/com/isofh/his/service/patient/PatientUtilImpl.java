package com.isofh.his.service.patient;

import org.springframework.stereotype.Service;

@Service
public class PatientUtilImpl implements PatientUtil {

    @Override
    public String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        return name.trim().toUpperCase();
    }

    @Override
    public String formatPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return null;
        }

        if ("0".equals(phone.trim())) {
            return "0";
        }

        phone = phone.replaceAll("[^0-9]", "");

        if ((!phone.matches("^[0-9]*$") && !phone.matches("^+[0-9]*$")) || phone.length() < 10) {
            return null;
        }

        int length = phone.length();

        return phone.substring(0, length - 6) + " " + phone.substring(length - 6, length - 3) + " " + phone.substring(length - 3);
    }

    @Override
    public String formatIdNo(String idNo) {
        if (idNo == null || idNo.isEmpty()) {
            return null;
        }

        if ("0".equals(idNo.trim())) {
            return "0";
        }

        idNo = idNo.replaceAll("[^0-9]", "");

        if ((!idNo.matches("^[0-9]*$") && !idNo.matches("^+[0-9]*$")) || idNo.length() < 9) {
            return null;
        }

        return idNo;
    }
}
