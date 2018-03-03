package com.premier.leek.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateFormatterFactory {

    public static String formatDateForDateSeparator(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        DateTime dt = formatter.parseDateTime(inputDate);
        return dt.toString("EEEE dd MMMM");
    }

    public static String formatDateForFixture(String inputDate) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        DateTime dt = formatter.parseDateTime(inputDate);
        return dt.toString("HH:mm");
    }
}
