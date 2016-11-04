package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DayValuesMap extends TreeMap<SimpleDay, Double> {

	private static final long serialVersionUID = 6014403244969632728L;
	
	/** Get the moving standard deviations for each day.
	 * Big thanks to the following site for a good formula: http://jonisalonen.com/2014/efficient-and-accurate-rolling-standard-deviation/
	 * Note: this method uses the formula for a population, not sample.  To make this for a sample, variance calculations should use nDays-1 instead of nDays.
	 * @param nDays The number of days over which to compute the standard deviation
	 * @return A map of all day/stddev pairings
	 */
	public DayValuesMap getMovingStandardDeviation(final int nDays){
		// Create the map
		DayValuesMap sdMap = new DayValuesMap();

		boolean firstSD = true;

		// for SD computation
		double average = 0;
		double variance = 0;
		double stddev = 0;
		
		List<Map.Entry<SimpleDay, Double>> sdActiveSet = new ArrayList<Map.Entry<SimpleDay, Double>>(nDays);

		for (Map.Entry<SimpleDay, Double> todayEntry : this.entrySet()){

			sdActiveSet.add(todayEntry);
				
			// If there are enough items in the set, compute SD
			if (sdActiveSet.size() >= nDays){
				if (firstSD){
					// init
					
					// Compute average
					for (Map.Entry<SimpleDay, Double> activeEntry : sdActiveSet){
						average += activeEntry.getValue();
					}
					average /= nDays;
					
					// Do variance things
					for (Map.Entry<SimpleDay, Double> activeEntry : sdActiveSet){
						variance += Math.pow(activeEntry.getValue() - average, 2);
					}
					variance /= nDays;
					
					// Sqrt to get stddev
					stddev = Math.sqrt(variance);
					
					firstSD = false;
				}
				else{
					// step

					// Get the nth-back element (i.e. the first one in the list)
					double oldVal = sdActiveSet.get(0).getValue();
					
					// Get the latest value
					double newVal = todayEntry.getValue();
					
					// Compute updated SD 
					double oldAvg = average;
					average = oldAvg + (newVal - oldVal)/nDays;
					variance += (newVal - oldVal)*(newVal - average + oldVal - oldAvg)/(nDays);
					stddev = Math.sqrt(variance);

					// Remove the nth-back element and load the new value
					sdActiveSet.remove(0);

				}
				sdMap.put(todayEntry.getKey(), stddev);
			}

		}

		return sdMap;
	}
	
	/** Returns the data as a JSON array.  Dates are represented in Javascript Date.UTC format using the method {@link SimpleDay#toJSDateUTC()}.
	 * Data values are doubles that are formatted to hundredths (%.02f) precision.
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
