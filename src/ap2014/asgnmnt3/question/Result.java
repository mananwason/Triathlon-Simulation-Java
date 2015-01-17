/**
 * 
 */
package ap2014.asgnmnt3.question;

import java.text.DecimalFormat;

/**
 * @author manish
 *
 */
public class Result implements Comparable {

	/**
	 * 
	 */
	private static final DecimalFormat DF = new DecimalFormat("0000.000     ");
	public static final String HEADER_ROW = "Id           , "+
						"Name   ," +
						" Cycling Time ," +
						" Running Time ," +
						" Swimming Time," +
						" Total Time    ";
	private String resultString;
	private String id;
	private String name;
	private double cyclingTime;
	private double runningTime;
	private double swimmingTime;

	public Result(String id, String name) {
		this.id = id;
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		this.resultString = id +", " +
				name + ", " +
				DF.format(cyclingTime) + ", " +
				DF.format(runningTime) + ", " +
				DF.format(swimmingTime) + ", " +
				DF.format(getTotalTime());
		return resultString;
	}
	/**
	 * @return
	 */
	private double getTotalTime() {
		return cyclingTime + runningTime + swimmingTime;
	}

	/**
	 * @param cyclingTime the cyclingTime to set
	 */
	public void setCyclingTime(double cyclingTime) {
		this.cyclingTime = cyclingTime;
	}

	/**
	 * @param runningTime the runningTime to set
	 */
	public void setRunningTime(double runningTime) {
		this.runningTime = runningTime;
	}

	/**
	 * @param swimmingTime the swimmingTime to set
	 */
	public void setSwimmingTime(double swimmingTime) {
		this.swimmingTime = swimmingTime;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		Result other = (Result) o;

		double timeDiff = this.getTotalTime() - other.getTotalTime();

		if (timeDiff > 0) {
			return 1;
		}
		if (timeDiff < 0) {
			return -1;
		}
		return 0;
	}
}
