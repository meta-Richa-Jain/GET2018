package Question1;

/**
 * This error class is called when invalid input is provided
 * @author Richa Jain
 *
 */
public class InvalidInputError extends Exception {
	public InvalidInputError(String message) {
		super(message);
	}
}
