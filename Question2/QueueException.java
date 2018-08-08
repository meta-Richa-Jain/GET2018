package Question2;

/**
 * This error class will be called if an enqueue operation on a full queue or
 * dequeue operation on an empty queue is performed
 * 
 * @author Richa Jain
 *
 */
public class QueueException extends Exception {
	public QueueException(String message) {
		super(message);
	}
}
