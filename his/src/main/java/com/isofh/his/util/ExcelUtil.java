package com.isofh.his.util;

import com.isofh.his.exception.StorageException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    private final static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static String appendLog(String fileName, int sheetNo, int startLineNo, List<String> data) {
        if (!fileName.endsWith(".xls")) {
            return null;
        }

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        FileOutputStream outputStream = null;
        HSSFSheet sheet;
        try {
            inputStream = new FileInputStream(new File(fileName));
            workbook = new HSSFWorkbook(inputStream);

            sheet = workbook.getSheetAt(sheetNo - 1);

            Iterator<Row> rowIterator = sheet.iterator();

            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            int rowCount = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() < startLineNo - 1) {
                    continue;
                }

                Cell cell = row.createCell(columnCount);
                cell.setCellValue(data.get(rowCount));
                rowCount++;
            }

            String logFile = fileName.substring(0, fileName.length() - 4)+ "_log.xls";

            outputStream = new FileOutputStream(logFile);
            workbook.write(outputStream);

            return logFile;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + fileName, e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

                if (workbook != null)
                    workbook.close();

                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<List<String>> readFile(String fileName, int sheetNo, int startLineNo) {
        if (!fileName.endsWith(".xls")) {
            return null;
        }

        List<List<String>> result = new ArrayList<>();

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(new File(fileName));
            workbook = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = workbook.getSheetAt(sheetNo - 1);

            int rowNo = sheet.getPhysicalNumberOfRows();
            int columnNo = sheet.getRow(startLineNo).getPhysicalNumberOfCells();
            for (int i = 0; i < rowNo; i++) {
                if (i < startLineNo - 1) {
                    continue;
                }

                Row row = sheet.getRow(i);

                List<String> rowObject = new ArrayList<>();

                for (int j = 0; j < columnNo; j++) {
                    Cell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
                    int cellType = cell.getCellType();
                    switch (cellType) {
                        case Cell.CELL_TYPE_STRING:
                            rowObject.add(cell.getStringCellValue().trim());
                            break;
                        default:
                            rowObject.add(null);
                            break;
                    }
                }

                for (String obj : rowObject) {
                    if (obj != null) {
                        result.add(rowObject);
                        break;
                    }
                }
            }

            if (result.size() <= 0) {
                return new ArrayList<>();
            }

            // Add null property to object if not exists in excel
            int column = result.get(0).size();
            for (List<String> rowObject : result) {
                for (int i = rowObject.size(); i < column; i++) {
                    rowObject.add(null);
                }
            }

            return result;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + fileName, e);
        } finally {
            try {
                if (workbook != null)
                    workbook.close();

                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
