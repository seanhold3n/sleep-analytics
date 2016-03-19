package website;

import model.DaySleepDurationMap;
import model.DayValuesMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class SMADataRoute extends Route {
	
	/** The default number of days for the SMA if it isn't specified by a query parameter */
	private static final int DEFAULT_SMA_NDAYS = 3;

	protected SMADataRoute() {
		super("/sma.json");
	}

	@Override
	public Object handle(Request request, Response response) {	
		
		// Prepare the response body
		String responseStr;
		
		// Get the number of days for the SMA
		int nDays;
		String nDaysParam = request.queryParams("days");
		if (nDaysParam != null){
			nDays = Integer.parseInt(nDaysParam);
		}
		else{
			nDays = DEFAULT_SMA_NDAYS;
		}
		
		// Get the SMA map
		DayValuesMap smaMap = DaySleepDurationMap.getInstance().getSimpleMovingAverage(nDays);
		
		// Get the callback parameter
		String callbackParam = request.queryParams("callback");
		// Special thanks to http://stackoverflow.com/a/14621917 for helping me figure out the callback code
		
		// Attempt to use callback param
		if (callbackParam != null){
			// Perform JSONP callback
			responseStr = callbackParam + "(" + smaMap.toJSONArray() + ")";
		}
		else {
			// Return as plain ol' JSON document
			responseStr = smaMap.toJSONArray();
		}
		
		response.type("text/javascript");
		return responseStr;
	}

}
