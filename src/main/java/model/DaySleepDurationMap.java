package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sean
 */
public final class DaySleepDurationMap extends DayValuesMap {

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
		if (!containsKey(day)){
			put(day, increment);
		}
		else {
			put(day, Double.sum(get(day), increment));
		}
	}

	
	
	/** Get the simple moving averages for each day (that is, the unweighted mean of the previous nDays of data).
	 * @param nDays The number of days over which to compute the average
	 * @return A map of all day/SMA pairings
	 */
	public DayValuesMap getSimpleMovingAverage(final int nDays){
		// Create the map
		DayValuesMap smaMap = new DayValuesMap();

		double sma = 0;
		boolean firstSMA = true;
		
		List<Map.Entry<SimpleDay, Double>> smaActiveSet = new ArrayList<Map.Entry<SimpleDay, Double>>(nDays);
		
		for (Map.Entry<SimpleDay, Double> todayEntry : this.entrySet()){

			// Add the entry to the active set
			smaActiveSet.add(todayEntry);
			
			// If reached the first nDays (i.e. enough items have been added to the set), compute SMA
			if (smaActiveSet.size() >= nDays){
				if (firstSMA){
					// Set baseline SMA
					for (Map.Entry<SimpleDay, Double> activeEntry : smaActiveSet){
						sma += activeEntry.getValue();
					}
					sma /= nDays;
					firstSMA = false;
				}
				else{
					// Augment the SMA
					
					// Get the nth-back element (i.e. the first one in the list)
					Map.Entry<SimpleDay, Double> nthElementBack = smaActiveSet.get(0);
					
					// Get new SMA based on old one
					sma = sma + todayEntry.getValue()/nDays - nthElementBack.getValue()/nDays;
					
					// Remove the nth-back element
					smaActiveSet.remove(0);
					
				}
				smaMap.put(todayEntry.getKey(), sma);
			}
			
		}
		
		return smaMap;
		
	}

}
