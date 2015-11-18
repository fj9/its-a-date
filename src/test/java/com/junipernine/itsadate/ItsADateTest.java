package com.junipernine.itsadate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created on 17/11/2015.
 */
public class ItsADateTest {
    LocalDate now  = LocalDate.now();

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
        assertThat(result, is(LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth()+1)));
    }
}