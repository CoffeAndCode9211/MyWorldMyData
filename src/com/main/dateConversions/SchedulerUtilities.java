
package com.main.dateConversions;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;



public class SchedulerUtilities {
	private static final String DATE_TIME_FORMAT_DB="yyyy-MM-dd k:mm";
	private static final String DATE_TIME_FORMAT_DB_HH="yyyy-MM-dd HH:mm";
	private static final String DATE_FORMAT_GUI="MM/dd/yyyy";
	private static final String DATE_FORMAT_GUI_MMM="dd-MMM-yyyy";
	
	private static final String DATETIME_FORMAT_GUI = "MM/dd/yyyy HH:mm";
	private static final String DATETIME_FORMATMMM_GUI = "dd-MMM-yyyy HH:mm";
	
	private static final String DATE_FORMAT_GUI1="MMM-dd-yyyy HH:mm";
	private static final String DATE_TIME_FORMAT_GUI="MM/dd/yyyy HH:mm";
	private static final String ONLY_DATE_FORMAT_GUI="MM/dd/yyyy";
	private static final String ONLY_DATE_FORMAT_GUI_MMM="dd-MMM-yyyy";
	private static final String DATETIME_AMPM_FORMAT_GUI_MMM="dd-MMM-yyyy hh:mm a";
	private static final String ONLY_TIME_FORMAT_GUI = "HH:mm";
	private static final String DAY_OF_WEEK = "EEEE";
	private static final String DATE_TIME_FORMAT_DB_FULL = "yyyy-MM-dd HH:mm:ss";
	public static String USER_SESSION_ID = null;
	public static String DATE_FORMATE_FORM270 = "yyyyMMdd";
	public static String DATE_FORMATE_FORM270MsgDate="yymmdd";
	
	
	
	private static String PAYMENT_AMOUNT_IN_WORDS;
	private static String NUMBERS_1TO9_IN_WORDS[]={
		"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
	};

	private static String CURRENCY_DENOMINATION_IN_WORDS[]={
			"Hundred","Thousand","Lakh","Crore"
	};
	
	private static String TEENS_IN_WORDS[]={
			"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen",
	};
	
	
	private static String TENS_IN_WORDS[]={
			"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"
	};

