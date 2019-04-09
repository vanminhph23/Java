package com.isofh.his.util;

import com.isofh.his.exception.StorageException;
import com.isofh.his.service.base.BaseService;
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

    public static List<Map<String, Object>> readFile(String fileName, int sheetNo, int startLineNo, BaseService service) {
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

            // Correct header to field name of object
            List<Object> headers = result.get(0);
            int column = headers.size();
            for (int i = 0; i < column; i++) {
                headers.set(i, correctHeader((String) headers.get(i)));
            }

            // Add null property to object if not exists in excel
            for (List<Object> rowObject : result) {
                for (int i = rowObject.size(); i < column; i++) {
                    rowObject.add(null);
                }
            }

            // Convert matrix to hash map object
            int objCount = result.size();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (int i = 1; i < objCount; i++) {
                List<Object> row = result.get(i);
                Map<String, Object> obj = new HashMap<>();

                for (int j = 0; j < column; j++) {
                    String header = (String) headers.get(j);
                    Object data = row.get(j);
                    if (header.contains("[")) {
                        data = service.convert(header, (String) data);
                        header = header.split("\\[")[0];
                    }

                    obj.put(header, data);
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

    private static String correctHeader(String header) {
        if (!header.contains("[")) {
            return correctFieldName(header);
        }

        String[] strs = header.trim().toLowerCase().replace("]", "").split("\\[");
        return correctFieldName(strs[0]) + "[" + correctFieldName(strs[1]) + "]";
    }

    private static String correctFieldName(String fieldName) {
        fieldName = fieldName.trim().toLowerCase();
        String[] strs = fieldName.split("_");

        int size = strs.length;
        fieldName = strs[0];
        for (int j = 1; j < size; j++) {
            fieldName += strs[j].substring(0, 1).toUpperCase() + strs[j].substring(1);
        }
        return fieldName;
    }
}
