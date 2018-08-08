package Question3;

/**
 * Error class will be called if wrong inputs are entered
 * 
 * @author Richa Jain
 *
 */
public class checkValidation extends Exception {
	public checkValidation(String message) {
		super(message);
	}
}
