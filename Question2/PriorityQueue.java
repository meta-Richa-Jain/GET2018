package Question2;

/**
 * Interface of Priority Queue consisting declarations of methods that has to be
 * implemented
 * 
 * @author Richa Jain
 *
 */
public interface PriorityQueue {

	/**
	 * Method to insert values to the queue
	 * 
	 * @param value
	 *            to be added to the queue
	 * @return true if val is added successfully else false
	 * @throws InvalidSize
	 *             if size of the queue entered is negative or zero
	 * @throws QueueException
	 *             if queue is empty or full
	 */
	public boolean enqueue(Job value) throws InvalidSize, QueueException;

	/**
	 * Method to remove a value from the queue
	 * 
	 * @return the Job object
	 * @throws InvalidSize
	 *             if size of the queue entered is negative or zero
	 * @throws QueueException
	 *             if queue is empty or full
	 */
	public Job dequeue() throws QueueException, InvalidSize;

	/**
	 * Method to find if the queue is empty or not
	 * 
	 * @return true if queue is empty else false
	 * @throws InvalidSize
	 *             if size of the queue entered is negative or zero
	 */
	public boolean isEmpty() throws InvalidSize;

	/**
	 * Method to find if a queue is full or not
	 * 
	 * @return true if queue is full else false
	 * @throws InvalidSize
	 *             if size of the queue entered is negative or zero
	 */
	public boolean isFull() throws InvalidSize;
}
