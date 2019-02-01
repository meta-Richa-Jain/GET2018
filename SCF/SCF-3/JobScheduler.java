import java.util.Scanner;

public class JobScheduler {
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter no of processes");
		
		int noOfProcess = input.nextInt();
		int dataEntry = 2;
		int jobsArray[][] = new int[noOfProcess][dataEntry];
		
		System.out.println("Enter arrival time and burst time of each processes");
		for(int i = 0; i<noOfProcess;i++){
			for(int j=0;j<2;j++){
				jobsArray[i][j] = input.nextInt();
			}
		}
		
		FirstComeFirstServe scheduling = new FirstComeFirstServe(jobsArray,noOfProcess);
		scheduling.getWaitingTime(jobsArray);
		input.close();
	}
}