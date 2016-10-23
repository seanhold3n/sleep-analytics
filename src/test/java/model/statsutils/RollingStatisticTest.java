package model.statsutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RollingStatisticTest {
	
	public static final double DELTA = 0.01;

	@Test
	/** Test creation and basic methods */
	public void testRollingStatistic() {
		// Base statistics for [5 2 8 4 9 1]
		RollingStatistic st = new RollingStatistic(6, 4.8333, 10.167);
		assertEquals(3.1885, st.getStddev(), DELTA);
		
		// Test step - replace 5 with 3
		st.step(5, 3);
		assertEquals(4.500, st.getAverage(), DELTA);
		assertEquals(10.700, st.getVariance(), DELTA);
		assertEquals(3.2711, st.getStddev(), DELTA);
		
	}

}
