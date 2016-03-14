package model;

/**
 * @author Sean Holden (holdens@my.erau.edu)
 * @deprecated DaySleepDurationMap + SimpleDay will do
 *
 */
@Deprecated
public class DailyEntry implements Comparable<DailyEntry>{
	
	private final SimpleDay DAY;
	
	private double duration;
	
	public DailyEntry(SimpleDay day){
		this(day, 0);
	}
	
	public DailyEntry(SimpleDay day, double duration){
		this.DAY = day;
		this.duration = duration;
	}

	public void addToDuration(double duration) {
		this.duration += duration;
	}
	
	public SimpleDay getDay() {
		return DAY;
	}

	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public boolean equals(Object obj) {
		return DAY.equals(obj);
	};
	
	@Override
	public int hashCode() {
		return DAY.hashCode();
	}

	public int compareTo(DailyEntry o) {
		return this.hashCode() - o.hashCode();
	}

}