	 public static String getMySqlDateStringFrmFormStringForMsg(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat(DATE_FORMATE_FORM270MsgDate);
		        String USDate=null;
		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat("yyMMdd");
		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	// logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }
	
	/**
	 * Gets mysql string date to GUI
	 * @param yyyy-MM-dd HH:mm:ss
	 * @return MM/dd/yyyy HH:mm
	 */
	 public static String getMySqlDateStringFrmFormString(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat(DATE_FORMATE_FORM270);
		        String USDate=null;
		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 //logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	
	 public static String getX12DatefromMySqlDate(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd");
		        String USDate=null;
		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat("yyyyMMdd");
		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 //logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }
	 
	 
	
	
	/**
	 * Gets mysql string date to GUI
	 * @param yyyy-MM-dd HH:mm:ss
	 * @return MM/dd/yyyy HH:mm
	 */
	 public static String getMysqlDatetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String USDate=null;
		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(DATE_TIME_FORMAT_GUI);
		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 // logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	 /**
	  * Change string date format from MySQL date string to Fileman
	  * @param date
	  * @return String
	  */
	 public static String changeDateFormatfromMySQLtoFileman(String date)
	    {
			String filemandate ="";
			try {
	        String arrdatetime[] = date.split(" ");
	        String strdate = arrdatetime[0];
	        String strtime = arrdatetime[1];
	        String arrdate[]= strdate.split("\\/");
	        String month = arrdate[0];
	        String day = arrdate[1];
	        String year = arrdate[2];
	        String arrtime[] = strtime.split("\\:");
	        String hour = arrtime[0];
	        String min = arrtime[1];
	        filemandate = (Integer.parseInt(year)-1700)+""+appendZero(month)+""+appendZero(day)+"."+appendZero(hour)+appendZero(min);
	        
			}catch(ArrayIndexOutOfBoundsException ae){
				// logger.info(ae.getMessage());
			}catch(Exception e){
				// logger.info(e.getMessage());
			}
	        
//			// logger.info("final fileman format date "+filemandate);
	        
	        return filemandate;
	    }
		
	 /**
	  * Change string date format from file man to Database
	  * @param String
	  * @return java.util.Date
	  */
	 public static Date changeDateFormatfromFilemantoDatabase(String date)
	    {
			String databasedate ="";
			Date dtdate =null;
			try {
//				// logger.info("changing fileman to database->Date:"+date);
		        String month = date.substring(3,5);
		        String day = date.substring(5,7);
		        String year = date.substring(0,3);	        		        
		        databasedate = (Integer.parseInt(year)+1700)+"-"+appendZero(month)+"-"+appendZero(day);	        
			}catch(ArrayIndexOutOfBoundsException ae){
				// logger.info(ae.getMessage());
			}catch(Exception e){
				// logger.info(e.getMessage());
			}	        
//			// logger.info("final database format date "+databasedate);
			try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			    dtdate = formatter.parse(databasedate);
			}catch(Exception e){
				// logger.error(e.getMessage());
			}	        
	        return dtdate;
	    }
	 
	    private static String appendZero(String str)
	    {
	        String retStr = "";
	        if(str.length()==1)
	        {
	            retStr = "0"+str;
	        }
	        else
	            retStr = str;
	        return retStr;
	    }
	    
	    
	    public static Date decreaseSecondByOne(Date date)
	    {
	        Date changedDate = new Date();
//	    	// logger.info("date before reducing min: "+date);
	    	Calendar newDate = Calendar.getInstance();
	    	newDate.setTime(date);
			newDate.add( Calendar.SECOND , -1 );
	    	changedDate = newDate.getTime(); 
//	    	// logger.info("date before reducing min: "+changedDate);
	        return changedDate;
	    }

	    
	    public static Date increaseSecondByOne(Date date)
	    {
	        Date changedDate = new Date();
//	    	// logger.info("date before reducing min: "+date);
	    	Calendar newDate = Calendar.getInstance();
	    	newDate.setTime(date);
			newDate.add( Calendar.SECOND , +1 );
	    	changedDate = newDate.getTime(); 
//	    	// logger.info("date before reducing min: "+changedDate);
	        return changedDate;
	    }

	    
	    
	 /**
	  * Gets GUI string date format(MM/dd/yyyy HH:mm) by converting the date/time with time zone 
	  * @param yyyy-MM-dd HH:mm
	  * @param MMM dd, yyyy hh:mm:ss a
	  * @return MM/dd/yyyy HH:mm
	  */
	 public static String convertDateTimefromDBToGui(Object result, String timezone){
		    try{
		    	
		    	//DateFormat formatter= DateFormat.getDateTimeInstance();
//		    	// logger.info("result........convert"+result);
		    	DateFormat formatter = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	TimeZone tz = TimeZone.getTimeZone(timezone);
		    	formatter.setTimeZone(tz);
		    	String strresult = result+"";
		    	String arr[] = strresult.split("\\.");
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(arr[0]);
		    	String d1 = formatter.format(date);
		    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	date = sdf2.parse(d1);
//		    	boolean daylight = tz.inDaylightTime(date);
//				if(daylight){
//					date = getDayLight(date);
//				}
				SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    	String strdate = sdf3.format(date);

		        return strdate;
		    } 
		    catch (ParseException e)
		    {
		    	 // logger.error("There is an exception");
		         e.printStackTrace(); 
              return null;
		    }
	 }
	 
	 /**
	  * Gets GUI string date format(MM/dd/yyyy HH:mm) by converting the date/time with time zone 
	  * @param yyyy-MM-dd HH:mm
	  * @param MMM dd, yyyy hh:mm:ss a
	  * @return MM/dd/yyyy HH:mm
	  */
	 public static String convertDateTimefromDBToGuiMMM(Object result, String timezone){
		    try{
		    	
		    	//DateFormat formatter= DateFormat.getDateTimeInstance();
		    	
//		    	// logger.info("result........convert"+result);
		    	DateFormat formatter = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	TimeZone tz = TimeZone.getTimeZone(timezone);
		    	formatter.setTimeZone(tz);
		    	String strresult = result+"";
		    	String arr[] = strresult.split("\\.");
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(arr[0]);
		    	String d1 = formatter.format(date);
//		    	// logger.info(" data......"+timezone+" : "+TimeZone.getTimeZone(timezone) +" : "+formatter.getTimeZone());
//		    	// logger.info("dl........"+d1);
		    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	date = sdf2.parse(d1);
//		    	// logger.info("date: "+date);
//		    	
//		    	boolean daylight = tz.inDaylightTime(date);
//				if(daylight){
//					date = getDayLight(date);
//				}
//				// logger.info("date 1: "+date);
				SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
		    	String strdate = sdf3.format(date);
//		    	// logger.info("date 3: "+strdate);
		        return strdate;
		    } 
		    catch (ParseException e)
		    {
		    	 // logger.error("There is an exception");
		         e.printStackTrace(); 
              return null;
		    }
	 }
	 
	 /**
	  * Gets GUI string date format(MM/dd/yyyy HH:mm) by converting the date & time with time zone
	  * @param yyyy-MM-dd HH:mm
	  * @param time
	  * @param MMM dd, yyyy hh:mm:ss a
	  * @return MM/dd/yyyy HH:mm
	  */
	 public static String convertDateAndTimeFromDBToGUI(Object resdate, Object time , String timezone){
		    try{
		    	
		    	TimeZone tz = TimeZone.getTimeZone(timezone);
		    	
		    	DateFormat formatter = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	formatter.setTimeZone(tz);
		    	String strresult = resdate+" "+time;
		    	String arr[] = strresult.split("\\.");
		    	
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date date = sdf.parse(arr[0]);
//				boolean daylight = tz.inDaylightTime(date);
//		    	
//				if(daylight){
//					date = getDayLight(date);					
//				}				
				
		    	String d1 = formatter.format(date);	
		    	
		    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a");
		    	date = sdf2.parse(d1);
				
		    	SimpleDateFormat sdf3 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		    	String strdate = sdf3.format(date);
				
				return strdate;
		    } 
		    catch (ParseException e)
		    {
		    	 // logger.error("There is an exception");
		         e.printStackTrace(); 
           return null;
		    }
	 }
	

	 /**
	  * Gets GUI only date string format(MM/dd/yyyy) from DB(yyyy-MM-dd)
	  * @param yyyy-MM-dd
	  * @return MM/dd/yyyy
	  */
	 public static String getMysqlOnlyDatetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 // logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	 
	 public static String getMysqlOnlyDateMMMtoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI_MMM);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 // logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }
	 
	 public static String getMysqlDatetimeMMMtoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("yyyy-MM-dd ");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI_MMM);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 // logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }

	 /**
	  * Gets GUI only time string format(HH:mm) from DB
	  * @param HH:mm
	  * @return HH:mm
	  */
	 public static String getMysqlOnlyTimetoGUI(String dt){
		    try{
		        SimpleDateFormat formatter, FORMATTER;
		        formatter = new SimpleDateFormat("HH:mm");
		        String USDate=null;

		        Date date = formatter.parse(dt);
		        FORMATTER = new SimpleDateFormat(ONLY_TIME_FORMAT_GUI);

		        USDate=FORMATTER.format(date);

		        return USDate;
		    } catch (ParseException e){
		    	 // logger.error("There is an exception");
		          e.printStackTrace(); 
		                 return null;
		    }
	 }
	 
	
	 
