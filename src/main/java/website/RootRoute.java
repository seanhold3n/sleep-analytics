package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

import spark.Request;
import spark.Response;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;

public class RootRoute extends FreemarkerBasedRoute{

	public static final String TEST_DATA_LOCATION = 
			"target/classes/testdata/sean-sleep-data.csv";
	
	public RootRoute(Configuration cfg) throws IOException {
		super("/", "home_template.ftl", cfg);
	}
	
	@Override
	public void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
		
		// TODO ask user for data from webpage
		// Get CSV file
//		try (BufferedReader br = new BufferedReader(new FileReader(new File(TEST_DATA_LOCATION)))){
//			String line = "";
//			
//			// Ignore the first line
//			br.readLine();
//			
//			// Counter for current line
//			int curLine = 0;
//			// Number of lines down to read
//			int maxLine = 21;
//			
//			while (((line = br.readLine()) != null) && curLine <= maxLine){
//				// Convert the line to CSV
//				
//				// Store it in a list
//				
//				System.out.println(line);
//				
//				curLine++;
//			}
//			
//			
//		} catch (FileNotFoundException fnfe){
//			System.err.println("File not found, dawg!");
//		}
		
		SimpleHash root = new SimpleHash();


		template.process(root, writer);
	}
	
}
