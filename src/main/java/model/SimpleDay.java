package model;

public class SimpleDay implements Comparable<SimpleDay> {
	
	/** Four-digit year */
	private final int YEAR;
	
	/* One-based month (e.g. 1 = January) */
	private final int MONTH;
	
	/** Day of the month */
	private final int DAY;
	
	
	/** Creates a new SimpleDay object.
	 * @param year The year (e.g. 2016)
	 * @param month The month as a one-based integer (e.g. 1 = January)
	 * @param day The day (e.g. 1 = 1st)
	 */
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
	
	
	public int compareTo(SimpleDay o) {
		return this.hashCode() - o.hashCode();
	}
	
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
	
	@Override
	public int hashCode() {
		return YEAR*10000 + MONTH*100 + DAY;
	};

	/** Returns the date as a string in "MM/DD/YY" format.  For example, March 12th 2016
	 * would be represented as "03/12/16".
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return String.format("%02d/%02d/%02d", MONTH, DAY, YEAR-2000); //TODO is -2000 needed w 2 digit truncation?
	}
	
	/** Returns the date as it would be represented by a Date.UTC() call in JavaScript.
	 * For example, March 12th 2016 would be represented as "Date.UTC(2016,2,12)".
	 * Note that the month is zero-based.
	 * @return
	 */
	public String toJSDateUTC(){
		return String.format("Date.UTC(%d,%d,%d)", YEAR, MONTH-1, DAY);
	}

	

}
