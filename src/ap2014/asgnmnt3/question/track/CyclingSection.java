/**
 * 
 */
package ap2014.asgnmnt3.question.track;

import ap2014.asgnmnt3.question.Result;
import ap2014.asgnmnt3.question.intrfac.Cyclist;

/**
 * @author manish
 * 
 */
public class CyclingSection extends TrackSection {

	/**
	 * @param min
	 * @param max
	 */
	public CyclingSection(int min, int max) {
		super(min, max);
	}

	/**
	 * @param racer
	 */
	public void calculatePerformace(Cyclist racer, Result result) {
		double numberOfPedals = racer.getNumberOfPedals();
		double pedalFequency = racer.getPedalFrequency();
		result.setCyclingTime(numberOfPedals/pedalFequency);

	}

}
