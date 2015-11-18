package com.junipernine.itsadate;

import java.time.DayOfWeek;
import com.google.common.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 17/11/2015.
 */
public class WeekDayFinder {
//    private static Map<String, DayOfWeek> nickNames = ImmutableMap
//       "MON", DayOfWeek.MONDAY;
//      "TUE", DayOfWeek.TUESDAY;
//      "TUES", DayOfWeek.TUESDAY);
//      "WED", DayOfWeek.WEDNESDAY);
//      "THU", DayOfWeek.THURSDAY);
//      "THURS", DayOfWeek.THURSDAY);
//      "FRI", DayOfWeek.FRIDAY);
//      "SAT", DayOfWeek.SATURDAY);
//      "SUN", DayOfWeek.SUNDAY);
//    };

    public static boolean isWeekDay(String possibleDay) {
        return true;
    }

    public static DayOfWeek convertToDayOfWeek(String s) {
        ImmutableMap
        String possibleDay = s.toUpperCase().trim();
        DayOfWeek day = null;
        try {
            day = DayOfWeek.valueOf(possibleDay);
        } catch (IllegalArgumentException ex) {
            if (nickNames.containsKey(possibleDay))
                day = nickNames.get(possibleDay);
            else throw new IllegalArgumentException(s+" is not a recognised day", ex);
        }
        return day;
    }
}
