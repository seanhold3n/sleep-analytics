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
import model.SimpleDay;
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
		
		Set<DailyEntry> days = new HashSet<DailyEntry>();

		// Establish first line
		SleepEntry entry = SleepEntry.parseFromCSV(br.readLine());
		SimpleDay today = entry.getEffectiveDate();
		double duration = entry.getDuration();
		
		while (((line = br.readLine()) != null)){
			// Convert the line from CSV to SleepEntry
			entry = SleepEntry.parseFromCSV(line);
			
			// If new day
			if (!today.equals(entry.getEffectiveDate())){
				// Save
				days.add(new DailyEntry(today, duration));
				
				// Restart
				today = entry.getEffectiveDate();
				duration = entry.getDuration();
			}
			else{
				// Accumulate
				duration += entry.getDuration();
			}
			
			// Add entry to map
//			DaySleepDurationMap.getInstance().put(entry.getEffectiveDate(), entry.getDuration());
			
//			
//			if (!days.contains(today)){
//				days.add(new DailyEntry(entry.getEffectiveDate()));
//			}

		}

		br.close();
		
		
		SimpleHash root = new SimpleHash();
		
		// Generate axes
//		DaySleepDurationMap dsdm = DaySleepDurationMap.getInstance();
//		System.out.println(dsdm.keySet());
		
		List<DailyEntry> entries = new ArrayList<>();
		entries.addAll(days);
		entries.sort(null);
		
		String[] xAxis = new String[entries.size()];
		double[] yAxis = new double[entries.size()];

		for (int i = 0; i < yAxis.length; i++) {
			xAxis[i] = String.format("'%s'", entries.get(i).getDay().toString());
			yAxis[i] = entries.get(i).getDuration();
		}
		
		System.out.println(Arrays.toString(xAxis));
		System.out.println(Arrays.toString(yAxis));
		
//		root.put("xAxisCategories", "['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']");
//		root.put("hoursData", "[8, 7, 5, 4, 6, 7, 9]");
		root.put("xAxisCategories", Arrays.toString(xAxis));
		root.put("hoursData", Arrays.toString(yAxis));

		template.process(root, writer);
	}
	
}
