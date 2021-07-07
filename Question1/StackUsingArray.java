package Question1;

/**
 * This class is implemented using array
 * 
 * @author Richa Jain
 *
 */

public class StackUsingArray<E> implements Stack<E> {

	private final E[] stackArray;
	private int topIndex;
	private final int size;

	public StackUsingArray(final int size) {
		topIndex = -1;
		this.size = size;
		stackArray = (E[]) new Object[this.size];
	}

	@Override
	public E top() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack Underflow");
		} else {
			E topElement = stackArray[topIndex];
			return topElement;
		}
	}

	@Override
	public void push(E number) throws StackException {
		if (isSafe()) {
			topIndex++;
			stackArray[topIndex] = number;
		} else {
			throw new StackException("Stack Overflow");
		}
	}

	@Override
	public E pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack Underflow");
		} else {
			E topElement = stackArray[topIndex];
			topIndex--;
			return topElement;
		}
	}

	/**
	 * Helper function to check if the current index lies within the valid range
	 * or not
	 * 
	 * @return true if it is safe to insert element else false
	 */
	boolean isSafe() {
		return ((topIndex >= -1 && topIndex < size - 1) ? true : false);
	}

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}
}
