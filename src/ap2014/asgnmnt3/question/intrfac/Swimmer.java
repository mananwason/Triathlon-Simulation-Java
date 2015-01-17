/**
 * 
 */
package ap2014.asgnmnt3.question.intrfac;

/**
 * @author manish
 *
 */
public interface Swimmer extends Runnable {
	
	int getStrokeCoverage();
	int getStrokeFrequency();
	int getNumberOfStrokes();
	void coverSwimmingSection();
}
