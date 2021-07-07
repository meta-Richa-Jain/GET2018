package Question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PriorityQueueTest {

	PriorityQueueArray priorityQueue;

	@Test
	public void testPositive() throws QueueException, InvalidSize {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = QueueException.class)
	public void testQueueFull() throws QueueException, InvalidSize {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = QueueException.class)
	public void testQueueEmpty() throws QueueException, InvalidSize {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = InvalidSize.class)
	public void testSizeError() throws QueueException, InvalidSize {
		priorityQueue = new PriorityQueueArray(-4);
		priorityQueue.enqueue(new Job(2, 2));
	}
}
