package org.junit.tests;

import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeekTest {

    @Test
    public void testWeekConstructorValidInput() {
        Date time = new Date();
        TimeZone zone = TimeZone.getDefault();
        Week week = new Week(time, zone);
        assertNotNull(week);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeekConstructorNullTime() {
        Date time = null;
        TimeZone zone = TimeZone.getDefault();
        new Week(time, zone);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWeekConstructorNullZone() {
        Date time = new Date();
        TimeZone zone = null;
        new Week(time, zone);
    }

    @Test
    public void testWeekConstructorBoundaryCase() {
        Date time = new Date(Long.MAX_VALUE);
        TimeZone zone = TimeZone.getDefault();
        Week week = new Week(time, zone);
        assertNotNull(week);
    }

    @Test
    public void testWeekConstructorEdgeCase() {
        Date time = new Date(Long.MIN_VALUE);
        TimeZone zone = TimeZone.getDefault();
        Week week = new Week(time, zone);
        assertNotNull(week);
    }
}