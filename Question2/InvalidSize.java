package Question2;

/**
 * Error class will be called if the entered queue size is negative or zero
 * 
 * @author Richa Jain
 *
 */
public class InvalidSize extends Exception {
	public InvalidSize(String message) {
		super(message);
	}
}
