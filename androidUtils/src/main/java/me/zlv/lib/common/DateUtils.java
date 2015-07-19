package me.zlv.lib.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	
	private static final Date today = new Date();
	private static final Calendar todayCal = Calendar.getInstance();
	private static final int thisYear = todayCal.get(Calendar.YEAR);
	private static final int thisMonth = todayCal.get(Calendar.MONTH);
	private static final int thisDayOfMonth = todayCal.get(Calendar.DAY_OF_MONTH);
	
	public static final String format_yyyy_MM_dd__HH_mm = "yyyy-MM-dd HH:mm";
	public static final String format_yyyy_MM_dd = "yyyy-MM-dd";
	
	public static String format(Date date,String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern,Locale.CHINA);
		return format.format(date);
	}
	
	/**
	 * 获取当天的最早时刻
	 * @param date
	 * @return
	 */
	public static Date getBeginOfTheDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND,0);
		return cal.getTime();
	}
	
	public static Date getBeginOfTomorrow(){
		Date tomorrow = addDay(today, 1);
		return getBeginOfTheDate(tomorrow);
	}
	
	public static Date getBeginOfAfterTomorrow(){
		Date afterTmr = addDay(today, 2);
		return getBeginOfTheDate(afterTmr);
	}
	
	public static Date getEndOfToday(){
		return getEndOfTheDate(today);
	}
	
	public static Date getEndOfDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.YEAR, 9999);
		return calendar.getTime();
	}
	
	/**
	 * 获取当天的最晚时刻
	 * @param date
	 * @return
	 */
	public static Date getEndOfTheDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND,59);
		return cal.getTime();
	}
	
	public static Date getEndOfTmr(){
		Date tomorrow = addDay(today, 1);
		return getEndOfTheDate(tomorrow);
	}
	
	public static Date getEndOfAfterTmr(){
		Date afterTmr = addDay(today, 2);
		return getEndOfTheDate(afterTmr);
	}
	
	public static Date addMinute(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, n);
		return cal.getTime();
	}
	public static Date addHour(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, n);
		return cal.getTime();
	}
	public static Date addDay(Date date, int n){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}
	
	public static boolean isToday(final Date date){
		return isTheSameDay(today, date);
	}
	
	public static boolean isTomorrow(final Date date){
		return isTmrOfTheDate(today, date);
	}
	
	public static boolean isAfterTmr(final Date date){
		return isAfterTmrOfTheDate(today, date);
	}
	
	public static boolean isTheSameDay(final Date theDate,final Date checkDate){
		Calendar theCal = Calendar.getInstance();
		theCal.setTime(theDate);

		Calendar checkCal = Calendar.getInstance();
		checkCal.setTime(checkDate);
		
		if (theCal.get(Calendar.YEAR) != checkCal.get(Calendar.YEAR)) {
			return false;
		}
		
		if (theCal.get(Calendar.MONTH) != checkCal.get(Calendar.MONTH)) {
			return false;
		}
		
		if (theCal.get(Calendar.DAY_OF_MONTH) != checkCal.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isTmrOfTheDate(final Date theDate,final Date checkDate){
		Calendar theCal = Calendar.getInstance();
		theCal.setTime(theDate);

		Calendar checkCal = Calendar.getInstance();
		checkCal.setTime(checkDate);
		
		if (theCal.get(Calendar.YEAR) != checkCal.get(Calendar.YEAR)) {
			return false;
		}
		
		if (theCal.get(Calendar.MONTH) != checkCal.get(Calendar.MONTH)) {
			return false;
		}
		
		int days = checkCal.get(Calendar.DAY_OF_MONTH) - theCal.get(Calendar.DAY_OF_MONTH); 
		if (days != 1) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isAfterTmrOfTheDate(final Date theDate,final Date checkDate){
		Calendar theCal = Calendar.getInstance();
		theCal.setTime(theDate);

		Calendar checkCal = Calendar.getInstance();
		checkCal.setTime(checkDate);
		
		if (theCal.get(Calendar.YEAR) != checkCal.get(Calendar.YEAR)) {
			return false;
		}
		
		if (theCal.get(Calendar.MONTH) != checkCal.get(Calendar.MONTH)) {
			return false;
		}
		
		int days = checkCal.get(Calendar.DAY_OF_MONTH) - theCal.get(Calendar.DAY_OF_MONTH); 
		if (days != 2) {
			return false;
		}
		
		return true;
	}
}
