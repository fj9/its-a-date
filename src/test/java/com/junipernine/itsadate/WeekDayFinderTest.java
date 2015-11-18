package com.junipernine.itsadate;

import org.junit.Test;

import java.time.DayOfWeek;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created on 17/11/2015.
 */
public class WeekDayFinderTest {

    @Test
    public void longDay(){
        DayOfWeek dayOfWeek = WeekDayFinder.convertToDayOfWeek("Friday");
        assertThat(dayOfWeek, is(DayOfWeek.FRIDAY));
    }
    @Test
    public void shortDay(){
        DayOfWeek dayOfWeek = WeekDayFinder.convertToDayOfWeek("Tue");
        assertThat(dayOfWeek, is(DayOfWeek.TUESDAY));
    }
    @Test (expected = IllegalArgumentException.class)
    public void notAday(){
        WeekDayFinder.convertToDayOfWeek("toast");
    }
}