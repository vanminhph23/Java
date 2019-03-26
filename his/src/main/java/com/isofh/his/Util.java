package com.isofh.his;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static List<Long> convertIntToLong(List<Integer> source) {
        if (source == null) {
            return new ArrayList<>();
        }
        return source.stream().map(Long::valueOf).collect(Collectors.toList());
    }
}
