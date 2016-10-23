package model.statsutils;

/** Basically a Java version of http://jonisalonen.com/2014/efficient-and-accurate-rolling-standard-deviation/
 * @author Sean Holden (holdens@my.erau.edu)
 */
public class RollingStatistic {
	
	private final int WINDOW_SIZE;
	private double average;
	private double variance;
	private double stddev;
	
	/** Initializes for rolling average, variance, stddev */
	public RollingStatistic(int windowSize, double average, double variance){
		this.WINDOW_SIZE = windowSize;
		this.average = average;
		this.variance = variance;
		this.stddev = Math.sqrt(variance);
	}

	
	/** @return the average */
	public double getAverage() {
		return average;
	}


	/** @return the variance */
	public double getVariance() {
		return variance;
	}


	/** @return the stddev */
	public double getStddev() {
		return stddev;
	}


	public void step(double oldVal, double newVal){
		double oldAvg = this.average;
		this.average = oldAvg + (newVal - oldVal)/WINDOW_SIZE;
		this.variance += (newVal - oldVal)*(newVal - average + oldVal - oldAvg)/(WINDOW_SIZE - 1);
		this.stddev = Math.sqrt(variance);
	}

}
