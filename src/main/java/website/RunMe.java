package website;

import static spark.Spark.get;
//import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.setPort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.DaySleepDurationMap;
import model.SleepEntry;

public class RunMe {

	public static final String DATA_LOCATION = RunMe.class.getClass().getResource(
			"/data/sean-sleep-data.csv"
//			"/data/map-test-data.csv"
			).getPath();

	public static void main(String[] args) throws IOException {
		new RunMe();
	}

	public RunMe() throws IOException {

		// Load data
		loadDataMap();
		
		// Start server
		setPort(8081);
		initializeRoutes();
	}

	private void initializeRoutes() throws IOException {
		
		staticFileLocation("/"); // Static files
		
		// Data routes
		get(new MainDataRoute());	// /data.json
		get(new SMADataRoute());	// /sma.json

	}
	
	private void loadDataMap() throws IOException {
		// Clear the map of any old data
		// TODO move this sort of stuff into the map class and have a populate method or the like (same as FYP project)
		DaySleepDurationMap.getInstance().clear();

		// Get CSV file
		BufferedReader br = new BufferedReader(new FileReader(new File(DATA_LOCATION)));
		String line = "";

		// Ignore the first line (CSV header)
		br.readLine();

		while (((line = br.readLine()) != null)){
			// Convert the line from CSV to a SleepEntry
			SleepEntry se = SleepEntry.parseFromCSV(line);

//			System.out.println(se.getEffectiveDate());
//			System.out.println(se.getEffectiveDate().hashCode());

			// Add data from that to the map
			DaySleepDurationMap.getInstance().addToDay(se.getEffectiveDate(), se.getDuration());

		}

		br.close();
		
	}
	
}
