/**
 * 
 */
package ap2014.asgnmnt3.question.intrfac;

/**
 * @author manish
 *
 */
public interface Runner extends Runnable {

	int getLeapCoverage();
	int getLeapFrequency();
	int getNumberOfLeaps();
	void coverRunningSection();
}
