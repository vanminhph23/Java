package com.isofh.his.importdata;

import com.isofh.his.exception.data.DataTypeException;
import com.isofh.his.exception.data.ParseValueException;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.util.DateUtil;

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
        List<String> fields = fromValue.get(1);
        List<Header> headers = new ArrayList<>();

        for (int i = 0; i < column; i++) {
            Header h = Header.parse(fields.get(i));
            headers.add(h);
        }

        // Convert matrix to hash map object
        List<Map<String, Object>> objects = new ArrayList<>();
        int objCount = fromValue.size();
        for (int i = 2; i < objCount; i++) {
            List<String> row = fromValue.get(i);
            Map<String, Object> obj = new HashMap<>();
            Map<String, Object> keys = new HashMap<>();
            for (int j = 0; j < column; j++) {
                Header header = headers.get(j);

                String data = row.get(j);

                Object value = null;
                if (data != null) {
                    if (header.getLinkColumnName() != null) {
                        value = service.getReference(header, data);
                    } else {
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
                                format = dateType.replace("]", "").split("\\[")[1].replace("mm", "MM");
                            }

                            try {
                                value = DateUtil.parseValidDate(data, format);
                            } catch (ParseException e) {
                                throw new ParseValueException("Cannot parse data: " + data + "header: " + header, e);
                            }
                        } else if (dateType != null) {
                            throw new DataTypeException("Invalid data type: " + dateType);
                        }
                    }

                    if (header.isKey()) {
                        keys.put(header.getColumnName(), value);
                    }
                }

                obj.put(header.getColumnName(), value);
            }

            if (keys.size() > 0) {
                Map<String, Object> oldObj = service.getOld(obj, keys);
                if (oldObj != null) {
                    for (String key: obj.keySet()) {
                        oldObj.put(key, obj.get(key));
                    }

                    objects.add(oldObj);
                    continue;
                }
            }

            objects.add(obj);
        }

        return objects;
    }


}
