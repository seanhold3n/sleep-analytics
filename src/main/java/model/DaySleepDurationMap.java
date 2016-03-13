package model;

import java.util.HashMap;

public final class DaySleepDurationMap extends HashMap<SimpleDay,Integer> {

	private static final long serialVersionUID = -4755148060348935227L;
	
	private static DaySleepDurationMap singleMap;
	
	private DaySleepDurationMap(){}
	
	public static DaySleepDurationMap getInstance(){
		if (singleMap == null){
			singleMap = new DaySleepDurationMap();
		}
		return singleMap;
	}
	
	/** Add sleep time to the current map
	 * @param day
	 * @param increment
	 */
	public void addToDay(SimpleDay day, int increment){
		
	}

}
