/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isora;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Minh
 */
public class CheckPatient {

    public static List<Patient> read(String inputFile) throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        List<Patient> list = new ArrayList<>();
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            // Loop over first 10 column and lines

            for (int i = 0; i < sheet.getRows(); i++) {
                if (sheet.getCell(0, i).getType() == CellType.EMPTY
                        || sheet.getCell(1, i).getType() == CellType.EMPTY
                        || sheet.getCell(2, i).getType() == CellType.EMPTY
                        || sheet.getCell(3, i).getType() == CellType.EMPTY
                        || sheet.getCell(4, i).getType() == CellType.EMPTY) {
                    continue;
                }
                // STT : Integer.parseInt(sheet.getCell(0, i).getContents())
                // Name: sheet.getCell(1, i).getContents()
                // Department: sheet.getCell(2, i).getContents()
                // Medicalrecordno
                // Amount: Integer.parseInt(sheet.getCell(2, i).getContents())
                Patient patient = new Patient(Integer.parseInt(sheet.getCell(0, i).getContents().replace(".", "").replace(",", "")), sheet.getCell(1, i).getContents(), sheet.getCell(2, i).getContents(), sheet.getCell(3, i).getContents(), Integer.parseInt(sheet.getCell(4, i).getContents().replace(".", "").replace(",", "")));
                list.add(patient);
            }
            return list;
        } catch (BiffException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Patient> isora = read("D:\\Workspace\\3.ISORA\\2.HIS\\DongboDB\\test\\DichVu\\isora.xls");
        List<Patient> mydix = read("D:\\Workspace\\3.ISORA\\2.HIS\\DongboDB\\test\\DichVu\\medyx.xls");
//        List<Patient> isora = read("D:\\Workspace\\3.ISORA\\2.HIS\\DongboDB\\test\\BaoHiem_95\\isora.xls");
//        List<Patient> mydix = read("D:\\Workspace\\3.ISORA\\2.HIS\\DongboDB\\test\\BaoHiem_95\\medyx.xls");
        System.out.println(String.format("Phần mềm ISORA có %d patient", isora.size()));
        System.out.println(String.format("Phần mềm Mydix có %d patient", mydix.size()));
        for (Patient i : isora) {
            boolean exist = false;
            for (Patient m : mydix) {
                if (i.medicalrecord.equals(m.medicalrecord)) {
                    if (Math.abs(i.amount - m.amount)>10) {
                        System.out.println(String.format("ISORA: %d, Mydix: %d, Medicalrecordno: %s : Không đúng tiền ISORA: %d --Mydix: %d", i.seq, m.seq, m.medicalrecord, i.amount, m.amount));
                    }
//                    if(!i.department.split(" ")[0].toLowerCase().equals(m.department.split(" ")[0].toLowerCase())){
//                        System.out.println(String.format("ISORA: %d, Mydix: %d, Medicalrecordno: %s : Không đúng khoa ISORA: %s --Mydix: %s",i.seq, m.seq, m.medicalrecord, i.department, m.department));
//                    }
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println(String.format("Không tồn tại bênh nhân %s trên mydix", i.medicalrecord));
            }
        }

        for (Patient m : mydix) {
            boolean exist = false;
            for (Patient i : isora) {
                if (i.medicalrecord.equals(m.medicalrecord)) {
//                    if(i.amount!=m.amount){
//                        System.out.println(String.format("ISORA: %d, Mydix: %d, Medicalrecordno: %s : Không đúng tiền ISORA: %d --Mydix: %d",i.seq, m.seq, m.medicalrecord, i.amount, m.amount));
//                    }
//                    if(!i.department.split(" ")[0].toLowerCase().equals(m.department.split(" ")[0].toLowerCase())){
//                        System.out.println(String.format("ISORA: %d, Mydix: %d, Medicalrecordno: %s : Không đúng khoa ISORA: %s --Mydix: %s",i.seq, m.seq, m.medicalrecord, i.department, m.department));
//                    }
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println(String.format("Không tồn tại bênh nhân %s trên isora", m.medicalrecord));
            }
        }

    }
}
