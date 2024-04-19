package org.jfree.data.time.junit;

import junit.framework.TestCase;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;

public class TimeSeriesTests extends TestCase {

    private TimeSeries series;

    protected void setUp() throws Exception {
        super.setUp();
        this.series = new TimeSeries("Test Series");
    }

    public void testCreateCopyValidRange() throws CloneNotSupportedException {
        this.series.add(new Year(2000), 100);
        this.series.add(new Year(2001), 200);
        TimeSeries copy = this.series.createCopy(new Year(2000), new Year(2001));
        assertEquals(2, copy.getItemCount());
    }

    public void testCreateCopyInvalidRange() {
        try {
            this.series.createCopy(new Year(2001), new Year(2000));
            fail("Expected IllegalArgumentException for invalid range");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (CloneNotSupportedException e) {
            fail("Unexpected CloneNotSupportedException for valid input");
        }
    }

    public void testCreateCopyNullArguments() {
        try {
            this.series.createCopy(null, new Year(2000));
            fail("Expected IllegalArgumentException for null start period");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (CloneNotSupportedException e) {
            fail("Unexpected CloneNotSupportedException for valid input");
        }

        try {
            this.series.createCopy(new Year(2000), null);
            fail("Expected IllegalArgumentException for null end period");
        } catch (IllegalArgumentException e) {
            // expected
        } catch (CloneNotSupportedException e) {
            fail("Unexpected CloneNotSupportedException for valid input");
        }
    }

    public void testCreateCopyEmptyRange() throws CloneNotSupportedException {
        this.series.add(new Year(2000), 100);
        TimeSeries copy = this.series.createCopy(new Year(2001), new Year(2002));
        assertEquals(0, copy.getItemCount());
    }

    public void testCreateCopySinglePoint() throws CloneNotSupportedException {
        this.series.add(new Year(2000), 100);
        TimeSeries copy = this.series.createCopy(new Year(2000), new Year(2000));
        assertEquals(1, copy.getItemCount());
    }

    public void testCreateCopyOutOfRange() throws CloneNotSupportedException {
        this.series.add(new Year(2000), 100);
        TimeSeries copy = this.series.createCopy(new Year(1999), new Year(1999));
        assertEquals(0, copy.getItemCount());
    }
}