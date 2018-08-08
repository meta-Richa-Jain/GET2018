package Question3;

/**
 * Error class will be called when number of balls to be played by the player
 * exceeds the total sum of all the balls
 * 
 * @author Richa Jain
 *
 */
public class InvalidBallsError extends Exception {
	public InvalidBallsError(String message) {
		super(message);
	}

}
