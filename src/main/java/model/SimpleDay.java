package model;

public class SimpleDay { //implements Comparable<SimpleDay> {
	
	private final int YEAR;
	private final int MONTH;
	/** Day of the month */
	private final int DAY;
	
	
	public SimpleDay(int year, int month, int day) {
		super();
		YEAR = year;
		MONTH = month;
		DAY = day;
	}


	public int getYear() {
		return YEAR;
	}


	public int getMonth() {
		return MONTH;
	}


	public int getDay() {
		return DAY;
	}
	
	
//	@Override
//	public int compareTo(SimpleDay o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SimpleDay){
			SimpleDay sdObj = (SimpleDay) obj;
			return (this.YEAR == sdObj.YEAR &&
					this.MONTH == sdObj.MONTH &&
					this.DAY == sdObj.DAY);
		}
		else {
			return false;
		}
	}


	

}
