package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.DaySleepDurationMap;
import model.SleepEntry;
import spark.Request;
import spark.Response;
import spark.Route;

public class MainDataRoute extends Route {

	public static final String TEST_DATA_LOCATION = RootRoute.class.getClass().getResource(
			"/data/sean-sleep-data.csv"
//			"/data/map-test-data.csv"
			).getPath();

	protected MainDataRoute() {
		super("/data.json");
	}

	@Override
	public Object handle(Request request, Response response) {
		// TODO ask user for data from webpage
		
		// Clear the map of any old data
		// TODO move this sort of stuff into the map class and have a populate method or the like (same as FYP project)
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
			
			br.close();

		} catch (IOException e){
			e.printStackTrace();
		}
		
		// Prepare the response body
		String responseStr;
		
		// Get the callback parameter
		String callbackParam = request.queryParams("callback");
		System.out.println("Callback: " + callbackParam);
		
		// Attempt to use callback param
		if (callbackParam != null){
			// Perform JSONP callback
			responseStr = callbackParam + "(" + DaySleepDurationMap.getInstance().toJSONArray() + ")";
		}
		else {
			// Return as plain ol' JSON document
			responseStr = DaySleepDurationMap.getInstance().toJSONArray();
		}
		

		response.type("text/javascript");
		return responseStr;
	}

}
