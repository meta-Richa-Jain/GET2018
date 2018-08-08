package Question2;

/**
 * Main class implementing enqueue, dequeue operations on the priority queue
 * 
 * @author Richa Jain
 *
 */
public class PriorityQueueArray implements PriorityQueue {

	private Job[] queue;
	private int rear, front, maxSize;

	public PriorityQueueArray(int maxSize) {
		if (checkSize(maxSize)) {

			this.queue = new Job[maxSize];
			this.maxSize = maxSize;
		}

		this.rear = -1;
		this.front = -1;
	}

	private boolean checkSize(int maxSize) {
		return maxSize > 0 ? true : false;
	}

	@Override
	public boolean enqueue(Job job) throws InvalidSize, QueueException {
		try {
			if (!checkSize(maxSize)) {

				throw new InvalidSize("Invalid size");

			} else if (!isFull()) {
				if (rear == -1) {
					front++;
					rear++;
				} else {
					rear = (rear + 1) % maxSize;
				}
				int pos = -1;
				for (int i = front; i <= (rear - 1) % maxSize; i++) {
					if (job.getPriority() > queue[i].getPriority()) {
						pos = i;
						break;
					}
				}
				if (pos != -1) {
					for (int i = (rear - 1) % maxSize; i >= pos; i--) {
						queue[(i + 1) % maxSize] = queue[i];
					}
					queue[pos] = job;
				} else
					queue[rear] = job;

			} else
				throw new QueueException("The queue is full!");

			return true;

		} catch (InvalidSize error) {
			throw new InvalidSize("Invalid Size");
		} catch (QueueException error) {
			throw new QueueException("The queue is full");
		}
	}

	@Override
	public Job dequeue() throws QueueException, InvalidSize {
		Job job = null;
		try {
			if (!checkSize(maxSize)) {

				throw new InvalidSize("Invalid size");
			}

			if (!isEmpty()) {
				if (front == rear) {
					job = queue[front];
					front = -1;
					rear = -1;
				} else {
					job = queue[front];
					front = (front + 1) % maxSize;
				}
			} else
				throw new QueueException("The queue is empty!");
		} catch (InvalidSize error) {
			throw new InvalidSize("Invalid size of the queue");
		} catch (QueueException error) {
			throw new QueueException("This queue is empty");
		}

		return job;
	}

	@Override
	public boolean isEmpty() throws InvalidSize {
		if (!checkSize(maxSize)) {
			try {
				throw new InvalidSize("Invalid size");
			} catch (InvalidSize e) {
				throw new InvalidSize("Invalid Size");
			}
		}
		return rear == -1 && front == -1 ? true : false;

	}

	@Override
	public boolean isFull() throws InvalidSize {
		if (!checkSize(maxSize)) {
			try {
				throw new InvalidSize("Invalid size");
			} catch (InvalidSize e) {
				throw new InvalidSize("Invalid Size");
			}
		}
		return (rear + 1) % maxSize == front;
	}

}
