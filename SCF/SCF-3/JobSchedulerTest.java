import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JobSchedulerTest {

	
	private int noOfProcess = 4;
	private int jobsArray[][] = {{0,10},{6,20},{60,10},{110,5}};
	private int turnTime[] = {10,24,10,5};
	private int compTime[] = {10,30,70,115};
	private int waitingTime[] = {0,4,0,0};
	
	@Test
	public void testTurnaroundTime() {
		FirstComeFirstServe fcfsObject = new FirstComeFirstServe(jobsArray, noOfProcess);
		int[] result = fcfsObject.getTurnTime(jobsArray, waitingTime);
		assertArrayEquals(result,turnTime);
	}
	
	@Test
	public void testCompletionTime() {
		FirstComeFirstServe fcfsObject = new FirstComeFirstServe(jobsArray, noOfProcess);
		int[] result = fcfsObject.getCompletionTime(jobsArray, waitingTime);
		assertArrayEquals(result,compTime);
	}
	
	@Test
	public void testWaitingTime() {
		FirstComeFirstServe fcfsObject = new FirstComeFirstServe(jobsArray, noOfProcess);
		int[] result = fcfsObject.getWaitingTime(jobsArray);
		assertArrayEquals(result,waitingTime);
	}
	
	@Test
	public void testAvgWaitingTime() {
		FirstComeFirstServe fcfsObject = new FirstComeFirstServe(jobsArray, noOfProcess);
		double result = fcfsObject.getAvgWaitTime(waitingTime);
		assertEquals(1, result,0);
	}
	
	@Test
	public void testMaxWaitingTime() {
		FirstComeFirstServe fcfsObject = new FirstComeFirstServe(jobsArray, noOfProcess);
		double result = fcfsObject.maxWaitingTime(waitingTime);
		assertEquals(4,result,0);
	}

}
