package com.junipernine.itsadate;

import com.google.common.collect.ImmutableMap;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 17/11/2015.
 */
public class WeekDayFinder {
    private static Map<String, DayOfWeek> nickNames = ImmutableMap.<String, DayOfWeek>builder()
            .put("MON", DayOfWeek.MONDAY)
            .put("TUE", DayOfWeek.TUESDAY)
            .put("TUES", DayOfWeek.TUESDAY)
            .put("THU", DayOfWeek.THURSDAY)
            .put("THURS", DayOfWeek.THURSDAY)
            .put("FRI", DayOfWeek.FRIDAY)
            .put("SAT", DayOfWeek.SATURDAY)
            .put("SUN", DayOfWeek.SUNDAY)
            .build();


    public static boolean isWeekDay(String possibleDay) {
        return true;
    }

    public static DayOfWeek convertToDayOfWeek(String s) {
        String possibleDay = s.toUpperCase().trim();
        DayOfWeek day = null;
        try {
            day = DayOfWeek.valueOf(possibleDay);
        } catch (IllegalArgumentException ex) {
            if (nickNames.containsKey(possibleDay))
                day = nickNames.get(possibleDay);
            else throw new IllegalArgumentException(s + " is not a recognised day", ex);
        }
        return day;
    }
}
