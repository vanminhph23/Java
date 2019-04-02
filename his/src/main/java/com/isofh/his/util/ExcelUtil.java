package com.isofh.his.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    public static List<List<Object>> readFile(String fileName, int sheetNo, int startLineNo) {
        if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
            return null;
        }

        List<List<Object>> result = new ArrayList<>();

        FileInputStream inputStream = null;
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;

        int maxColumn = 0;
        try {
            inputStream = new FileInputStream(new File(fileName));
            workbook = new HSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(sheetNo - 1);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if(row.getRowNum() < startLineNo - 1) {
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
                    if(obj != null) {
                        result.add(rowObject);
                        break;
                    }
                }

                if(maxColumn < rowObject.size()) {
                    maxColumn = rowObject.size();
                }
            }


            for (List<Object> rowObject : result) {
                for (int i = rowObject.size(); i < maxColumn; i++) {
                    rowObject.add(null);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null)
                    workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
