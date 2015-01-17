/**
 * 
 */
package ap2014.asgnmnt3.question;

import java.util.Arrays;
import java.util.Random;

import ap2014.asgnmnt3.question.track.Track;


/**
 * @author manish
 *
 */
public class Triathlon {

	public static final Random RANDOM = new Random();
	private Track track;
	private Racer[] racers;
	private int numOfParticipants;
	private Result[] results;
	private Thread[] racerThreads;

	/**
	 * 
	 */
	public Triathlon(int numOfRacer) {
		numOfParticipants = numOfRacer;
		track = new Track(numOfParticipants);
		results = new Result[numOfParticipants];
	}

	/**
	 * 
	 */
	public void prepare() {
		racerThreads = new Thread[numOfParticipants];
		for (int i = 0; i < racerThreads.length; i++) {
			racerThreads[i] = new Thread(racers[i]);
		}
	}

	/**
	 * 
	 */
	public void start() {
		for (int i = 0; i < racerThreads.length; i++) {
			racerThreads[i].start();
		}
	}

	/**
	 * 
	 */
	public void calculateResults() {
		for (int i = 0; i < racers.length; i++) {
			Racer racer = racers[i];
			results[i] = new Result(racer.getId(), racer.getName());
			track.calculateFinalPerformace(racer, results[i] );
		}
		Arrays.sort(results);
	}

	/**
	 * @return
	 */
	public Result[] getResults() {
		return results;
	}

	/**
	 * @return
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @return the racers
	 */
	public Racer[] getRacers() {
		return racers;
	}

	/**
	 * 
	 */
	public void createRacers() {
		racers = new Racer[numOfParticipants];
		for(int i=0; i< numOfParticipants; i++){
			racers[i] = new Racer("Racer " + i, "ap2014-A3-R_" + i, track,
					1 + Triathlon.RANDOM.nextInt(3),1 + Triathlon.RANDOM.nextInt(5),
					1 + Triathlon.RANDOM.nextInt(2),1 + Triathlon.RANDOM.nextInt(3),
					1 + Triathlon.RANDOM.nextInt(8));
		}
	}

	/**
	 * 
	 */
	public void finish() {
		for (int i = 0; i < racerThreads.length; i++) {
			try {
				racerThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
