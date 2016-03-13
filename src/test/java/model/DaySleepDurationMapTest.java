package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaySleepDurationMapTest {

	@Test
	public void testGetInstance() {
		// On very first run - should be empty
		DaySleepDurationMap dsdm = DaySleepDurationMap.getInstance();
		assertNotNull(dsdm);
		
		// TODO guarantee that this test runs first
//		assertTrue(dsdm.isEmpty());
		
		// TODO more testing maybe
	}

	@Test
	public void testAddToDay() {
		// Create an arbitrary day
		SimpleDay sd = new SimpleDay(2016, 03, 12);
		
		// Add an entry to the map
		DaySleepDurationMap dsdm = DaySleepDurationMap.getInstance();
		dsdm.addToDay(sd, 6.0);
		assertEquals(6.0, dsdm.get(sd), 0.05);
		
		dsdm.addToDay(sd, 3.0);
		assertEquals(9.0, dsdm.get(sd), 0.05);
	}

}
