package model;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/** Tests the data representation methods in DayValuesMap.
 * @author Sean Holden (holdens@my.erau.edu)
 */
public class DayValuesMapTest {

	/** The map to test */
	private DayValuesMap testMap;

	// Max allowed delta for double precision operations
	private final double DELTA = 0.01;
	
	/** Loads the map with arbitrary values for testing.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testMap = new DayValuesMap();
		testMap.put(new SimpleDay(2016, 03, 01), 8.0);
		testMap.put(new SimpleDay(2016, 03, 02), 6.5);
		testMap.put(new SimpleDay(2016, 03, 03), 10.3);
		testMap.put(new SimpleDay(2016, 03, 04), 7.35);
		testMap.put(new SimpleDay(2016, 03, 05), 9.43);
	}
	
	@Test
	public void testGetMovingStandardDeviations(){
		// Load expected results for a 4-day moving SD
		DayValuesMap expectedSDs = new DayValuesMap();
		
		// Note: calculations are as population, not sample
		expectedSDs.put(new SimpleDay(2016, 03, 04), 1.4104);
		expectedSDs.put(new SimpleDay(2016, 03, 05), 1.53161);
		
		// Get actual values
		DayValuesMap actualSDs = testMap.getMovingStandardDeviation(4);
		
		System.out.println("DayValuesMapTest - expected SDs : " + expectedSDs.toJSONArray());
		System.out.println("DayValuesMapTest - actual SDs	: " + actualSDs.toJSONArray());
		
		for (Map.Entry<SimpleDay, Double> e : expectedSDs.entrySet()){
			// Get the expected sma
			double actualVal = actualSDs.get(e.getKey());

			// Compare against actual SMA
			assertEquals(e.getValue(), actualVal, DELTA);
			
		}
		
	}

	@Test
	public void testToJSONArray() {
		/** The expected JSON string.  Note that all numbers are to %.02f precision and that March is represented using 2 (zero-based). */
		final String JSON_EXPECTED = 
				"[[Date.UTC(2016,2,1),8.00],"
				+ "[Date.UTC(2016,2,2),6.50],"
				+ "[Date.UTC(2016,2,3),10.30],"
				+ "[Date.UTC(2016,2,4),7.35],"
				+ "[Date.UTC(2016,2,5),9.43]]";
		assertEquals(JSON_EXPECTED, testMap.toJSONArray());
	}

}
