package com.isofh.his.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Util {

    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    final static ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper

    public static List<Long> convertIntToLong(List<Integer> source) {
        if (source == null) {
            return new ArrayList<>();
        }
        return source.stream().map(Long::valueOf).collect(Collectors.toList());
    }

    public static <T> T convertValue(Map<String, Object> fromValue, Class<T> toValueType) {
        return mapper.convertValue(fromValue, toValueType);
    }

    public static <T> List<T> convertValues(List<Map<String, Object>> fromValue, Class<T> toValueType) {
        List<T> toList = new ArrayList<>();
        for (Map<String, Object> map : fromValue) {
            toList.add(convertValue(map, toValueType));
        }

        return toList;
    }
}
