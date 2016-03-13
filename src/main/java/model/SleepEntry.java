package model;

import java.util.Calendar;

public class SleepEntry implements Comparable<SleepEntry>{
	
	
	public static SleepEntry parseFromCSV(String csvStr){
		
		// Raw CSV values
		String dateWakeStr, timeSleepStr, timeWakeStr, durStr;
		// Stuff to load into a new SleepEntry object
		Calendar timeIn, timeOut;
		double dur;
		
		// Parse the string around commas
		String[] csvVals = csvStr.split(",");
		
//		 Load raw values into individual strings
		dateWakeStr = csvVals[0];
		timeSleepStr = csvVals[1];
		timeWakeStr = csvVals[2];
		durStr = csvVals[3];
		
		// Parse info
		// TODO I know there are better ways to do this (date string formatters and such),
		// but this is a hackathon!
		
		
		// Time general
		int year, month, day, hour, min;
		
		// Date wake
		String[] dayVals = dateWakeStr.split("/");
		month = Integer.parseInt(dayVals[0]);
		day = Integer.parseInt(dayVals[1]);
		year = Integer.parseInt(dayVals[2]);
		
		// Time sleep
		String[] timeSleepVals = timeSleepStr.split(":");
		hour = Integer.parseInt(timeSleepVals[0]);
		min = Integer.parseInt(timeSleepVals[1]);
		// Create Calendar object for timeIn
		timeIn = Calendar.getInstance();
		timeIn.set(2000+year, month-1, day, hour, min, 0);
		// 2000+year to convert two-digit (i.e. 16) to pwoper years (i.e. 2016)
		// Month-1 b/c Calendar months are zero-based
		
		
		// Time wake
		// TODO copy/pasted code, I know, can make this a method...
		// but again, hackathon code! :)
		String[] timeWakeVals = timeWakeStr.split(":");
		hour = Integer.parseInt(timeWakeVals[0]);
		min = Integer.parseInt(timeWakeVals[1]);
		// Create Calendar object for timeOut
		timeOut = Calendar.getInstance();
		timeOut.set(year, month-1, day, hour, min, 0);
		
		/* Adjust the timeIn if needed.  SleepBot only stores the date at wake time in 
		 * the csv, so if the sleep time occurred a day earlier, it will need to be rolled
		 * back.  Most normal entries will need this (e.g. go to sleep at 10pm, wake at 6am 
		 * the next day - sleep day will need to be one day prior. This assumes that no entry 
		 * is longer than 24 hours. */
		if (timeIn.after(timeOut)){
			timeIn.add(Calendar.DAY_OF_MONTH, -1);
			// TODO if this is the first of the month, will it roll everything else back accordingly?
			// Unit tests will find out!
		}

		
//		Calendar.getInstance().
		dur = Double.parseDouble(durStr);
		
		return new SleepEntry(timeIn, timeOut, dur);
	}
	
	
	public SleepEntry(Calendar timeIn, Calendar timeOut, double duration) {
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.duration = duration;
	}


	private Calendar timeIn;

	private Calendar timeOut;

	private double duration;

	/**
	 * Returns a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than the specified object.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(SleepEntry o) {
		return this.timeIn.compareTo(o.getTimeIn());
	}
	public double getDuration() {
		return duration;
	}
	
	
	/**
	 * @return The date toward which clocked-in hours will count
	 */
	public Calendar getEffectiveDate(){
		return getTimeOut();
	}
	
	public Calendar getTimeIn() {
		return timeIn;
	}

	public Calendar getTimeOut() {
		return timeOut;
	}
	
	public boolean isZeroDuration(){
		return duration < 0.05;
	}

}
