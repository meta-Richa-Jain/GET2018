package Question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueueUsingLinkedListTest {

QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<String>();
	
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
	public void testQueueFullNegative() throws QueueException {
		

		queue.insert("queue");
		queue.insert("implementation");
		queue.insert("using");

		assertEquals(false, queue.isFull());
	}
	
	@Test(expected = AssertionError.class)
	public void testEmptyQueueTop() throws QueueException {
		
		String top = queue.top();
		
	}

}
