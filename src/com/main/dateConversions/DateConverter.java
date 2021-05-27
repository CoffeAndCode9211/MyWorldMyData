package com.main.dateConversions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final String DATE_TIME_FORMAT = "dd-MMM-yyyy HH:mm";

    public static Date convertStringToDate(String srcDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.parse(srcDate);
    }

    public static String convertDateToString(Date srcDate) {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(srcDate);
    }

    public static String convertStringToString(String srcDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date datee = formatter.parse(srcDate);
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        return formatter1.format(datee);
    }

    public static void main(String[] args) throws ParseException {
        try {
            System.out.println(convertStringToDate("12-May-2014 12:30"));
            System.out.println(convertDateToString(new Date()));
        } catch (ParseException pe) {
            throw pe;
        }
    }


    // Output:
    // Mon May 12 12:30:00 IST 2014
    // 26-Sep-2015 11:42


}
