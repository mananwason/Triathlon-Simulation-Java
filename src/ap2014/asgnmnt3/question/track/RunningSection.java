/**
 * 
 */
package ap2014.asgnmnt3.question.track;

import ap2014.asgnmnt3.question.Result;
import ap2014.asgnmnt3.question.intrfac.Runner;


/**
 * @author manish
 *
 */
public class RunningSection extends TrackSection {

	

	/**
	 * @param min
	 * @param max
	 */
	public RunningSection(int min, int max) {
		super(min, max);
	}
	
	/**
	 * @param racer
	 */
	public void calculatePerformace(Runner racer, Result result) {
		double numberOfLeaps = racer.getNumberOfLeaps();
		double leapFequency = racer.getLeapFrequency();
		result.setRunningTime(numberOfLeaps/leapFequency);
	}


}
