package website;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;

import spark.Request;
import spark.Response;
import spark.Route;

public class CSSRoute extends Route {

	private String filename;
	
	protected CSSRoute(String file) {
		super(file);
		this.filename = file;
	}


	@Override
	public Object handle(Request request, Response response) {
		StringWriter writer = new StringWriter();

		// Read from the CSS file
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				getClass().getResource("/css" + filename).toURI())))){

			
			String line = "";
			while ((line = br.readLine()) != null){
				writer.write(line + System.lineSeparator());
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		response.type("text/css");
		
		return writer;
	}

}
