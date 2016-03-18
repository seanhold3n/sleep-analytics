package model;

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
		if (!getInstance().containsKey(day)){
			getInstance().put(day, increment);
		}
		else {
			getInstance().put(day, Double.sum(getInstance().get(day), increment));
		}
	}


}
