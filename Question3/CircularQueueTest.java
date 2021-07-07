package Question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Question2.QueueException;

public class CircularQueueTest {

	CircularQueue<Integer> queue = new CircularQueue<Integer>(5);

	@Test
	public void testInsertPositive() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		int result = (int) queue.top();
		assertEquals(result, 4);
	}

	@Test
	public void testRemovePositive() throws QueueException {
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		int result = (int) queue.remove();
		assertEquals(result, 9);
	}

	@Test
	public void testIsEmptyNegative() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		boolean result = queue.isEmpty();
		assertEquals(result, false);
	}

	@Test
	public void testIsEmptyPositive() throws QueueException {

		boolean result = queue.isEmpty();
		assertEquals(result, true);
	}
	
	@Test(expected = AssertionError.class)
	public void testEmptyQueueTop() throws QueueException {

		int result = (int) queue.top();

	}

	@Test
	public void testIsFullPositive() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(1);
		boolean result = queue.isFull();
		assertEquals(result, true);
	}

	@Test
	public void testIsFullNegative() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		boolean result = queue.isFull();
		assertEquals(result, false);
	}

	@Test
	public void testCircularQueue() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(2);
		int frontVal = (int) queue.remove();
		queue.insert(5);
		int result = (int) queue.top();
		assertEquals(result, 9);
	}

	@Test
	public void testCircularQueueFull() throws QueueException {
		queue.insert(4);
		queue.insert(9);
		queue.insert(11);
		queue.insert(12);
		queue.insert(2);
		int frontVal = (int) queue.remove();
		queue.insert(5);
		boolean result = queue.isFull();
		assertEquals(result, true);
	}

}
