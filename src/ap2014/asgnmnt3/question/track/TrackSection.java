/**
 * 
 */
package ap2014.asgnmnt3.question.track;

import ap2014.asgnmnt3.question.Triathlon;

// @formatter:off
/**
 * @author manish
 * TrackSection is an abstract class because
 * it is abstraction of an actual object.
 * wherever is used, it has a valid state.
 * State is called one particular combination
 *  of it's properties. 
 */
// @formatter:on
public abstract class TrackSection {
	
	protected int sectionLength;
	public TrackSection(int min, int max) {
		
		sectionLength = min + Triathlon.RANDOM.nextInt(max-min);
		sectionLength -= sectionLength%100;
	}
	
	/**
	 * @return the sectionLength
	 */
	public int getSectionLength() {
		return sectionLength;
	}
}
