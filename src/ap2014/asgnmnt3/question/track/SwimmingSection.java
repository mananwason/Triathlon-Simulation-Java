/**
 * 
 */
package ap2014.asgnmnt3.question.track;

import ap2014.asgnmnt3.question.Result;
import ap2014.asgnmnt3.question.intrfac.Swimmer;

/**
 * @author manish
 * 
 */
public class SwimmingSection extends TrackSection {

	/**
	 * @param min
	 * @param max
	 */
	public SwimmingSection(int min, int max) {
		super(min, max);
	}

	/**
	 * @param racer
	 */
	public void calculatePerformace(Swimmer racer, Result result) {
		double numberOfStrokes = racer.getNumberOfStrokes();
		double strokeFrequency = racer.getStrokeFrequency();
		result.setSwimmingTime(numberOfStrokes / strokeFrequency);

	}

}
