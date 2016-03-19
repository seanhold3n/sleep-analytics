package website;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.setPort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
		
		// data - /data.json
		get(new MainDataRoute());

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
