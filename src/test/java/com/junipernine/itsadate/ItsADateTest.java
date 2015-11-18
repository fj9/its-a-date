package com.junipernine.itsadate;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created on 17/11/2015.
 */
public class ItsADateTest {
    LocalDate now = LocalDate.now();

    @Test
    public void testYesterday() throws Exception {
        LocalDate result = ItsADate.parseLocalDate("yesterday");
        assertThat(result, is(LocalDate.now().minus(1, ChronoUnit.DAYS)));
    }

    @Test
    public void testToday() throws Exception {
        LocalDate result = ItsADate.parseLocalDate("Today");
        assertThat(result, is(LocalDate.now()));
    }

    @Test
    public void testTomorrow() throws Exception {
        LocalDate result = ItsADate.parseLocalDate("TOMORROW");
        assertThat(result, is(LocalDate.now().plus(1, ChronoUnit.DAYS)));
    }

    @Test
    public void testNextWednesday() throws Exception {
        LocalDate result = ItsADate.parseLocalDate("NEXT WEDNESDAY");
        //Next XXXday is always that day next week.
        int offset = DayOfWeek.WEDNESDAY.getValue() - now.getDayOfWeek().getValue() + 7;
        assertThat(result, is(now.plus(offset, ChronoUnit.DAYS)));
    }

    @Test
    public void testThisMonday() throws Exception {
        LocalDate result = ItsADate.parseLocalDate("This Monday");
        int offset = DayOfWeek.MONDAY.getValue() - now.getDayOfWeek().getValue();
        assertThat(result, is(now.plusDays(offset)));
    }

    @Test
    public void testLastFriday() {
        LocalDate result = ItsADate.parseLocalDate("Last Friday");
        int offset = DayOfWeek.FRIDAY.getValue() - now.getDayOfWeek().getValue() - 7;
        assertThat(result, is(now.minusDays(offset)));
    }
}