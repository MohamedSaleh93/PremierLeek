package com.premier.leek.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFormatterFactoryTest {
    @Test
    public void formatDateForDateSeparator() throws Exception {
        String formattedDate = DateFormatterFactory.formatDateForDateSeparator("2018-03-03T12:30:00Z");
        Assert.assertTrue(formattedDate.equals("Saturday 03 March"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatDateForDateSeparatorIvalidFormat() {
        String formattedDate = DateFormatterFactory.formatDateForDateSeparator("2018-03-03");
        Assert.assertFalse(formattedDate.equals("Saturday 03 March"));
    }

    @Test
    public void formatDateForFixture() throws Exception {
        String formattedDate = DateFormatterFactory.formatDateForFixture("2018-03-03T12:30:00Z");
        Assert.assertTrue(formattedDate.equals("14:30"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void formatDateForFixtureInvalideFormat() {
        String formattedDate = DateFormatterFactory.formatDateForFixture("12:30:00Z");
        Assert.assertTrue(formattedDate.equals("14:30"));
    }

}