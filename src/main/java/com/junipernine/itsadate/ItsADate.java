package com.junipernine.itsadate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class ItsADate {
    public static LocalDate parseLocalDate(String textDate) {
        LocalDate now = LocalDate.now();
        if (textDate.equalsIgnoreCase("today")) return now;
        else if (textDate.equalsIgnoreCase("tomorrow")) return now.plus(1, ChronoUnit.DAYS);
        else if (textDate.equalsIgnoreCase("yesterday")) return now.minus(1, ChronoUnit.DAYS);
        else if (startsWithNext(textDate)){
            String[] split = textDate.split(" ");
            if(split.length==1) throw new IllegalArgumentException("Next on its own means nothing");
            return now;
        }
        else if (isSpecialDay(textDate)) return now;
        else if (isRelationalDay(textDate)) {
//            try {
//                DayOfWeek dayOfWeek = DayOfWeek.valueOf(textDate);
//                if (dayOfWeek.equals(now.getDayOfWeek())) return now;
//                else
//                    caclculateDayOffset();
//                LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth() + (dayOfWeek);
//            } catch (Exception e) {
//            }
            return now;

        } else return now;
    }

    private static boolean startsWithNext(String textDate) {
        return  textDate.toLowerCase().startsWith("next");
    }

    private static boolean isSpecialDay(String textDate) {
        if (textDate.equalsIgnoreCase("Christmas") ||
                textDate.equalsIgnoreCase("Xmas")) return true;
        else return false;
    }

    private static boolean isRelationalDay(String textDate) {
        if (textDate.toLowerCase().contains("after") ||
                textDate.toLowerCase().contains("before") ||
                textDate.split(" ").length == 1) return true;
        else return false;
    }

}
