package com.isofh.his.util;

import com.isofh.his.exception.ParseValueException;
import com.isofh.his.service.base.BaseService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportUtil {

    public static List<Map<String, Object>> convertValue(List<List<String>> fromValue, BaseService service) {

        // Row 1 must be data type
        List<String> dataTypes = fromValue.get(0);
        int column = dataTypes.size();
        for (int i = 0; i < column; i++) {
            String dataType = dataTypes.get(i);
            dataTypes.set(i, dataType == null ? null : dataType.toLowerCase());
        }

        // Correct header to field name of object
        List<String> headers = fromValue.get(1);
        for (int i = 0; i < column; i++) {
            headers.set(i, correctHeader(headers.get(i)));
        }

        // Convert matrix to hash map object
        List<Map<String, Object>> objects = new ArrayList<>();
        int objCount = fromValue.size();
        for (int i = 2; i < objCount; i++) {
            List<String> row = fromValue.get(i);
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

                        try {
                            value = DateUtil.parseValidDate(data, format);
                        } catch (ParseException e) {
                            throw new ParseValueException("Cannot parse data: " + data + "header: " + header, e);
                        }
                    }
                }

                obj.put(header, value);
            }

            objects.add(obj);
        }

        return objects;
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
