package com.junipernine.itsadate;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by anthonydawson on 17/11/2015.
 */
public class ConvertNumberTest {

    @Test
    public void testFirstOrdinalNumber() throws Exception {
        int result = ConvertNumber.fromOrdinalNumber("First");
        assertThat(result, is(1));
    }

    @Test
    public void testSecondOrdinalNumber() throws Exception {
        int result = ConvertNumber.fromOrdinalNumber("Second");
        assertThat(result, is(2));
    }
}