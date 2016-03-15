package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

import spark.Request;
import spark.Response;
import spark.Route;

public class RootCSSRoute extends Route {

	protected RootCSSRoute() {
		super("/home_style.css");
	}


	@Override
	public Object handle(Request request, Response response) {
		StringWriter writer = new StringWriter();

		// Read from the CSS file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"src/main/resources/css/home_style.css")))){

			
			String line = "";
			while ((line = br.readLine()) != null){
				writer.write(line + System.lineSeparator());
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		response.type("text/css");
		
		return writer;
	}

}
