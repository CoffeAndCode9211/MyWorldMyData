package com.main.dateConversions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimezoneConversion {

	private static final String DATE_TIME_FORMAT="dd-MMM-yyyy HH:mm";

	public static void convertDateTime(Date srcDate, String timezone){
			DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
			formatter.setTimeZone(TimeZone.getTimeZone(timezone));
			String date = formatter.format(srcDate);
			System.out.println(new Date());
			System.out.println(date);
	}

	public static void main(String[] args){
		convertDateTime(new Date(), "US/Pacific");
	}

}

