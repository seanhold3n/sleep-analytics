package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleDayTest {

//	@Test
//	public void testSimpleDay() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetYear() {
		SimpleDay myDay = new SimpleDay(2016, 03, 13);
		assertEquals(2016, myDay.getYear());
	}

	@Test
	public void testGetMonth() {
		SimpleDay myDay = new SimpleDay(2016, 03, 13);
		assertEquals(03, myDay.getMonth());
	}

	@Test
	public void testGetDay() {
		SimpleDay myDay = new SimpleDay(2016, 03, 13);
		assertEquals(13, myDay.getDay());
	}

	@Test
	public void testEqualsObject() {
		SimpleDay sd1, sd2;
		sd1 = new SimpleDay(2016, 03, 13);

		// Equal
		sd2 = new SimpleDay(2016, 03, 13);
		assertEquals(sd1, sd2);

		// Not equal
		sd2 = new SimpleDay(2016, 03, 12);
		assertNotEquals(sd1, sd2);
		
	}
	
	@Test
	public void testHashCode() {
		SimpleDay sd1;
		sd1 = new SimpleDay(2016, 03, 13);
		assertEquals(20160313, sd1.hashCode());
	}
	
	@Test
	public void testToString(){
		SimpleDay myDay = new SimpleDay(2016, 03, 13);
		assertEquals("03/13/16", myDay.toString());
	}

}
