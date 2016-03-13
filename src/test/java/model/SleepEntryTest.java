package model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class SleepEntryTest {

	/** Asserts that two Calendars are equal according to what I care about (i.e. year,
	 * month, date, hour, minute)
	 * @param expected
	 * @param actual
	 */
	public static void assertCalendarEquals(Calendar expected, Calendar actual){
		assertEquals(expected.get(Calendar.YEAR), actual.get(Calendar.YEAR));
		assertEquals(expected.get(Calendar.MONTH), actual.get(Calendar.MONTH));
		assertEquals(expected.get(Calendar.DAY_OF_MONTH), actual.get(Calendar.DAY_OF_MONTH));
		assertEquals(expected.get(Calendar.HOUR), actual.get(Calendar.HOUR));
		assertEquals(expected.get(Calendar.MINUTE), actual.get(Calendar.MINUTE));
	}
	
	/**
	 * Standard CSV string - same day
	 */
	@Test
	public void testParseFromCSVSameDay() {
		String csvStr = "01/09/16,18:25,20:34,2.14,";
		
		SleepEntry entry = SleepEntry.parseFromCSV(csvStr);
		
		// Create expected values
		Calendar timeSleep = Calendar.getInstance();
		timeSleep.set(2016, Calendar.JANUARY, 8, 18, 25); // 8, because day is zero-based
		Calendar timeWake = Calendar.getInstance();
		timeWake.set(2016, Calendar.JANUARY, 8, 20, 34);
		double duration = 2.14;
		
		// Test against actual
//		assertEquals(timeSleep, entry.getTimeIn());
//		assertEquals(timeWake, entry.getTimeOut());
		assertCalendarEquals(timeSleep, entry.getTimeSleep());
		assertEquals(duration, entry.getDuration(), 0.01);
		
	}
	
	/**
	 * Standard CSV string - same day
	 */
	@Test
	public void testParseFromCSVDayDiff() {
		String csvStr = "12/05/15,21:00,00:40,3.66,";
		
		SleepEntry entry = SleepEntry.parseFromCSV(csvStr);
		
		// Create expected values
		Calendar timeSleep = Calendar.getInstance();
		timeSleep.set(2015, Calendar.DECEMBER, 3, 21, 00); // 3, because day is zero-based
		Calendar timeWake = Calendar.getInstance();
		timeWake.set(2015, Calendar.DECEMBER, 4, 00, 40);
		double duration = 3.66;
		
		// Test against actual
//		assertEquals(timeSleep, entry.getTimeIn());
//		assertEquals(timeWake, entry.getTimeOut());
		assertCalendarEquals(timeSleep, entry.getTimeSleep());
		assertEquals(duration, entry.getDuration(), 0.01);
		
	}

	@Test
	public void testSleepEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDuration() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEffectiveDate() {
		// Create test values
		Calendar timeSleep = Calendar.getInstance();
		timeSleep.set(2015, Calendar.DECEMBER, 3, 21, 00); // 3, because day is zero-based
		Calendar timeWake = Calendar.getInstance();
		timeWake.set(2015, Calendar.DECEMBER, 4, 00, 40);
		SleepEntry entry = new SleepEntry(timeIn, timeOut, 0.0);
	}

	@Test
	public void testGetTimeSleep() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTimeWake() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsZeroDuration() {
		fail("Not yet implemented");
	}

}
