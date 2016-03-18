package model;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class DaySleepDurationMapTest {
	

	final String TEST_DATA_LOCATION = getClass().getResource("/data/map-test-data.csv").getPath();
	
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
	
	
	/** Performs comprehensive data validation with the test set.  This test includes validation of {@link DaySleepDurationMap#toJSCallback()}.
	 * @throws IOException
	 */
	@Test
	public void testWithData() throws IOException {
		
		// Max allowed delta for double precision
		final double DELTA = 0.01;
		
		// Empty map
		DaySleepDurationMap.getInstance().clear();
		
		// Get CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(TEST_DATA_LOCATION)))){
			String line = "";

			// Ignore the first line (CSV header)
			br.readLine();
			
			while (((line = br.readLine()) != null)){
				// Convert the line from CSV to a SleepEntry
				SleepEntry se = SleepEntry.parseFromCSV(line);
				
//				System.out.println(se.getEffectiveDate());
//				System.out.println(se.getEffectiveDate().hashCode());
				
				// Add data from that to the map
				DaySleepDurationMap.getInstance().addToDay(se.getEffectiveDate(), se.getDuration());

			}
			
			// Make sure the data looks good
			DaySleepDurationMap dsdm = DaySleepDurationMap.getInstance();
			assertEquals(7, dsdm.size());
			assertEquals(4.68, dsdm.get(new SimpleDay(2015, 12, 25)), DELTA);
			assertEquals(13.08, dsdm.get(new SimpleDay(2015, 12, 26)), DELTA);
			assertEquals(5.73, dsdm.get(new SimpleDay(2015, 12, 27)), DELTA);
			assertEquals(12.0, dsdm.get(new SimpleDay(2015, 12, 28)), DELTA);
			assertEquals(6.50, dsdm.get(new SimpleDay(2015, 12, 29)), DELTA);
			assertEquals(6.67, dsdm.get(new SimpleDay(2015, 12, 30)), DELTA);
			assertEquals(14.04, dsdm.get(new SimpleDay(2015, 12, 31)), DELTA);


		} catch (FileNotFoundException fnfe){
			fail("File not found, dawg!");
		}
		
	}

}
