/**
 * 
 */
package ap2014.asgnmnt3.mainclass;

import ap2014.asgnmnt3.question.Racer;
import ap2014.asgnmnt3.question.Result;
import ap2014.asgnmnt3.question.Triathlon;

/**
 * @author manish
 *
 */
public class Question {
	
	public static void main(String[] args) {
		Triathlon race = new Triathlon(10);
		race.createRacers();
		
		System.out.println("\n------Track Details------");
		System.out.println(race.getTrack());
		
		
		System.out.println("\n------Racer Details------");
		System.out.println(Racer.HEADER_ROW);
		Racer[] racers = race.getRacers();
		for (int i = 0; i < race.getRacers().length; i++) {
			System.out.println(racers[i]);
		}

		race.prepare();
		race.start();
		race.finish();
		race.calculateResults();
		Result[] results = race.getResults();
		
		System.out.println("\n------Results------");
		System.out.println(Result.HEADER_ROW);
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}

}
