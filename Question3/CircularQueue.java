package Question3;

import Question2.Queue;
import Question2.QueueException;

/**
 * This class contains the implementation of the circular queue and support
 * functions such as insert element remove element, show top element, if a queue
 * is empty or full. It implements the Queue interface
 * 
 * @author Richa Jain
 *
 */
public class CircularQueue<E> implements Queue {

	private int front;
	private int rear;
	private int size;
	private E[] queue;

	public CircularQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queue = (E[]) new Object[this.size];
	}

	@Override
	public void insert(Object element) throws QueueException {

		if (!isFull()) {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1) % size;

			queue[rear] = (E) element;
		} else {
			throw new QueueException(
					"QueueOverflow : cannot insert more elements");
		}
	}

	@Override
	public Object remove() throws QueueException {

		if (isEmpty()) {
			throw new QueueException(
					"Queue Underflow: queue does not contains any element");
		}
		Object element = queue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % size;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (front == -1) ? true : false;
	}

	@Override
	public boolean isFull() {
		if ((front == 0 && rear == size - 1) || (front - rear == 1)) {
			return true;
		}
		return false;
	}

	@Override
	public Object top() {

		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new AssertionError("Queue is empty");
		}
	}

}
