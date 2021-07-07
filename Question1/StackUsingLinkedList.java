package Question1;

import LinkedList.Node;

/**
 * This class is implemented using linked list
 * 
 * @author Richa Jain
 *
 */
public class StackUsingLinkedList<E> implements Stack<E> {

	private Node topElement;
	private int size;

	StackUsingLinkedList() {
		topElement = null;
		size = 0;
	}

	@Override
	public void push(E data) {
		Node newElement = new Node(data);
		if (size == 0) {
			topElement = newElement;
		} else {
			newElement.setNext(topElement);
			topElement = newElement;
		}
		size++;
	}

	@Override
	public E pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack Underflow");
		}
		E topValue = (E) topElement.getData();
		topElement = topElement.getNext();
		size--;
		return topValue;
	}

	@Override
	public E top() {
		if (!isEmpty()) {
			E topValue = (E) topElement.getData();
			return topValue;
		} else {
			throw new AssertionError("No element is present is stack");
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
}
