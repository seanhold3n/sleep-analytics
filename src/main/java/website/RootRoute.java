package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

import model.DaySleepDurationMap;
import model.SleepEntry;
import spark.Request;
import spark.Response;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;

public class RootRoute extends FreemarkerBasedRoute{

	public static final String TEST_DATA_LOCATION = 
//			"target/classes/testdata/sean-sleep-data.csv";
			"target/classes/testdata/map-test-data.csv";
	
	public RootRoute(Configuration cfg) throws IOException {
		super("/", "home_template.ftl", cfg);
	}
	
	@Override
	public void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
		
		// TODO ask user for data from webpage
		
		// Get CSV file
		BufferedReader br = new BufferedReader(new FileReader(new File(TEST_DATA_LOCATION)));
		String line = "";

		// Ignore the first line
		br.readLine();

		while (((line = br.readLine()) != null)){
			// Convert the line from CSV to SleepEntry
			SleepEntry entry = SleepEntry.parseFromCSV(line);
			
			// Add entry to map
			DaySleepDurationMap.getInstance().put(entry.getEffectiveDate(), entry.getDuration());

			System.out.println(line);

		}

		br.close();
		
		
		SimpleHash root = new SimpleHash();
		
		// Generate axes
		
		
		root.put("xAxisCategories", "['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']");
		root.put("hoursData", "[8, 7, 5, 4, 6, 7, 9]");


		template.process(root, writer);
	}
	
}
