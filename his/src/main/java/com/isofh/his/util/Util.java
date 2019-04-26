package com.isofh.his.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
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

    public static Map<String, Object> convertValue(Object fromValue) {
        return mapper.convertValue(fromValue, Map.class);
    }

    public static String writeValueAsString(Object fromValue) throws JsonProcessingException {
        return mapper.writeValueAsString(fromValue);
    }

    public static <T> List<T> convertValues(List<Map<String, Object>> fromValue, Class<T> toValueType) {
        List<T> toList = new ArrayList<>();
        for (Map<String, Object> map : fromValue) {
            toList.add(convertValue(map, toValueType));
        }

        return toList;
    }

    public static List<Map<String, Object>> convertValues(List<Object> fromValue) {
        List<Map<String, Object>> toList = new ArrayList<>();
        for (Object obj : fromValue) {
            toList.add(convertValue(obj));
        }

        return toList;
    }

    public static String deleteAccents(String text) {
        String nfdNormalizedString = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        text = pattern.matcher(nfdNormalizedString).replaceAll("")
                .replaceAll("Đ", "D")
                .replaceAll("đ", "d");

        return text;
    }
}