	/**
	 * Get java.util.Date from string TimeStamp
	 * @param tStampDate
	 * @return yyyy-MM-dd k:mm
	 */
	public static java.util.Date getDateFromStringTimeStamp(String tStampDate)
	{
		
		if(tStampDate == null || tStampDate.isEmpty()) {
			return null;
		}
		Date date = null;
		
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	          try {
	              date = (Date)formatter.parse(tStampDate);
	              
	          }
	          catch(ParseException e) {
	        	  // logger.error("There is an exception");
	        	  date = null;
	          }
	        return date;
	}
	/**
	 * Gets java.util.Date from Date TimeStamp
	 * @param java.util.date
	 * @return yyyy-MM-dd k:mm
	 */
	public static Date getDateFromDateTimeStamp(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	    formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	    try {
	              date = (Date)formatter.parse(formatter.format(date));
	              
	    }catch(ParseException e) {
	    	 // logger.error("There is an exception");
	        	  date = null;
	    }
	    return date;
	}
	
	
	
	
	public static Date getDateFromGiuToDb(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	    formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	              date = (Date)formatter.parse(formatter.format(date));
	              
	    }catch(ParseException e) {
	    	 // logger.error("There is an exception");
	        	  date = null;
	    }
	    return date;
	}
	
	
	public static Date getDateFromDbToGui(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	    formatter = new SimpleDateFormat("MM/dd/yyyy");
	    try {
	              date = (Date)formatter.parse(formatter.format(date));
	              
	    }catch(ParseException e) {
	    	 // logger.error("There is an exception");
	        	  date = null;
	    }
	    return date;
	}
	
	public static Date getDateFromDbToGuiMMM(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	    formatter = new SimpleDateFormat("dd-MMM-yyyy");
	    try {
	              date = (Date)formatter.parse(formatter.format(date));
	              
	    }catch(ParseException e) {
	    	 // logger.error("There is an exception");
	        	  date = null;
	    }
	    return date;
	}
	
	/**
	 * Gets string date from date time stamp of appointment. 
	 * @param java.util.date
	 * @return yyyy-MM-dd k:mm
	 */
	public static String getDateFromDateTimeStamp_appointment(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat(DATE_TIME_FORMAT_DB);
	    try {
	              strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 // logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	public static String getGUIDatetimeFromDbDateTime(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
	    try {
	              strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 // logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	public static String getDbDatetimeFromGUIDateTime(String guiDate)
	{	
		//// logger.info("Previous Date:"+guiDate);
		String USDate = "";
		try{
		SimpleDateFormat formatter, FORMATTER;
        formatter = new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
        

        Date date = formatter.parse(guiDate);
        FORMATTER = new SimpleDateFormat(DATE_TIME_FORMAT_DB_HH);

        USDate=FORMATTER.format(date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//// logger.info("After Date:"+USDate);
        return USDate;
	}
	
	public static String getDbOnlyDateFromGUIDate(String guiDate)
	{	
		String USDate = "";
		try{
		SimpleDateFormat formatter, FORMATTER;
        formatter = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI_MMM);
        

        Date date = formatter.parse(guiDate);
        FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

        USDate=FORMATTER.format(date);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return USDate;
	}
	
	
	
	public static String getDateFromDateTimeStamp_appointment1(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	              strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 // logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	/**
	 * 
	 * @param java.util.date
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getDateFromDateTimeStamp_showapp(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	        strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 // logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	/**
	 * 
	 * @param java.util.date
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getDateStringFromDateObject(Date date)
	{	
		if(date == null) {
			return null;
		}
		DateFormat formatter ;
		String strdate;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try {
	        strdate = formatter.format(date);
	    }catch(Exception e) {
	    	 // logger.error("There is an exception");
	    	strdate = null;
	    	e.printStackTrace();
	    }
	    return strdate;
	}
	
	
	/**
	 * 
	 * @param java.util.date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Date getHibernateDateFormat(Date date)
	{
		
		if(date == null) {
			return null;
		}
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          try {
	              String strDate = formatter.format(date);
	              date = formatter.parse(strDate);
	              
	          }
	          catch(ParseException e) {
	        	  // logger.error("There is an exception");
	        	  date = null;
	          }
	        return date;
	}
	
	
	/**
	 * Get GUI string date to string Mysql
	 * @param MM/dd/yyyy
	 * @return yyyy-MM-dd
	 */
	
	public static String getGUIDatetoMysql(String dt){
	    try{
	            String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	           
	            Date date = parseStringtoDate.parse(dt);
	            dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	            mysqlDate = dateFormat.format(date);
	            
	            return mysqlDate;
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * Get GUI string date time to Mysql string date time
	 * @param yyyy-MM-dd HH:mm
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getGUIDateTimeFromMySQL(String dt){
	    try{
	    		
	    		String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat;
	            parseStringtoDate= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	           
	            Date date = parseStringtoDate.parse(dt);
	            dateFormat= new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
	            mysqlDate = dateFormat.format(date);
	            
	          return mysqlDate;
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * Get Mysql string date time from string date and time zone
	 * @param yyyy-MM-dd HH:mm
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getDateTimeFromMySQL(String dt, String timezone){
	    try{
	    		DateFormat formatter= DateFormat.getDateTimeInstance();
	    		formatter.setTimeZone(TimeZone.getTimeZone(timezone));
	            String mysqlDate=null;
	            SimpleDateFormat parseStringtoDate,dateFormat,afterConvertDate;
	            parseStringtoDate= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            afterConvertDate=new SimpleDateFormat("MMM dd, yyyy HH:mm:ss aa");
	           
	            Date d = parseStringtoDate.parse(dt);
	            String d1 = formatter.format(d);
	            
	            Date date = afterConvertDate.parse(d1);
	            dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            mysqlDate = dateFormat.format(date);
	            
//	            System.out.println("Converted Date Time : " + mysqlDate);

	            return mysqlDate;
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    }
	/**
	 * 
	 * @param String MM/dd/yyyy
	 * @return java.util.date 
	 */
	public static Date getDatefromStringDate(String strdate){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            Date date = parseStringtoDate.parse(strdate);
	            return date;
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	public static Date getDatefromStringDateInMMM(String strdate){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy");
	            Date date = parseStringtoDate.parse(strdate);
	            return date;
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }
	
	/**
	 * 
	 * @param java.util.Date
	 * @return MM/dd/yyyy HH:mm
	 */
public static String getStringDateTimeFromDate(Date date) {	
		
		if(date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
        parseDatetoString = new SimpleDateFormat(DATE_TIME_FORMAT_GUI);
        String strdate = parseDatetoString.format(date);

	    return strdate;
}


public static String getDbDateTimeFromJavaDateTime(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_TIME_FORMAT_DB_FULL);
    String strdate = parseDatetoString.format(date);

    return strdate;
}


public static String getStringDateTimeInMMMFromDate(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
    String strdate = parseDatetoString.format(date);

    return strdate;
}

	/**
	 * This method will convert a sql date to MM/dd/yyyy format.
	 * 
	 * @param date
	 *            Date coming from database.
	 * @return Date formatted to MM/dd/yyyy format.
	 */
	public static String getStringDateOnlyFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	/**
	 * This method will convert a sql date to MM/dd/yyyy format.
	 * 
	 * @param date
	 *            Date coming from database.
	 * @return Date formatted to MM/dd/yyyy format.
	 */
	public static String getStringMMMDateOnlyFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(ONLY_DATE_FORMAT_GUI_MMM);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	public static String getStringMMMDateTimeInAMPmFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(DATETIME_AMPM_FORMAT_GUI_MMM);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	
	public static String getStringDateOnlyInDbFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = parseDatetoString.format(date);
		return strdate;
	}

	/**
	 * This method will convert a sql date to HH:mm format. Will pick only the
	 * time from the date.
	 * 
	 * @param date
	 *            Date coming from the database.
	 * @return Time from the incoming date in the format HH:mm
	 */
	public static String getStringTimeOnlyFromDate(Date date) {

		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(ONLY_TIME_FORMAT_GUI);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	/**
	 * This method will give back the Day name from the date.
	 * 
	 * @param date
	 *            Date from the database.
	 * @return Day name for e.g. Sunday etc.
	 */
	public static String getDayOfWeekFromDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat parseDatetoString;
		parseDatetoString = new SimpleDateFormat(DAY_OF_WEEK);
		String strdate = parseDatetoString.format(date);

		return strdate;
	}
	
	/**
	 * This method will convert a GUI date to Database Date.
	 * 
	 * @param date
	 *            String in format MM/dd/yyyy
	 * @return String in format yyyy-MM-dd
	 */
	public static String getSqlDateFromGui(String date) {
		if (date == null) {
			return null;
		}
		String[] dateFields = date.split("/");
		String formattedDate = dateFields[2]+"-"+dateFields[0]+"-"+dateFields[1];
		return formattedDate;
	}
	
	/**
	 * This method will convert a GUI date time to Database Date time.
	 * 
	 * @param date
	 *            String in format MM/dd/yyyy HH:mm
	 * @return String in format yyyy-MM-dd HH:mm
	 */
	public static String getSqlDateTimeFromGui(String date) {
		if (date == null) {
			return null;
		}
		String[] dateAndTime = date.split(" ");
		String[] dateFields = dateAndTime[0].split("/");
		String formattedDate = dateFields[2]+"-"+dateFields[0]+"-"+dateFields[1];
		String formattedDateTime = formattedDate+" "+dateAndTime[1];
		return formattedDateTime;
	}
	
	/**
	 * 
	 * @param java.util.Date
	 * @return MMM-dd-yyyy HH:mm
	 */
public static String getStringDateTimeFromDate1(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_FORMAT_GUI1);
    String strdate = parseDatetoString.format(date);

    return strdate;
}


public static String getStringDateTimeFromDate2(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strdate = parseDatetoString.format(date);

    return strdate;
}


public static String getStringDateTimeFromDateGui(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strdate = parseDatetoString.format(date);

    return strdate;
}

/**
 * 
 * @param java.util.Date
 * @return MM/dd/yyyy
 */
public static String getStringDateFromDate(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_FORMAT_GUI);
    String strdate = parseDatetoString.format(date);

    return strdate;
}


public static String getStringDateInMMMFromDate(Date date) {	
	
	if(date == null) {
		return null;
	}
	SimpleDateFormat parseDatetoString;
    parseDatetoString = new SimpleDateFormat(DATE_FORMAT_GUI_MMM);
    String strdate = parseDatetoString.format(date);

    return strdate;
}



public static Date getDayLight(Date date){

	Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.HOUR_OF_DAY, -1);
    return c.getTime();

}
/**
 * 
 * @param date
 * @param tzone
 * @return yyyy-MM-dd HH:mm z
 */
public static Date convertdatefromGuiToDb(String date, String tzone){
    try{
    	TimeZone  timezone = TimeZone.getTimeZone(tzone);
    	SimpleDateFormat sdfoffset = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		Date dateForOffset = sdfoffset.parse(date);
		
		String offset  =  SchedulerUtilities.getOffSet(timezone, dateForOffset);
		
		String frmdate = date+" "+offset;
//		// logger.info("offset :"+offset);				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm z");  
		Date dateFirst = sdf.parse(frmdate);
		
		boolean daylight = timezone.inDaylightTime(dateFirst);
//		// logger.info("daylight.........:"+daylight);
		
		// logger.info("d :"+dateFirst);
		return dateFirst;
    } 
    catch (ParseException e)
    {	 // logger.error("There is an exception");
         e.printStackTrace(); 
      return null;
    }
}

public static Date convertdatefromGuiToDb2(String date, String tzone){
    try{
//    	System.out.println("date :"+date+", tzone:"+tzone);
    	 TimeZone  timezone = TimeZone.getTimeZone(tzone);
//    	 System.out.println("Timezone :"+timezone);
    	 
	    SimpleDateFormat sdfoffset = new SimpleDateFormat("MM/dd/yyyy HH:mm");  
 		Date dateForOffset = sdfoffset.parse(date);
 		String offset  =  SchedulerUtilities.getOffSet(timezone, dateForOffset);
 		
//		// logger.info("offset: ..."+offset);
		
		String frmdate = date+" "+offset;
//		System.out.println("frmdate ->"+frmdate);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm z");  
		Date dateFirst = sdf.parse(frmdate);
		
//		System.out.println("Conversion frmdate ->"+dateFirst);
		return dateFirst;
    } 
    catch (ParseException e)
    {	 // logger.error("There is an exception");
         e.printStackTrace(); 
      return null;
    }
}


public static Date convertdatefromGuiMMMToDataBase(String date, String tzone){
    try{
//    	System.out.println("date :"+date+", tzone:"+tzone);
    	 TimeZone  timezone = TimeZone.getTimeZone(tzone);
//    	 System.out.println("Timezone :"+timezone);
    	 SimpleDateFormat sdfoffset = new SimpleDateFormat("dd-MMM-yyyy HH:mm");  
  		Date dateForOffset = sdfoffset.parse(date);
  		String offset  =  SchedulerUtilities.getOffSet(timezone, dateForOffset);
		
		
		String frmdate = date+" "+offset;
//		System.out.println("frmdate ->"+frmdate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm z");  
		Date dateFirst = sdf.parse(frmdate);
		
	//	boolean daylight = timezone.inDaylightTime(dateFirst);
		
//		if(daylight){
//			dateFirst = getDayLight(dateFirst);
//		}
//		
		
//		System.out.println("Conversion frmdate ->"+dateFirst);
		return dateFirst;
    } 
    catch (ParseException e)
    {	 // logger.error("There is an exception");
         e.printStackTrace(); 
      return null;
    }
}

	public static Date addDateStartTime(Date date){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 00:00:00");
	       }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	
	public static Date addDateEndTime(Date date){
		
	    try{
	    	 SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 23:59:59");	            
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	public static Date addDateStartTimeInMMM(Date date){
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 00:00:00");
	       }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	
	public static Date addDateEndTimeInMMM(Date date){
		
	    try{
	    	 SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 23:59:59");	            
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	
public static Date addEndDateStartVisitTime(Date date , String time){ // time: HH:mm
		
	    try{
	    	 SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy");
	            String strdate = parseStringtoDate.format(date);
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" "+time+":00");	            
	    }catch(Exception e){e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }

public static Date addEndDateStartVisitTimeMMM(Date date , String time){ // time: HH:mm
	
    try{
    	 SimpleDateFormat parseStringtoDate;
            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy");
            String strdate = parseStringtoDate.format(date);
            parseStringtoDate= new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            date = parseStringtoDate.parse(strdate+" "+time+":00");	            
    }catch(Exception e){e.printStackTrace();
    		return null;
    }
    return date;
    }
	

	public static Date addStringStartTime(String strdate){
		Date date=null;
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 00:00:00");
	            
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	public static Date addStringEndTime(String strdate){
		
		Date date=null;
	    try{
	            SimpleDateFormat parseStringtoDate;
	            parseStringtoDate= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            date = parseStringtoDate.parse(strdate+" 23:59:59");
	          
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    return date;
	    }
	
	
	/**
	 * 
	 * @param java.util.Date
	 * @return yyyy-MM-dd
	 */
	
	public static String getStringDatefromDate(Date date){
	    try{
	    	if(date == null) {
				return null;
			}	    	
	            SimpleDateFormat parseDatetoString;
	            parseDatetoString = new SimpleDateFormat("yyyy-MM-dd");
	            String strdate = parseDatetoString.format(date);
	            return strdate;
	    }catch(Exception e){
	    	 // logger.error("There is an exception");
	    	e.printStackTrace();
	    		return null;
	    }
	    }

	/**
	 * 
	 * @param String MM/dd/yyyy
	 * @return java.util.Date
	 */
	
	public static java.util.Date getDateFromString(String str) {
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
		
		   formatter = new SimpleDateFormat(DATE_FORMAT_GUI);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  date = null;
	          }
	        return date;
	}	
	
	public static java.util.Date getDateFromDateTimeStringMMM(String str) {
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
		
		   formatter = new SimpleDateFormat(DATE_FORMAT_GUI_MMM);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  date = null;
	          }
	        return date;
	}
	

	
	/**
	 * 
	 * @return current date and time yyyy-MM-dd HH:mm:ss
	 */
	public static java.util.Date getCurrentDateTime(){
		Date date = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  date = new Date();
//		    // logger.info(dateFormat.format(date));
	 		Calendar cal = Calendar.getInstance();
		   String str = dateFormat.format(cal.getTime());
		   date = (Date) dateFormat.parse(str);
//		    // logger.info(dateFormat.format(cal.getTime()));
		   
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @return current date MM/dd/yyyy 
	 */
	public static String getCurrentDate(){
		Date date = null;
		String currdate  = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		   date = new Date();
		   currdate = dateFormat.format(date);
		   
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		return currdate;
	}
	
	/**
	 * 
	 * @return current date dd-MMM-yyyy
	 */
	public static String getCurrentDateInMMM(){
		Date date = null;
		String currdate  = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		   date = new Date();
		   currdate = dateFormat.format(date);
		   
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		return currdate;
	}
	public static String getCurrentDateInDbFormat(){
		Date date = null;
		String currdate  = null;
		try{
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   date = new Date();
		   currdate = dateFormat.format(date);
		   
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		return currdate;
	}
	
	

	
	public static String getToTime(String fromTime,String duration){
		String toTime = null;
		try{
			String[] secMts = fromTime.split("\\:");
			int defaultMts = 60;
			
			if(60 == Integer.parseInt(duration)){
				toTime = String.valueOf(Integer.parseInt(secMts[0])+1)+":"+String.valueOf(secMts[1]);
			}else{				
				int x = defaultMts - Integer.parseInt(secMts[1]);
				String mts = String.valueOf(Integer.parseInt(duration)-x); 
				toTime = String.valueOf(Integer.parseInt(secMts[0])+1)+":"+mts;
			}			
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		
//		 // logger.info("toTime:"+toTime);
		
		return toTime;
	}	
	
	
	/**
	 * Added to convert duration in time 
	 * @param fromTime
	 * @param duration
	 * @return
	 */
	public static String getToTimeForAvailability(String fromTime,String duration){
		String toTime = null;
		try{
			String[] secMts = fromTime.split("\\:");
			String hr = "";
			String min = "";
			String hour = "";
			//int defaultMts = 60;
			
			if(60 == Integer.parseInt(duration))
			{
				if( Integer.parseInt(secMts[0])+1 == 24 )
				{
					toTime = "00:"+String.valueOf(secMts[1])+",true";	
				}
				else
				{
					hr = addzerotodata( Integer.parseInt(secMts[0])+1);
					toTime = hr+":"+String.valueOf(secMts[1])+",false";
				}
				
			}else{				
				
				int totMin = Integer.parseInt(secMts[1]) + Integer.parseInt(duration);
//				// logger.info("totMin: "+totMin);
				if( totMin >= 60)
				{
					
					
					int hourvalue = totMin / 60 ;
					int minvalue = totMin % 60;
					
					
					min = addzerotodata( minvalue );
					hour = addzerotodata(hourvalue );
					
//					// logger.info("Integer.parseInt(secMts[0])+1 : "+Integer.parseInt(secMts[0])+1);
					if( Integer.parseInt(secMts[0]) + hourvalue  == 24 )
					{
						toTime = "00:"+String.valueOf(min)+",true";	
					}
					else if( Integer.parseInt(secMts[0]) + hourvalue  > 24 )
					{
						
						int newtime = ( Integer.parseInt(secMts[0]) + hourvalue ) % 24 ;
						hr = addzerotodata( newtime);
						toTime = hr+":"+String.valueOf(min)+",true";	
					}
					
					else
					{
						hr = addzerotodata( Integer.parseInt(secMts[0])+1);
						toTime = hr+":"+String.valueOf(min)+",false";
					}
				}
				else
				{
					min = addzerotodata( totMin);
					toTime = secMts[0]+":"+String.valueOf(min)+",false";
				}
				
			}			
		}catch(Exception e){
			 // logger.error("There is an exception");
			e.printStackTrace();
		}
		
//		 // logger.info("toTime:"+toTime);
		
		return toTime;
	}	
	
	
	public static String addzerotodata( int value){
		String data = "";
		if( value < 10 )
		{
			data = "0"+value;
		}
		else
		{
			data = String.valueOf(value); 
		}
		
		return data;
	}
	
	
	
	public static Date changeDateTimeAccordingtoInstitutionTimeZone(String institutionTimzone, Date datetime){
		datetime = changeDateTimeAccordingtoTimeZone(institutionTimzone, "UTC", datetime);
		return datetime;
	}
	
	
	public static Date changeDateTimeAccordingtoTimeZone(String srctimezone, String desttimezone, Date newdate ){
         String str_date="03-May-13 19:42";
//		  // logger.info("new date :"+newdate);
        try{
 
        DateFormat formatternew = null ; 
        
        formatternew = new SimpleDateFormat("dd-MMM-yy HH:mm");
        newdate = formatternew.parse(str_date);
        
        DateFormat formatter= DateFormat.getDateTimeInstance();
//         // logger.info("formatter's timezone (local timezone): "+formatter.getTimeZone());
         formatter.setTimeZone(TimeZone.getTimeZone(srctimezone));
         
//          // logger.info("formatter's timezone (gamt): "+formatter.getTimeZone());
         str_date = formatter.format(newdate);
//          // logger.info("source time zone "+str_date);
         
         formatter.setTimeZone(TimeZone.getTimeZone(desttimezone));
         str_date = formatter.format(newdate);
//          // logger.info("destination str_date "+str_date);
         
        }catch(Exception e){
        	 // logger.error("There is an exception");
            e.printStackTrace();
        }
         return getDateFromStringTimeStamp(str_date);
    }

	public static boolean isDST(TimeZone timezone){
        int offsetofdst = timezone.getDSTSavings();
        boolean dst=false;
        if(offsetofdst==0){
            dst=false;
        }else {
            dst=true;
        }
        return dst;
    }
    
    public static String getOffSet(TimeZone timezone, Date date){
    	String finalstring="";
    	
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        int offset = timezone.getOffset(cal.getTimeInMillis());
        
//        // logger.info("offset calculation: .........."+offset);
        
        int hours = 0, min=0;
        hours = (offset)/(1000*60*60);
        int remainder = (offset)%(1000*60*60);
        min = remainder/(60*1000);
        String strhours="",strmin="";
        strhours=hours+"";
        strmin=min+"";
        
        if(hours>=0){
            if(strhours.length()==1){
                finalstring="+0"+strhours;
            }
            else{
                finalstring="+"+strhours+"";
            }
        }else{
             if(strhours.length()==2){
                finalstring=strhours.substring(0,1)+"0"+strhours.substring(1,strhours.length());
            }
            else{
                finalstring=strhours;
            }
        }
        if(min>=0){
            if(strmin.length()==1){
                finalstring+="0"+strmin;
            }else{
                finalstring+=strmin;
            }
        }else{
             if(strmin.startsWith("-")){
                finalstring+=strmin.substring(1,strmin.length());
            }
            else{
                finalstring+=strmin;
            }
        }  
    	
//        // logger.info("finalstring:,......."+finalstring);
             return finalstring;
   }
    /**
     * 
     * @param Date and time String
     * @return MM/dd/yyyy HH:mm
     */
	public static java.util.Date getDateTimeFromString(String str) {	
		
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat(DATETIME_FORMAT_GUI);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  e.printStackTrace();
	        	  date = null;
	          }
//	           // logger.info("Date:"+date);
	        return date;
	}
	
public static java.util.Date getDateTimeMMMFromString(String str) {	
		
		if(str == null || str.isEmpty()) {
			return null;
		}
		 Date date = null;
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
	          try {
	              date = (Date)formatter.parse(str);
	          }
	          catch(ParseException e) {
	        	  e.printStackTrace();
	        	  date = null;
	          }
//	           // logger.info("Date:"+date);
	        return date;
	}
	
public static java.util.Date getDateTimeMMMSSFromString(String str) {	
	
	if(str == null || str.isEmpty()) {
		return null;
	}
	 Date date = null;
	DateFormat formatter ; 
          formatter = new SimpleDateFormat(DATETIME_FORMATMMM_GUI);
          try {
              date = (Date)formatter.parse(str);
          }
          catch(ParseException e) {
        	  e.printStackTrace();
        	  date = null;
          }
//           // logger.info("Date:"+date);
        return date;
}
	
public static java.util.Date getDateTimeFromObject(Object str) {	
		
		String strresult = str+"";
//		// logger.info("date is : "+strresult);
		String arr[] = strresult.split("\\.");
//		// logger.info("date arr : "+arr[0]);
		Date date = null;
		DateFormat formatter ; 
	          formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	          try {
	              date = (Date)formatter.parse(arr[0]);
	          }
	          catch(ParseException e) {
	        	  e.printStackTrace();
	        	  date = null;
	          }
//	           // logger.info("Date:"+date);
	        return date;
	}


public static String getMysqlDatetoGUIFromObject(Object str){ // yyyy-MM-dd HH:mm:ss.a
    try{
    	String strresult = str+"";
//		// logger.info("date is : "+strresult);
		String arr[] = strresult.split("\\.");
//		// logger.info("date arr : "+arr[0]); //yyyy-MM-dd HH:mm:ss
		
        return arr[0];
    } catch (Exception e){
    	 // logger.error("There is an exception");
          e.printStackTrace(); 
                 return null;
    }
}


/**
 * This method is used to encrypt(MD5 encryption) the password for the user prior to saving in the database.
 * @param password string to encrypt
 * @return encrypted Password
 */
public static String hashPassword(String password) {
    String hashword = null;
    try {
//    	// logger.info("password before:"+password);
        MessageDigest md5 = MessageDigest.getInstance("MD5");            
        md5.update(password.getBytes());
        BigInteger hash = new BigInteger(1, md5.digest());
        hashword = hash.toString(16);
//        // logger.info("password after:"+hashword);
    }catch (Exception e) {
        e.printStackTrace();
     }	        
    return hashword;
}

public static String getStrFromDateDb(Date date)
{	
	if(date == null) {
		return null;
	}
	DateFormat formatter ;
	String strdate;
    formatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
              strdate = formatter.format(date);
    }catch(Exception e) {
    	 // logger.error("There is an exception");
    	strdate = null;
    	e.printStackTrace();
    }
    return strdate;
}

public static Date getDateIncrementByOne(Date date){

//	// logger.info("initial date "+date);
	Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.DATE, 1);
//    // logger.info("incremented date "+c.getTime());
    
    
    return c.getTime();

}


public static String getDateTimeFromDb(Date date) {

	if (date == null) {
		return null;
	}
	DateFormat formatter;
	String strdate;
	formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	try {
		strdate = formatter.format(date);
	} catch (Exception e) {
		// logger.error("There is an exception");
		strdate = null;
		e.printStackTrace();
	}
	return strdate;
}


public static String CalcAge (Object dob) throws Exception {
    
    if(dob == null || dob.equals("")){
        return "";
    }
    int month = 0; int day = 0; int year = 0;
    String age[]=dob.toString().split("-");
    year=Integer.valueOf(age[0]);
    month=Integer.valueOf(age[1]);
    day=Integer.valueOf(age[2]);
    month--; // following the 0-based rule
    Calendar cal = new GregorianCalendar(year, month, day);
    /* date today */
    java.util.Date today = new java.util.Date();
    /* year now */
    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
    int intYear = Integer.parseInt(sdfYear.format(today));
    /* month now */
    SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
    int intMonth = Integer.parseInt(sdfMonth.format(today));
    intMonth--; // following the 0-based rule
    /* day now */
    SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
    int intDay = Integer.parseInt(sdfDay.format(today));

    /* calendar date now */
    Calendar now = new GregorianCalendar(intYear, intMonth, intDay);

    /* years duration */
    int yyyy = intYear - year;

    /* array of days in 12 months */
    int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /*
     * an indicator if given date has already occurred. (-1) - if given date
     * is greater than the current date; 0 - if given date has not yet
     * occurred or if it's equal to the current date.
     */
    int factor = 0;

    int mm = 0; // month duration

    int dd = 0; // day duration

    /* determine if given date is greater than or equal to the current date */
    if ((month > intMonth) || (month == intMonth && day > intDay)) {
        factor = -1;
        yyyy += factor;
    }

    /* throw if any of the following exceptions occur */
    if (month > 12) {
        //throw new Exception("Invalid input month");
    	return "";
    } else if (day > months[month]) {
        //throw new Exception("Invalid input day");
    	return "";
    } else if (yyyy < 0) {
        //throw new Exception("Invalid input date");
        return "";
    }

    /*
     * if the given date has already passed or if it's equal to the current
     * date
     */
    if (factor == 0) {
        // compute for days in between the given and the current date
        dd = now.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        /* determine if the current year is a leap year */
        if ((intYear % 4) == 0) {
            months[1]++; // increment the days in February by 1
        }
        /*
         * compute for day duration and month duration between the given
         * date and the given day of the current month
         */
        for (int i = month; i <= intMonth; i++) {
            if (dd >= months[i]) {
                dd -= months[i];
                mm++;
            }
        }
        /*
         * if computed month duration is more than 12, finalize values for
         * year and month duration
         */
        if (mm >= 12) {
            yyyy += (mm / 12);
            mm %= 12;
        }
    } else { // if the given date is greater than the current date
        intYear--; // derive previous year
        /* set Calendar date for December 31 of the previous year */
        Calendar prev = new GregorianCalendar(intYear, 11, 31);
        /*
         * compute the days in between the given date last year and the
         * current date
         */
        dd = (prev.get(Calendar.DAY_OF_YEAR) - cal
                .get(Calendar.DAY_OF_YEAR))
                + now.get(Calendar.DAY_OF_YEAR);
        /* determine if previous year is a leap year */
        if ((intYear % 4) == 0) {
            months[1]++; // increment the days in February by 1
        }
        /*
         * compute for day duration and month duration between the given
         * date and the given day in December of the previous year
         */
        for (int i = month; i <= 11; i++) {
            if (dd >= months[i]) {
                dd -= months[i];
                mm++;
            }
        }
        intYear++; // set the value back to the current year
        /* determine if current year is a leap year */
        if ((intYear % 4) == 0) {
            months[1]++; // increment the days in February by 1
        }
        /*
         * compute for day duration and month duration between the given day
         * in January of the current year and the current date
         */
        for (int i = 0; i <= intMonth; i++) {
            if (dd >= months[i]) {
                dd -= months[i];
                mm++;
            }
        }
        /*
         * if computed month duration is more than 12, finalize values for
         * year and month duration
         */
        if (mm >= 12) {
            yyyy += (mm / 12);
            mm %= 12;
        }
    }

    /* computed duration in years, months and days */
    if(yyyy==0 && mm==0 && dd==0){
     dd=1;
    return yyyy+"Y "+mm+"M "+dd+"D";
    }else{
    return yyyy+"Y "+mm+"M "+dd+"D";
    }
/*yyyy + " Year(s), " + mm + " Month(s), and " + dd + " Day(s) ";*/

}


public static Date currentTime() {

	Calendar cal = Calendar.getInstance();
	cal.getTime();
	//SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	//// logger.info( sdf.format(cal.getTime()) );
	return cal.getTime();
 }

public static long getNoOfDaysBetweenTwoDate(Date fromDate , Date toDate ) {
	
	long diff= toDate.getTime() - fromDate.getTime();
	double difference = diff/(1000.0*24*60*60);
//	// logger.info("difference in double : "+difference);
	long noOfDays=  Math.round(difference);
	return noOfDays;
 }

/**
 * This is the method to covert datetime in vista format
 * @param date as Sting from database
 * @retun String vistaDateTime
 */
public static String getVistaDateTime(String dbDate){
	String vistaDateTime = null;
	try{
		String date = dbDate.split(" ")[0];
		String time = dbDate.split(" ")[1];
		String day = "";
		String mon = "";
		int year = 0;
		int vistaYear = 0;
		String hour = "";
		String min = "";
		String sec = "";
		
		year = Integer.parseInt(date.split("-")[0]);
		mon = date.split("-")[1];
		day = date.split("-")[2];
		
		hour = time.split(":")[0];
		min = time.split(":")[1];
		sec = time.split(":")[2];
		
		vistaYear = year-1700;
		
		//logger.info(sec.substring(0,2));
		
		vistaDateTime = vistaYear+mon+day+"."+hour+min+sec.substring(0,2);
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
}
	return vistaDateTime;
}


public static String getMysqlOnlyDateMMMGUIToDb(String dt){
    try{
        SimpleDateFormat formatter, FORMATTER;
        formatter = new SimpleDateFormat(DATE_FORMAT_GUI_MMM);
        String USDate=null;

        Date date = formatter.parse(dt);
        FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

        USDate=FORMATTER.format(date);

        return USDate;
    } catch (ParseException e){
    	  e.printStackTrace(); 
                 return null;
    }
}

public static String getAmountInWords(String p){
try{
  String cent="";
  String dollars ="";
  String total="";
  
   if(p.contains(".")){
           cent=p.substring(p.indexOf(".")+1);
           dollars = p.substring(0,p.indexOf("."));

           System.out.println("This is cents"+cent);

       if(cent.equalsIgnoreCase("00") ||
              cent.equalsIgnoreCase("0") ){
                 dollars= convertNumToWord(dollars);
                 total = dollars +" dollar(s)";
           }else if(dollars.equalsIgnoreCase("00") ||
              dollars.equalsIgnoreCase("0") ){
                if(cent.length()==1){
                  cent=cent+"0";
                 }
                 cent=convertNumToWord(cent);
                 total = cent +" cent(s)" ;
           }else{
               dollars=convertNumToWord(dollars);
               if(cent.length()==1){
               cent=cent+"0";
               }
               cent=convertNumToWord(cent);
               total = dollars + " dollar(s)"+" and "+ cent+" cent(s)" ;
           }
     }
    else {
       dollars=convertNumToWord(p);
       total =  dollars +  " dollar(s)";
     }

     return total;
    }catch(Exception e){
        e.printStackTrace();
       return null;
    }
}

public static String convertNumToWord(String str){
		String no= str;
		int number=Integer.parseInt(no);
		
		int cc=1;
		int rm ;
		PAYMENT_AMOUNT_IN_WORDS="";
		while ( number != 0 )
		{
		switch ( cc )
		{
		case 1 :
		rm = number % 100 ;
		passNumber ( rm ) ;
		if( number > 100 && number % 100 != 0 )
		{
		getWordForNumber ( "and " ) ;
		}
		number /= 100 ;
		
		break ;
		
		case 2 :
		rm = number % 10 ;
		if ( rm != 0 )
		{
		getWordForNumber ( " " ) ;
		getWordForNumber ( CURRENCY_DENOMINATION_IN_WORDS[0] ) ;
		getWordForNumber ( " " ) ;
		passNumber ( rm ) ;
		}
		number /= 10 ;
		break ;
		
		case 3 :
		rm = number % 100 ;
		if ( rm != 0 )
		{
		getWordForNumber ( " " ) ;
		getWordForNumber ( CURRENCY_DENOMINATION_IN_WORDS[1] ) ;
		getWordForNumber ( " " ) ;
		passNumber ( rm ) ;
		}
		number /= 100 ;
		break ;
		
		case 4 :
		rm = number % 100 ;
		if ( rm != 0 )
		{
		getWordForNumber ( " " ) ;
		getWordForNumber ( CURRENCY_DENOMINATION_IN_WORDS[2] ) ;
		getWordForNumber ( " " ) ;
		passNumber ( rm ) ;
		}
		number /= 100 ;
		break ;
		
		case 5 :
		rm = number % 100 ;
		if ( rm != 0 )
		{
		getWordForNumber ( " " ) ;
		getWordForNumber ( CURRENCY_DENOMINATION_IN_WORDS[3] ) ;
		getWordForNumber ( " " ) ;
		passNumber ( rm ) ;
		}
		number /= 100 ;
		break ;
		
		}
		cc++ ;
		}
		
		return PAYMENT_AMOUNT_IN_WORDS;
}

			

public static void passNumber(int number)
{
		int rm, q ;
		if ( number < 10 )
		{
			getWordForNumber ( NUMBERS_1TO9_IN_WORDS[number] ) ;
		}
		
		if ( number > 9 && number < 20 )
		{
			getWordForNumber ( TEENS_IN_WORDS[number-10] ) ;
		}
		
		if ( number > 19 )
		{
			rm = number % 10 ;
			if ( rm == 0 )
			{
				q = number / 10 ;
				getWordForNumber ( TENS_IN_WORDS[q-2] ) ;
			}
			else
			{
				q = number / 10 ;
				getWordForNumber ( NUMBERS_1TO9_IN_WORDS[rm] ) ;
				getWordForNumber ( " " ) ;
				getWordForNumber ( TENS_IN_WORDS[q-2] ) ;
			}
		}
}

public static void getWordForNumber(String s)
{
	String t ; 
	t= PAYMENT_AMOUNT_IN_WORDS ;
	PAYMENT_AMOUNT_IN_WORDS= s ;
	PAYMENT_AMOUNT_IN_WORDS+= t ;
}

}
