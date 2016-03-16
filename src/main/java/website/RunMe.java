package website;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.setPort;

import java.io.IOException;

import freemarker.template.Configuration;

public class RunMe {

	private final Configuration cfg;


	public static void main(String[] args) throws IOException {
		new RunMe();
	}

	public RunMe() throws IOException {

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
	
}
