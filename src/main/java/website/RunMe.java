package website;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.setPort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DaySleepDurationMap;
import model.SleepEntry;
import freemarker.template.Configuration;

public class RunMe {

	private final Configuration cfg;

	public static final String DATA_LOCATION = RootRoute.class.getClass().getResource(
			"/data/sean-sleep-data.csv"
//			"/data/map-test-data.csv"
			).getPath();

	public static void main(String[] args) throws IOException {
		new RunMe();
	}

	/** Starts a web server on <a href="http://localhost:8081">http://localhost:8081</a> with the sleep analytics interface.
	 * @throws IOException
	 */
	public RunMe() throws IOException {

		// Load data
		loadDataMap();
		
		// Start server
		cfg = createFreemarkerConfiguration();
		setPort(8081);
		initializeRoutes();
	}

	private Configuration createFreemarkerConfiguration() {
		Configuration retVal = new Configuration();
		retVal.setClassForTemplateLoading(RunMe.class, "/freemarker");
		return retVal;
	}

	private void initializeRoutes() throws IOException {
		
		
		staticFileLocation("/"); // Static files
				
		// this is the home page
		get(new RootRoute(cfg));
		
		get(new AboutRoute(cfg));
		
		// Data routes
		get(new DailyHoursDataRoute());	// /data.json
		get(new SMADataRoute());	// /sma.json
		get(new StddevDataRoute());	// /stddev.json

	}
	
	private void loadDataMap() throws IOException {
		// Clear the map of any old data
		// TODO move this sort of stuff into the map class and have a populate method or the like (same as FYP project)
		DaySleepDurationMap.getInstance().clear();

		// List of entries
		List<SleepEntry> entries = new ArrayList<SleepEntry>();
		
		// Get CSV file
		BufferedReader br = new BufferedReader(new FileReader(new File(DATA_LOCATION)));
		String line = "";

		// Ignore the first line (CSV header)
		br.readLine();

		while (((line = br.readLine()) != null)){
			// Convert the line from CSV to a SleepEntry
			SleepEntry se = SleepEntry.parseFromCSV(line);
			// Add it to the entry list
			entries.add(se);
		}
		
		for (SleepEntry se : entries){
			// Add data from list to the map
			DaySleepDurationMap.getInstance().addToDay(se.getEffectiveDate(), se.getDuration());
		}
		

		br.close();
		
	}
	
}
