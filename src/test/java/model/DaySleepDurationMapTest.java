package model;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	
	@Test
	public void testWithData() throws IOException {
		// Import test data and assert that everything looks good
		final String TEST_DATA_LOCATION = 
				"target/classes/testdata/map-test-data.csv";
		
		// Get CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(TEST_DATA_LOCATION)))){
			String line = "";

			while (((line = br.readLine()) != null)){
				// Convert the line from CSV to a SleepEntry
				SleepEntry se = SleepEntry.parseFromCSV(line);
				
				// Add data from that to the map
				DaySleepDurationMap.getInstance().addToDay(se.getEffectiveDate(), se.getDuration());

			}
			
			// Make sure everything looks good
			DaySleepDurationMap dsdm = DaySleepDurationMap.getInstance();
			assertEquals(7, dsdm.size());


		} catch (FileNotFoundException fnfe){
			fail("File not found, dawg!");
		}
		
	}

}
