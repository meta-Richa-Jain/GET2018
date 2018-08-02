package Question2;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueUsingArrayTest {

	QueueUsingArray<String> queue = new QueueUsingArray<String>(5);
	
	@Test
	public void testQueueInsertPositive() throws QueueException {
		queue.insert("queue");
		queue.insert("implementation");
		String top = queue.top();
		assertEquals(top, "queue");
		
	}


	@Test
	public void testQueueRemovePositive() throws QueueException {
		queue.insert("queue");
		queue.insert("implementation");
		assertEquals("queue", queue.remove());
	}

	@Test(expected = QueueException.class)
	public void testQueueUnderflow() throws QueueException {
		queue.insert("queue");
		queue.remove();
		queue.remove();
	}

	@Test
	public void testQueueEmptyPositive() {
	
		assertEquals(true, queue.isEmpty());
	}

	@Test
	public void testQueueEmptyNegative() throws QueueException {
		
		queue.insert("queue");
		queue.insert("implementation");
		assertEquals(false, queue.isEmpty());
	}

	@Test
	public void testQueueFullPositive() throws QueueException {
		

		queue.insert("queue");
		queue.insert("implementation");
		queue.insert("using");
		queue.insert("array");
		queue.insert("fixed");
		assertEquals(true, queue.isFull());
	}
	
	@Test
	public void testQueueFullNegative() throws QueueException {
		

		queue.insert("queue");
		queue.insert("implementation");
		queue.insert("using");

		assertEquals(false, queue.isFull());
	}
	
	@Test(expected = QueueException.class)
	public void testQueueOverflow() throws QueueException {
		

		queue.insert("queue");
		queue.insert("implementation");
		queue.insert("using");
		queue.insert("array");
		queue.insert("fixed");
		queue.insert("size");
		
	}

	@Test
	public void testArrayFullNegative() throws QueueException {
		
		queue.insert("queue");
		assertEquals(false, queue.isFull());
	}

}
