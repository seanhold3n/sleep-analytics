package website;

import model.DaySleepDurationMap;
import spark.Request;
import spark.Response;
import spark.Route;

/** Data route that returns a JSON document of days and the corresponding number of hours of sleep on each day.
 * @author Sean Holden
 *
 */
public class DailyHoursDataRoute extends Route {

	protected DailyHoursDataRoute() {
		super("/data.json");
	}

	@Override
	public Object handle(Request request, Response response) {
		// TODO ask user for data from webpage
		
		// Note: Sleep data (DataSleepDurationMap) is loaded on server start-up
		
		// Prepare the response body
		String responseStr;
		
		// Get the callback parameter
		String callbackParam = request.queryParams("callback");
		// Special thanks to http://stackoverflow.com/a/14621917 for helping me figure out the callback code
		
		// Attempt to use callback param
		if (callbackParam != null){
			// Perform JSONP callback
			responseStr = callbackParam + "(" + DaySleepDurationMap.getInstance().toJSONArray() + ")";
		}
		else {
			// Return as plain ol' JSON document
			responseStr = DaySleepDurationMap.getInstance().toJSONArray();
		}
		

		response.type("text/javascript");
		return responseStr;
	}

}
