package model;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author sean
 */
public final class DaySleepDurationMap extends TreeMap<SimpleDay,Double> {

	private static final long serialVersionUID = -4755148060348935227L;
	
	private static DaySleepDurationMap singleMap;
	
	private DaySleepDurationMap(){
		
	}
	
	public static DaySleepDurationMap getInstance(){
		if (singleMap == null){
			singleMap = new DaySleepDurationMap();
		}
		return singleMap;
	}
	
	/** Add sleep time to the current map.  Use this over {@link #put(SimpleDay, Double)}
	 * to avoid accidentally overwriting data
	 * @param day
	 * @param increment
	 */
	public void addToDay(SimpleDay day, double increment){
		// If the key doesn't exist, add it
		if (!getInstance().containsKey(day)){
			getInstance().put(day, increment);
		}
		else {
			getInstance().put(day, Double.sum(getInstance().get(day), increment));
		}
	}
	
	/** Returns the data as a JS callback.
	 * Data values are doubles that are formatted to hundreths (%.02f) precision.
	 * Derived from http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/
	 * @return
	 */
	@Deprecated
	public String toJSCallback(){
		StringBuilder sb = new StringBuilder();
		// TODO
		
		// First line to start the callback
		sb.append("callback(");

		// Add all of the data in the map
		sb.append(this.toJSONArray());
		
		// Add end flair
		sb.append(");");
		
		return sb.toString();
	}
	
	/** Returns the data as a JS callback.
	 * Data values are doubles that are formatted to hundreths (%.02f) precision.
	 * Derived from http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/
	 * @return
	 */
	public String toJSONArray(){
		StringBuilder sb = new StringBuilder();
		
		// First line to start the array
		sb.append("[");

		// Add all of the data in the map
		for (Map.Entry<SimpleDay, Double> entry : singleMap.entrySet()){
			SimpleDay day = entry.getKey();
			Double val = entry.getValue();
			
			sb.append(String.format("[%s,%.02f],", day.toJSDateUTC(), val));
		}
		
		// Remove final comma
		sb.delete(sb.length()-1, sb.length());
		
		// Add end flair
		sb.append("]");
		
		return sb.toString();
	}

}
