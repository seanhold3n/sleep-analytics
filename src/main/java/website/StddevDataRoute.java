package website;

import model.DaySleepDurationMap;
import model.DayValuesMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class StddevDataRoute extends Route {
	
	/** The default number of days for the SD if it isn't specified by a query parameter */
	private static final int DEFAULT_SD_NDAYS = 10;

	protected StddevDataRoute() {
		super("/stddev.json");
	}

	@Override
	public Object handle(Request request, Response response) {	
		
		// Prepare the response body
		String responseStr;
		
		// Get the number of days for the SD
		int nDays;
		String nDaysParam = request.queryParams("days");
		if (nDaysParam != null){
			nDays = Integer.parseInt(nDaysParam);
		}
		else{
			nDays = DEFAULT_SD_NDAYS;
		}
		
		// Get the SD map
		DayValuesMap sdMap = DaySleepDurationMap.getInstance().getMovingStandardDeviation(nDays);
		
		// Get the callback parameter
		String callbackParam = request.queryParams("callback");
		// Special thanks to http://stackoverflow.com/a/14621917 for helping me figure out the callback code
		
		// Attempt to use callback param
		if (callbackParam != null){
			// Perform JSONP callback
			responseStr = callbackParam + "(" + sdMap.toJSONArray() + ")";
		}
		else {
			// Return as plain ol' JSON document
			responseStr = sdMap.toJSONArray();
		}
		
		response.type("text/javascript");
		return responseStr;
	}

}
