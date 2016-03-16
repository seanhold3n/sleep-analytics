package website;

import spark.Request;
import spark.Response;
import spark.Route;

public class MainDataRoute extends Route {

	protected MainDataRoute() {
		super("data.json");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object handle(Request request, Response response) {
		// TODO Auto-generated method stub
		
		
		response.type("application/json");
		return null;
	}

}
