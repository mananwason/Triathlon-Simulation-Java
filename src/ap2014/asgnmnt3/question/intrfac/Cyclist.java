/**
 * 
 */
package ap2014.asgnmnt3.question.intrfac;

/**
 * @author manish
 * Cyclist is an interface because it is an 
 * abstract of a behaviour
 */
public interface Cyclist extends Runnable {
	
	int getPedalFrequency();

	int getNumberOfPedals();

	void coverCyclingSection();

}
