package model;

import java.util.Map;
import java.util.TreeMap;

public class DayValuesMap extends TreeMap<SimpleDay, Double> {

	private static final long serialVersionUID = 6014403244969632728L;
	
	
	/** Returns the data as a JSON array.  Datse are represented in Javascript Date.UTC format using the method {@link SimpleDay#toJSDateUTC()}.
	 * Data values are doubles that are formatted to hundreths (%.02f) precision.
	 * Derived from http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/
	 * @return
	 */
	public String toJSONArray(){
		StringBuilder sb = new StringBuilder();
		
		// First line to start the array
		sb.append("[");

		// Add all of the data in the map
		for (Map.Entry<SimpleDay, Double> entry : this.entrySet()){
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
