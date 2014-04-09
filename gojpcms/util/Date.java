package gojpcms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date{
	private Calendar today, day;
	private SimpleDateFormat sdf;
	public static enum STATE {DAY, MINUTE, HOUR, YEAR, SECOND}; 
	public Date(long milliseconds){
		today = Calendar.getInstance();
		day = today;
		day.setTimeInMillis(milliseconds);
		sdf = new SimpleDateFormat("MMMM dd, yyyy"); // format the date
	}
	
	public Date(){
		today = Calendar.getInstance();
		day = today;
	}
	
	public void setFormat(String format){
		sdf = new SimpleDateFormat(format);
	}
	
	public String getDateFormat(){
		return sdf.format(day.getTime());
	}
	
	public Calendar getDate(){
		return day;
	}
	
	public int get(int field){
		return day.get(field);
	}
	
	public long getInMilliseconds(){
		return day.getTimeInMillis();
	}
	
	public long getStatingOfDay(){
		day.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return day.getTimeInMillis();
	}
	
	public boolean isToday(){
		return day.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH) && day.get(Calendar.MONTH) == today.get(Calendar.MONTH) && day.get(Calendar.YEAR) == today.get(Calendar.YEAR) ;
	}
	
	public void add(int field, int value){
		day.add(field, value);
	}
	
	public Calendar getAnother(int field, int value){
		Calendar oday = day;
		oday.add(field, value);
		return oday;
	}
	
	public static int difference(Date.STATE by, Date start_date,  Date end_date){
		long diff = end_date.getDate().getTimeInMillis() - start_date.getDate().getTimeInMillis();
		return considerDifference(by, diff);		
	}
	
	private static int considerDifference(Date.STATE by, long diff){
		switch(by){
		case DAY:
			return (int) diff/(1000*60*60*24);
		case HOUR:
			return (int) diff/(1000*60*60);
		case MINUTE:
			return (int) diff/(1000*60);
		case SECOND:
			return (int) diff/(1000);
		default:
			return 1;
		}
	}
	
	public Calendar getToday(){
		return today;
	}
	
}