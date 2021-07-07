package Question1;

/**
 * Interface stack implemented by StackUsingArray & StackUsingLinkedList classes
 * 
 * @author Richa Jain
 *
 */
public interface Stack<E> {

	/**
	 * Method to return the top element of the stack
	 * 
	 * @return top element of the stack
	 * @throws StackException
	 *             if stack is empty
	 */
	public E top() throws StackException;

	/**
	 * Method to insert an element onto the stack
	 * 
	 * @param number
	 *            to be inserted onto the stack
	 * @throws StackException
	 *             if stack is full
	 */
	public void push(E element) throws StackException;

	/**
	 * Method to remove the top element from the stack
	 * 
	 * @return top element of the stack
	 * @throws StackException
	 *             if stack is empty
	 */
	public E pop() throws StackException;

	/**
	 * Method to find if a stack is empty or not
	 * 
	 * @return true if stack is empty else false
	 */
	public boolean isEmpty();

}
