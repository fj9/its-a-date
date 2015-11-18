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
        else if (startsWithNext(textDate)) {
            String[] split = textDate.split(" ");
            if (split.length != 2) throw new IllegalArgumentException(textDate + "cannot be converted");
            try {
                DayOfWeek dayOfWeek = WeekDayFinder.convertToDayOfWeek(split[1]);
                //the beginning of this week
                int offset = -now.getDayOfWeek().getValue();
                //NEXT XXXDay is this day of week next week.
                offset = offset + dayOfWeek.getValue() + 7;
                return now.plus(offset, ChronoUnit.DAYS);
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Next must be follwed by day of week");
            }
        } else if (startsWithThis(textDate)) {
            String[] split = textDate.split(" ");
            if (split.length == 2) {
                //assume reference this xxxday
                DayOfWeek dayOfWeek = WeekDayFinder.convertToDayOfWeek(split[1]);
                if (dayOfWeek.getValue() >= now.getDayOfWeek().getValue())
                    return now.plusDays(dayOfWeek.getValue() - now.getDayOfWeek().getValue());
                else {
                    return now.minusDays(now.getDayOfWeek().getValue() - dayOfWeek.getValue());
                }
            } else {
                throw new IllegalArgumentException("This must be follwed by a day of week");
            }
        } else if (startsWithLast(textDate)) {
            String[] split = textDate.split(" ");
            if (split.length == 2) {
                //assume reference last xxxday
                //day of week as specified but last week
                DayOfWeek dayOfWeek = WeekDayFinder.convertToDayOfWeek(split[1]);
                int offset = dayOfWeek.getValue() - now.getDayOfWeek().getValue() - 7;
                return now.minusDays(offset);
            } else {
                throw new IllegalArgumentException("This must be follwed by a day of week");
            }
        } else if (isSpecialDay(textDate)) return now;
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

    private static boolean startsWithLast(String textDate) {
        return textDate.toLowerCase().startsWith("last");
    }

    private static boolean startsWithThis(String textDate) {
        return textDate.toLowerCase().startsWith("this");
    }

    private static boolean startsWithNext(String textDate) {
        return textDate.toLowerCase().startsWith("next");
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
