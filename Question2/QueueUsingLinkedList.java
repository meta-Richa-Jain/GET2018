package Question2;

import LinkedList.Node;

/**
 * This class is implemented using linked list
 * 
 * @author Richa Jain
 *
 */

public class QueueUsingLinkedList<E> implements Queue<E> {

	private Node front; // front element of the queue
	private Node rear; // rear element of the queue
	private int size; // current size of the queue

	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void insert(E number) {
		Node newElement = new Node(number);
		if (isEmpty()) {
			front = newElement;
			rear = newElement;
		} else {
			rear.setNext(newElement);
			rear = newElement;
		}
		size++;
	}

	@Override
	public E remove() throws QueueException {
		if (!isEmpty()) {
			E data = (E) front.getData();
			front = front.getNext();
			return data;
		} else {
			throw new QueueException(
					"Queue Underflow: queue does not any element");
		}
	}

	@Override
	public boolean isEmpty() {
		return front == null ? true : false;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public E top() {

		if (!isEmpty()) {
			return (E) front.getData();
		} else {
			throw new AssertionError("No element in queue");
		}
	}

}
