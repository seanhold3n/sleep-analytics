package model;

public class DailyEntry {
	
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

}
