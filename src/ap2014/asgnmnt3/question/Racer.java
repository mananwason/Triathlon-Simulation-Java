/**
 * 
 */
package ap2014.asgnmnt3.question;

import java.text.DecimalFormat;

import ap2014.asgnmnt3.question.intrfac.Cyclist;
import ap2014.asgnmnt3.question.intrfac.Runner;
import ap2014.asgnmnt3.question.intrfac.Swimmer;
import ap2014.asgnmnt3.question.track.Track;

/**
 * @author manish
 * 
 */
public class Racer implements Cyclist, Runner, Swimmer {

	private static final DecimalFormat NF = new DecimalFormat("00 ");
	public static final String HEADER_ROW = "Id           , "
			+ "Name   , " + "LC , " + "LF , " + "SC , " + "SF , "
			+ "CC , " + "PF , ";
	private String name;
	private String id;
	private Track track;
	private boolean prepared = false;

	// Fields related to racer's strength
	private int leapCoverage;
	private int leapFrequency;
	private int strokeCoverage;
	private int strokeFrequency;
	private int cyclingCoverage = 10;
	private int pedalFrequency;

	// fields related to calculate race results
	private int numberOfLeaps;
	private int numberOfStrokes;
	private int numberOfPedals;

	/**
	 * @param createTrack
	 */
	public Racer(String name, String id, Track track,
			int leapCoverage, int leapFrequency, int strokeCoverage,
			int strokeFrequency, int pedalFrequency) {
		this.name = name;
		this.id = id;
		this.track = track;
		track.addRacer(this);
		this.leapCoverage = leapCoverage;
		this.leapFrequency = leapFrequency;
		this.strokeCoverage = strokeCoverage;
		this.strokeFrequency = strokeFrequency;
		this.pedalFrequency = pedalFrequency;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		prepared = true;
		while (!track.allPrepared()) {

		}
		coverRunningSection();

		coverSwimmingSection();

		coverCyclingSection();
	}

	
	public void coverCyclingSection() {
		int cyclingLength = track.getCyclingLength();
		int totalCyclingCoverage = 0;
		while (totalCyclingCoverage < cyclingLength) {
			totalCyclingCoverage += cyclingCoverage;
			numberOfPedals++;
		}
	}

	
	@Override
	public void coverSwimmingSection() {
		int swimmingLength = track.getSwimmingLength();
		int totalSwimmingCoverage = 0;
		while (totalSwimmingCoverage < swimmingLength) {
			totalSwimmingCoverage += strokeCoverage;
			numberOfStrokes++;
		}
	}

	@Override
	public void coverRunningSection() {
		int runningLength = track.getRunningLength();
		int totalCoverage = 0;
		while (totalCoverage < runningLength) {
			totalCoverage += leapCoverage;
			numberOfLeaps++;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ap2014.asgnmnt3.main_class.Swimmer#getStrokeCoverage()
	 */
	public int getStrokeCoverage() {
		return strokeCoverage;
	}

	/*
	 * (non-Javadoc)
	 * @see ap2014.asgnmnt3.main_class.Swimmer#getStrokeFrequency()
	 */
	public int getStrokeFrequency() {
		return strokeFrequency;
	}

	/*
	 * (non-Javadoc)
	 * @see ap2014.asgnmnt3.main_class.Runner#getLeapCoverage()
	 */
	public int getLeapCoverage() {
		return leapCoverage;
	}

	/*
	 * (non-Javadoc)
	 * @see ap2014.asgnmnt3.main_class.Runner#getLeapFequency()
	 */
	public int getLeapFrequency() {
		return leapFrequency;
	}

	/*
	 * (non-Javadoc)
	 * @see ap2014.asgnmnt3.main_class.Cyclist#getPedalFequency()
	 */
	public int getPedalFrequency() {
		return pedalFrequency;
	}

	/**
	 * @return the numberOfLeaps
	 */
	@Override
	public int getNumberOfLeaps() {
		return numberOfLeaps;
	}

	/**
	 * @return the numberOfStrokes
	 */
	@Override
	public int getNumberOfStrokes() {
		return numberOfStrokes;
	}

	/**
	 * @return the numberOfPedals
	 */
	@Override
	public int getNumberOfPedals() {
		return numberOfPedals;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the prepared
	 */
	public boolean isPrepared() {
		return prepared;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return  id + ", " + 
				name + ", " 
				+ NF.format(leapCoverage) + ", "
				+ NF.format(leapFrequency) + ", "
				+ NF.format(strokeCoverage) + ", "
				+ NF.format(strokeFrequency) + ", "
				+ NF.format(cyclingCoverage) + ", "
				+ NF.format(pedalFrequency);
	}
}
