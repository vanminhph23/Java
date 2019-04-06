package com.isofh.his.util;

import com.isofh.his.exception.StorageException;
import com.isofh.his.storage.FileSystemStorageService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

                if (row.getRowNum() < startLineNo) {
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

    public static List<Map<String, Object>> readFile(String fileName, int sheetNo, int startLineNo) {
        if (!fileName.endsWith(".xls")) {
            return null;
        }

        List<List<Object>> result = new ArrayList<>();

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(new File(fileName));
            workbook = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = workbook.getSheetAt(sheetNo - 1);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (row.getRowNum() < startLineNo - 1) {
                    continue;
                }

                Iterator<Cell> cellIterator = row.cellIterator();
                List<Object> rowObject = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();
                    switch (cellType) {
                        case _NONE:
                            rowObject.add(null);
                            break;
                        case BOOLEAN:
                            rowObject.add(cell.getBooleanCellValue());
                            break;
                        case BLANK:
                            rowObject.add(null);
                            break;
                        case FORMULA:
                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                            rowObject.add(evaluator.evaluate(cell).getNumberValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                                rowObject.add(dateFormat.format(cell.getDateCellValue()));
                            } else {
                                rowObject.add(new Double(cell.getNumericCellValue()));
                            }
                            break;
                        case STRING:
                            rowObject.add(cell.getStringCellValue());
                            break;
                        case ERROR:
                            rowObject.add(null);
                            break;
                    }
                }

                for (Object obj : rowObject) {
                    if (obj != null) {
                        result.add(rowObject);
                        break;
                    }
                }
            }

            List<Object> header = result.get(0);
            int column = header.size();

            for (List<Object> rowObject : result) {
                for (int i = rowObject.size(); i < column; i++) {
                    rowObject.add(null);
                }
            }

            int objCount = result.size();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (int i = 1; i < objCount; i++) {
                List<Object> row = result.get(1);
                Map<String, Object> obj = new HashMap<>();

                for (int j = 0; j < column; j++) {
                    obj.put((String) header.get(j), row.get(j));
                }

                objects.add(obj);
            }

            return objects;
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
