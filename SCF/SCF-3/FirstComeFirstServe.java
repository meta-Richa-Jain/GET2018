class FirstComeFirstServe{
	private int noOfProcess;
	private int dataEntry;
	private int jobsArray[][];
	private int waitingTime[];
	private int totalTime;
	private int compTime[];
	private int turnTime[];
	
	public FirstComeFirstServe(int jobsArray[][], int noOfProcess,int dataEntry) {
		// TODO Auto-generated constructor stub
		this.jobsArray = jobsArray;
		this.noOfProcess = noOfProcess;
		this.dataEntry = dataEntry;
		waitingTime = new int[noOfProcess];
		totalTime = 0;
		compTime = new int[noOfProcess];
		turnTime = new int[noOfProcess];
	}
	
	/*
	 * method to calculate idle time, total time, completion time, turn-around time
	 */
	void fcfs(){
		int totalTime = 0;
		int idleTime = 0;
		int waitingTime[] = new int[noOfProcess];
		int compTime[] = new int[noOfProcess];
		int turnTime[] = new int[noOfProcess];
		int sumWaitingTime = 0;
		int maxWaitTime=0;
		
		for(int i=0;i<noOfProcess;i++){
			idleTime = totalTime - jobsArray[i][0];
			if(idleTime >=0){
				waitingTime[i] = totalTime - jobsArray[i][0];
				totalTime += jobsArray[i][1];
			} else {
				idleTime = jobsArray[i][0] - totalTime;
				totalTime = totalTime + jobsArray[i][1] - idleTime;
			}
			compTime[i] = waitingTime[i] + jobsArray[i][0] + jobsArray[i][1];
			turnTime[i] = waitingTime[i] + jobsArray[i][1];
			
			if(maxWaitTime<waitingTime[i]){
				maxWaitTime = waitingTime[i];
			}
			sumWaitingTime += waitingTime[i];
		}
		System.out.println("Average waiting time: " + getAvgWaitTime(sumWaitingTime));
		System.out.println("Maximum waiting time: " + maxWaitTime);
		for(int i=0;i<noOfProcess;i++){
			System.out.println((i+1) + "th Process : " + "Waiting Time : " + waitingTime[i] + " Completion time : " + compTime[i] + 
					" Turnaround Time : " + turnTime[i]);
		}
	}
	/*
	 * to display values of the array passed in it
	 */
	void display(int[] printValues){
		for(int i=0;i<noOfProcess;i++){
			System.out.print((i+1) + "th process" + printValues[i] + " ");
		}
	}
	void getWaitingTime(){
		
	}
	/*
	 *  method calculate completion time
	 */
	void getCompletionTime(){
		for(int i=0;i<noOfProcess;i++){
			compTime[i] = waitingTime[i] + jobsArray[i][0] + jobsArray[i][1];
		}
		display(compTime);
	}
	
	/*
	 *  method calculate turn-around time
	 */
	void getTurnTime(){
		for(int i=0;i<noOfProcess;i++){
			turnTime[i] = waitingTime[i] + jobsArray[i][1];
		}
		display(turnTime);
	}
	
	double getAvgWaitTime(int sumWaitingTime){
		return sumWaitingTime/noOfProcess;
	}
	
}