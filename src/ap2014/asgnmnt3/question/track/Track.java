/**
 * 
 */
package ap2014.asgnmnt3.question.track;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ap2014.asgnmnt3.question.Racer;
import ap2014.asgnmnt3.question.Result;
import ap2014.asgnmnt3.question.intrfac.Cyclist;
import ap2014.asgnmnt3.question.intrfac.Runner;
import ap2014.asgnmnt3.question.intrfac.Swimmer;


/**
 * @author manish
 *
 */
public class Track {

	private List racers;
	private RunningSection runningSection;
	private SwimmingSection swimmingSection;
	private CyclingSection cyclingSection;
	private TrackSection[] sections = new TrackSection[3];

	/**
	 * 
	 */
	public Track(int numOfRacers) {
		runningSection = new RunningSection(3000, 10000);
		swimmingSection = new SwimmingSection(500, 1500);
		cyclingSection = new CyclingSection(5000, 20000);
		racers = new ArrayList(numOfRacers);
		sections[0] = runningSection;
		sections[1] = swimmingSection;
		sections[2] = cyclingSection;
		
		
	}
	/**
	 * @return
	 */
	public int getRunningLength() {
		return runningSection.getSectionLength();
	}

	/**
	 * @return
	 */
	public int getSwimmingLength() {
		return swimmingSection.getSectionLength();
	}

	/**
	 * @param racer
	 */
	public void addRacer(Racer racer) {
		racers.add(racer);
	}
	/**
	 * @return
	 */
	public int getCyclingLength() {
		return cyclingSection.getSectionLength();
	}
	
	/**
	 * @return
	 */
	public boolean allPrepared() {
		boolean allPreapred = true;
		for (Iterator iterator = racers.iterator(); iterator.hasNext();) {
			Racer racer = (Racer) iterator.next();
			allPreapred = allPreapred && racer.isPrepared();
		}
		return allPreapred;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "RunningLength " + getRunningLength() + "\n" +
				"SwimmingLength " + getSwimmingLength() + "\n" +
				"CyclingLength " + getCyclingLength() + "\n";
	}
	/**
	 * @param racer
	 * @param result
	 */
	public void calculateFinalPerformace(Racer racer, Result result) {
		runningSection.calculatePerformace((Runner)racer, result);
		swimmingSection.calculatePerformace((Swimmer)racer, result);
		cyclingSection.calculatePerformace((Cyclist)racer, result);
	}
}
