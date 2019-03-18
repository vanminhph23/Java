/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isofh.astm;

import com.isofh.Util;
import com.isofh.hibernate.model.MPatientHistory;
import com.isofh.hibernate.model.MRVServiceMedicaltest;
import com.isofh.hibernate.model.MRVServiceMedictestLine;
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
        return "H" + DELIMITERDEF + Util.repChar(PIPE, 3) + INSTRUMENT + Util.repChar(PIPE, 5) + HOST + Util.repChar(PIPE, 2) + "P" + Util.repChar(PIPE, 2) + format.format(new Date());
    }

    public static String terminator() {
        return "L" + PIPE + "1" + PIPE + "N";
    }

    public static String patient(MPatientHistory patientHistory) {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD");
        String assurancecard =  patientHistory.getAssuranceID()==null?"":patientHistory.getAssuranceID();
        return "P" + PIPE + "1" + Util.repChar(PIPE, 2)
                + patientHistory.getValue() + Util.repChar(PIPE, 2)
                + patientHistory.getName() + Util.repChar(PIPE, 2)
                + format.format(patientHistory.getBirthday()) + PIPE
                + patientHistory.getGenderID() + PIPE
                + patientHistory.getAddress() + Util.repChar(PIPE, 2)
                + assurancecard
                + PIPE;
    }

    public static String order(List<MRVServiceMedicaltest> mRVServiceMedicaltests) {
        String record;
        String testRecord = "";
        for (MRVServiceMedicaltest mRVServiceMedicaltest : mRVServiceMedicaltests) {
            testRecord += "^^^" + mRVServiceMedicaltest.getHisLisCode() + "\\";
            testRecord += orderLine(mRVServiceMedicaltest);
        }
        if (!testRecord.isEmpty()) {
            testRecord = testRecord.substring(0, testRecord.length() - 1); //trim the last backslash
        }
        
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHMMSS");
        Date acDate = mRVServiceMedicaltests.get(0).getActdate();
        acDate = acDate==null?new Date() : acDate;
        
        record = "O" + PIPE + "1" + PIPE + mRVServiceMedicaltests.get(0).getServiceMedictestGroupID() + PIPE + PIPE + testRecord + PIPE + PIPE + "R" + PIPE 
                + format.format(acDate)  
                + Util.repChar(PIPE, 4) + "A"
                + Util.repChar(PIPE, 5) + "1001990" + Util.repChar(PIPE, 2) + mRVServiceMedicaltests.get(0).getRoomValue()
                + Util.repChar(PIPE, 8) + "O";

        return record;
    }
    
    private static String orderLine(MRVServiceMedicaltest mRVServiceMedicaltest){
        List<MRVServiceMedictestLine> testLines = MRVServiceMedictestLine.getByMedicaltestID(mRVServiceMedicaltest.getServiceMedicalTestID());
        String testRecord = "";
        for(MRVServiceMedictestLine line : testLines){
            testRecord += "^^^" + line.getHisLISCode() + "\\";
        }
        return testRecord;
    }

}
