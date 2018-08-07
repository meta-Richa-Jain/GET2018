package Question4;

import Question2.Queue;
import Question2.QueueException;

/**
 * This class is implemented using array
 * 
 * @author Richa Jain
 *
 */

public class StudentsQueue<StudentNode> implements Queue<StudentNode> {

	private int front; // front element of the queue
	private int rear; // rear element of the queue
	private int size; // maximum size of the array
	private StudentNode[] queue;

	public StudentsQueue(int size) {
		front = -1;
		rear = -1;
		this.size = size;
		queue = (StudentNode[]) new Object[this.size];
	}

	@Override
	public void insert(StudentNode information) throws QueueException {
		if (front == -1) {
			front++;
			rear++;
			queue[front] = information;
		} else if (!isFull()) {
			rear++;
			queue[rear] = information;
		} else {
			throw new QueueException(
					"Queue overflow: cannot insert more elements");
		}
	}

	@Override
	public StudentNode remove() throws QueueException {
		StudentNode data = null;
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
	public StudentNode top() {
		if (!isEmpty()) {
			return queue[front];
		} else {
			throw new AssertionError("Empty Queue");
		}
	}

}
