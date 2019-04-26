package com.isofh.his.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    public static Date getMinDate() {
        return DateUtils.setYears(truncateMonth(new Date()), 1870);
    }

    public static Date getMaxDate() {
        return DateUtils.addYears(truncateMonth(new Date()), 100);
    }

    public static Date truncateMonth(Date date) {
        return DateUtils.truncate(truncateDate(date), Calendar.MONTH);
    }

    public static Date truncateDate(Date date) {
        return DateUtils.truncate(truncateHour(date), Calendar.DATE);
    }

    public static Date truncateHour(Date date) {
        return DateUtils.truncate(truncateMinute(date), Calendar.HOUR_OF_DAY);
    }

    public static Date truncateMinute(Date date) {
        return DateUtils.truncate(truncateSecond(date), Calendar.MINUTE);
    }

    public static Date truncateSecond(Date date) {
        return DateUtils.truncate(truncateMillisecond(date), Calendar.SECOND);
    }

    public static Date truncateMillisecond(Date date) {
        return DateUtils.truncate(date, Calendar.MILLISECOND);
    }

    public static boolean isValidDate(Date date) {
        if (date == null) {
            return false;
        }

        Date minDate = getMinDate();
        Date maxDate = getMaxDate();
        if (date.compareTo(minDate) >= 0 && date.compareTo(maxDate) <= 0) {
            return true;
        }

        return false;
    }

    public static Date parseValidDate(String dateStr) throws ParseException {
        return parseValidDate(dateStr, null);
    }

    public static int truncatedHourCompareTo(Date date1, Date date2) {
        return truncateHour(date1).compareTo(truncateDate(date2));
    }

    public static Date parseValidDate(String dateStr, String parsePattern) throws ParseException {
        if (dateStr == null) {
            return null;
        }

        Date date;

        if (parsePattern != null) {
            date = DateUtils.parseDate(dateStr, parsePattern);

            if (isValidDate(date)) {
                return date;
            }

            return null;
        }

        String yyyyPattern = "[1-2][0-9]{3}";
        String yyyy = "yyyy";
        if (dateStr.matches("^" + yyyyPattern + "$")) {
            date = DateUtils.parseDate(dateStr, yyyy);

            if (isValidDate(date)) {
                return date;
            }
        }

        String ddPattern = "[0-3][0-9]";
        String dd = "dd";
        String dPattern = "[1-9]";
        String d = "d";
        String mmPattern = "(0[1-9]|1[0-2])";
        String mm = "MM";
        String mPattern = "[1-9]";
        String m = "M";
        String yyPattern = "[0-9]{2}";
        String yy = "yy";
        String[] separateChars = {"", "/", "-", "."};


        for (String separateChar : separateChars) {
            Map<String, String> parsePatterns = new HashMap<>();
            parsePatterns.put("^" + ddPattern + separateChar + mmPattern + separateChar + yyyyPattern + "$", dd + separateChar + mm + separateChar + yyyy);// dd/MM/YYYY
            parsePatterns.put("^" + dPattern + separateChar + mmPattern + separateChar + yyyyPattern + "$", d + separateChar + mm + separateChar + yyyy);// d/MM/YYYY
            parsePatterns.put("^" + ddPattern + separateChar + mPattern + separateChar + yyyyPattern + "$", dd + separateChar + m + separateChar + yyyy);// dd/M/YYYY
            parsePatterns.put("^" + dPattern + separateChar + mPattern + separateChar + yyyyPattern + "$", d + separateChar + m + separateChar + yyyy);// d/M/YYYY
            parsePatterns.put("^" + mmPattern + separateChar + yyyyPattern + "$", mm + separateChar + yyyy);// MM/YYYY
            parsePatterns.put("^" + mPattern + separateChar + yyyyPattern + "$", m + separateChar + yyyy);// M/YYYY
            parsePatterns.put("^" + ddPattern + separateChar + mmPattern + separateChar + yyPattern + "$", dd + separateChar + mm + separateChar + yy);// dd/MM/YY
            parsePatterns.put("^" + dPattern + separateChar + mmPattern + separateChar + yyPattern + "$", d + separateChar + mm + separateChar + yy);// d/MM/YY
            parsePatterns.put("^" + ddPattern + separateChar + mPattern + separateChar + yyPattern + "$", dd + separateChar + m + separateChar + yy);// dd/M/YY
            parsePatterns.put("^" + dPattern + separateChar + mPattern + separateChar + yyPattern + "$", d + separateChar + m + separateChar + yy);// d/M/YY
            parsePatterns.put("^" + mmPattern + separateChar + yyPattern + "$", mm + separateChar + yy);// MM/YY
            parsePatterns.put("^" + mPattern + separateChar + yyPattern + "$", m + separateChar + yy);// M/YY

            for (String key : parsePatterns.keySet()) {
                if (!dateStr.matches(key)) {
                    continue;
                }

                date = DateUtils.parseDate(dateStr, parsePatterns.get(key));
                if (isValidDate(date)) {
                    return date;
                }
            }
        }

        return null;
    }
}
