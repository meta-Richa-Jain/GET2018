package Question2;

/**
 * This class is implemented using array
 * 
 * @author Richa Jain
 *
 */

public class QueueUsingArray<E> implements Queue<E> {

	private int front; // front element of the queue
	private int rear; // rear element of the queue
	private int size; // maximum size of the array
	private E[] queue;

	public QueueUsingArray(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queue = (E[]) new Object[this.size];
	}

	@Override
	public void insert(E number) throws QueueException {
		if (front == -1) {
			front++;
			rear++;
			queue[front] = number;
		} else if (!isFull()) {
			rear++;
			queue[rear] = number;
		} else {
			throw new QueueException(
					"Queue overflow: cannot insert more elements");
		}
	}

	@Override
	public E remove() throws QueueException {
		E data = null;
		if (!isEmpty()) {
			data = queue[front];
			front++;
		} else {
			throw new QueueException(
					"Queue Underflow: no element is present in the queue");
		}
		return data;
	}

	@Override
	public boolean isEmpty() {

		return front == rear ? true : false;

	}

	@Override
	public boolean isFull() {

		return rear == queue.length - 1 ? true : false;
	}

	@Override
	public E top() {
		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new AssertionError("Empty Queue");
		}
	}

}
