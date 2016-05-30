/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.astm;

import com.isofh.Util;
import com.isofh.hibernate.entities.HisMedicaltest;
import com.isofh.hibernate.entities.HisPatienthistory;
import com.isofh.hibernate.entities.HisServiceMedicaltest;
import com.isofh.hibernate.entities.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vanminh
 */
public class Message {

    public static final byte SOH = 1;
    public static final byte STX = 2;
    public static final byte ETX = 3;
    public static final byte EOT = 4;
    public static final byte ENQ = 5;
    public static final byte ACK = 6;
    public static final byte LF = 10;
    public static final byte CR = 13;
    public static final byte ETB = 23;
    public static final byte NACK = 21;

    private static final char PIPE = '|';
    private static final char CARET = '^';
    private static final String DELIMITERDEF = "|\\^&";
    private static final String INSTRUMENT = "ASTM-Host";
    private static final String HOST = "IsofH-HIS";

    public static String header() {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHMMSS");
        return "H" + DELIMITERDEF + Util.repChar(PIPE, 3) + INSTRUMENT + Util.repChar(PIPE, 5) + HOST + Util.repChar(PIPE, 2) + "P" + Util.repChar(PIPE, 2) + format.format(new Date()) + "\n";
    }

    public static String terminator() {
        return "L" + PIPE + "1" + PIPE + "N" + "\n";
    }

    public static String patient(HisPatienthistory patienthistory) {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
        String assurancecard =  patienthistory.getAssuranceId()==null?"":patienthistory.getAssuranceId();
        return "P" + PIPE + "1" + Util.repChar(PIPE, 2)
                + patienthistory.getValue() + Util.repChar(PIPE, 2)
                + patienthistory.getName() + Util.repChar(PIPE, 2)
                + format.format(patienthistory.getBirthday()) + PIPE
                + patienthistory.getHisGenderId() + PIPE
                + patienthistory.getAddress2() + Util.repChar(PIPE, 2)
                + assurancecard
                + PIPE + "\n";
    }

    public static String order(int seQ, List<HisServiceMedicaltest> serviceMedicaltests) {
        String record;
        String testRecord = "";
        for (HisServiceMedicaltest serviceMedicaltest : serviceMedicaltests) {
            HisMedicaltest medicaltest = Model.getTestByID(serviceMedicaltest.getHisServiceId());
            testRecord += "^^^" + medicaltest.getHisLisCode() + "\\";
        }
        if (!testRecord.isEmpty()) {
            testRecord = testRecord.substring(0, testRecord.length() - 1); //trim the last backslash
        }
        
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHMMSS");
        Date acDate = serviceMedicaltests.get(0).getActdate();
        acDate = acDate==null?new Date() : acDate;
//        int CheckUp_User_ID = serviceMedicaltests.get(0).getHisChecknullupUserId() == 
        
        record = "O" + PIPE + "1" + PIPE + serviceMedicaltests.get(0).getHisServiceMedictestgroupId() + PIPE + PIPE + testRecord + PIPE + PIPE + "R" + PIPE 
                + format.format(acDate) + PIPE  
                + Util.repChar(PIPE, 5) + "A"
                + Util.repChar(PIPE, 5) + "1001990" + Util.repChar(PIPE, 2) + serviceMedicaltests.get(0).getHisRoomId()
                + Util.repChar(PIPE, 8) + "O" + "\n";

        return record;
    }

}
