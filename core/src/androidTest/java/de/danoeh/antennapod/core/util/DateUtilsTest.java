package de.danoeh.antennapod.core.util;


import android.test.AndroidTestCase;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtilsTest extends AndroidTestCase {

    public void testParseDateWithMicroseconds() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 13, 31, 4);
        Date expected = new Date(exp.getTimeInMillis() + 963);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.963870");
        assertEquals(expected, actual);
    }

    public void testParseDateWithCentiseconds() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 13, 31, 4);
        Date expected = new Date(exp.getTimeInMillis() + 960);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.96");
        assertEquals(expected, actual);
    }

    public void testParseDateWithDeciseconds() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 13, 31, 4);
        Date expected = new Date(exp.getTimeInMillis() + 900);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.9");
        assertEquals(expected.getTime()/1000, actual.getTime()/1000);
        assertEquals(900, actual.getTime()%1000);
    }

    public void testParseDateWithMicrosecondsAndTimezone() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 6, 31, 4);
        exp.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date expected = new Date(exp.getTimeInMillis() + 963);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.963870 +0700");
        assertEquals(expected, actual);
    }

    public void testParseDateWithCentisecondsAndTimezone() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 6, 31, 4);
        exp.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date expected = new Date(exp.getTimeInMillis() + 960);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.96 +0700");
        assertEquals(expected, actual);
    }

    public void testParseDateWithDecisecondsAndTimezone() throws Exception {
        GregorianCalendar exp = new GregorianCalendar(2015, 2, 28, 6, 31, 4);
        exp.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date expected = new Date(exp.getTimeInMillis() + 900);
        Date actual = DateUtils.parse("2015-03-28T13:31:04.9 +0700");
        assertEquals(expected.getTime()/1000, actual.getTime()/1000);
        assertEquals(900, actual.getTime()%1000);
    }

}