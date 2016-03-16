package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.DailyEntry;
import model.DaySleepDurationMap;
import model.SimpleDay;
import model.SleepEntry;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;

public class MainDataRoute extends Route {

	public static final String TEST_DATA_LOCATION = RootRoute.class.getClass().getResource(
//			"/data/sean-sleep-data.csv"
			"/data/map-test-data.csv"
			).getPath();

	protected MainDataRoute() {
		super("/data.json");
	}

	@Override
	public Object handle(Request request, Response response) {
		// TODO ask user for data from webpage

		// Get CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(TEST_DATA_LOCATION)))){
			String line = "";

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

		response.type("text/javascript");
		return DaySleepDurationMap.getInstance().toJSCallback();
	}

}
