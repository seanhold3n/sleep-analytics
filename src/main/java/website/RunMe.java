package website;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.setPort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import org.apache.commons.lang3.StringEscapeUtils;

import spark.Request;
import spark.Response;
import spark.Route;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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
		// this is the home page
		get(new RootRoute(cfg));
		
		get(new AboutRoute(cfg));
		
		// static resources
		get(new CSSRoute("/home_style.css"));
		get(new CSSRoute("/about_style.css"));

	
	}
	
}
