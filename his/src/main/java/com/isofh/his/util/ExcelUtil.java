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
import java.text.ParseException;
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

    public static List<Map<String, Object>> readFile(String fileName, int sheetNo, int startLineNo, BaseService service) {
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


            // Data type
            List<String> dataTypes = result.get(0);
            int column = dataTypes.size();
            for (int i = 0; i < column; i++) {
                String dataType = dataTypes.get(i);
                dataTypes.set(i, dataType == null ? null : dataType.toLowerCase());
            }

            // Correct header to field name of object
            List<String> headers = result.get(1);
            for (int i = 0; i < column; i++) {
                headers.set(i, correctHeader(headers.get(i)));
            }

            // Add null property to object if not exists in excel
            for (List<String> rowObject : result) {
                for (int i = rowObject.size(); i < column; i++) {
                    rowObject.add(null);
                }
            }

            // Convert matrix to hash map object
            int objCount = result.size();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (int i = 2; i < objCount; i++) {
                List<String> row = result.get(i);
                Map<String, Object> obj = new HashMap<>();

                for (int j = 0; j < column; j++) {
                    String header = headers.get(j);
                    String data = row.get(j);

                    Object value = null;

                    if (header.contains("[")) {
                        value = data == null ? null : service.convert(header, data);
                        header = header.split("\\[")[0];
                    } else if (data != null) {
                        String dateType = dataTypes.get(j);

                        if (dateType == null || dateType.equals("text")) {
                            value = data;
                        } else if (dateType.equals("number")) {
                            value = Double.valueOf(data);
                        } else if (dateType.equals("boolean")) {
                            value = "true".equalsIgnoreCase(data) || "t".equalsIgnoreCase(data) || "yes".equalsIgnoreCase(data) || "y".equalsIgnoreCase(data);
                        } else if (dateType.startsWith("date")) {
                            String format = null;
                            if (!dateType.contains("[")) {
                                format = dateType.replace("]", "").split("\\[")[1];
                            }

                            value = DateUtil.parseValidDate(data, format);
                        }
                    }

                    obj.put(header, value);
                }

                objects.add(obj);
            }

            return objects;
        } catch (IOException | ParseException e) {
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
        header = header.toLowerCase();

        if (!header.contains("[")) {
            return correctFieldName(header);
        }

        String[] strs = header.replace("]", "").split("\\[");
        return correctFieldName(strs[0]) + "[" + correctFieldName(strs[1]) + "]";
    }

    private static String correctFieldName(String fieldName) {
        fieldName = fieldName.trim();
        String[] strs = fieldName.split("_");

        int size = strs.length;
        fieldName = strs[0];
        for (int j = 1; j < size; j++) {
            fieldName += strs[j].substring(0, 1).toUpperCase() + strs[j].substring(1);
        }
        return fieldName;
    }
}
