class FirstComeFirstServe{
	private int noOfProcess;
	private int jobsArray[][];
	private int waitingTime[];
	private int totalTime;
	private int compTime[];
	private int turnTime[];
	
	public FirstComeFirstServe(int jobsArray[][], int noOfProcess) {
		// TODO Auto-generated constructor stub
		this.jobsArray = jobsArray;
		this.noOfProcess = noOfProcess;
		waitingTime = new int[noOfProcess];
		totalTime = 0;
		compTime = new int[noOfProcess];
		turnTime = new int[noOfProcess];
	}
	
	/*
	 *  method calculate completion time
	 */
	int[] getCompletionTime(int jobsArray[][], int[] waitingTime){
		for(int i=0;i<noOfProcess;i++){
			compTime[i] = waitingTime[i] + jobsArray[i][0] + jobsArray[i][1];
		}
		return compTime;
	}
	
	/*
	 *  method calculate turn-around time
	 */
	int[] getTurnTime(int jobsArray[][], int[] waitingTime){
		for(int i=0;i<noOfProcess;i++){
			turnTime[i] = waitingTime[i] + jobsArray[i][1];
		}
		return turnTime;
	}
	
	/*
	 *  method calculate max waiting time
	 */
	double maxWaitingTime(int[] waitingTime){
		float maxTime =0;
		for(int count=0;count<waitingTime.length;count++){
			maxTime = maxTime > waitingTime[count] ? maxTime : waitingTime[count];
		}
		return maxTime;
	}
	
	/*
	 *  method calculate average waiting time
	 */
	double getAvgWaitTime(int[] waitingTime){
		double sumWaitingTime =0;
		for(int i=0;i<waitingTime.length;i++){
			sumWaitingTime += waitingTime[i];
		}
		return sumWaitingTime/noOfProcess;
	}
	
	/*
	 * method to calculate idle time, total time, completion time, turn-around time
	 */
	int[] getWaitingTime(int jobsArray[][]){
		int idleTime = 0;
		
		for(int i=0;i<noOfProcess;i++){
			idleTime = totalTime - jobsArray[i][0];
			if(idleTime >=0){
				waitingTime[i] = totalTime - jobsArray[i][0];
				totalTime += jobsArray[i][1];
			} else {
				idleTime = jobsArray[i][0] - totalTime;
				totalTime = totalTime + jobsArray[i][1] - idleTime;
			}
		}
		return waitingTime;
	}
	
	/*
	 * to display values of the array passed in it
	 */
	void display(int[] printValues){
		for(int i=0;i<noOfProcess;i++){
			System.out.print((i+1) + "th process" + printValues[i] + " ");
		}
	}
	
	
}