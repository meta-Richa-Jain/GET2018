package Question2;

/**
 * Generic interface implemented by QueueUsingArray & QueueUsingLinkedList
 * classes
 * 
 * @author Richa Jain
 *
 */
public interface Queue<E> {

	/**
	 * Method to insert an element to a queue
	 * 
	 * @param element
	 *            to be inserted to the queue
	 * @throws QueueException
	 *             if queue is full
	 */
	public void insert(E element) throws QueueException;

	/**
	 * Method to remove the front element from the queue
	 * 
	 * @return the data of the element
	 * @throws QueueException
	 *             if queue is empty
	 */
	public E remove() throws QueueException;

	/**
	 * Method to check if the queue is empty or not
	 * 
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty();

	/**
	 * Method to check if the queue is full or not
	 * 
	 * @return true if queue is full else false
	 */
	public boolean isFull();

	/**
	 * Method to return the front element of the queue
	 * 
	 * @return the front element
	 */
	public E top();

}
