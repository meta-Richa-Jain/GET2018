package Question3;

/**
 * Error class will be called if total number of bowlers exceed the given size
 * of list
 * 
 * @author Richa Jain
 *
 */
public class BowlerOutOfBoundException extends Exception {
	public BowlerOutOfBoundException(String message) {
		super(message);
	}
}
