import java.util.Scanner;

/**
 * This class is main class, takes student's information from user
 * 
 * @author Richa Jain
 *
 */

public class Marksheet {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		// n has to be positive
		System.out.println("Enter no of students");
		int n = scan.nextInt();
		Student studentArray[] = new Student[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter student's id");
			int id = scan.nextInt();
			// grades should be between 0 and 100 both inclusive
			System.out.println("Enter student's grade");
			double grade = scan.nextDouble();

			Student student = new Student(id, grade);
			studentArray[i] = student;
		}
		ClassPerformance performance = new ClassPerformance();
		try{
		System.out.println("Average Grades: "
				+ performance.getAvgGrades(studentArray));
		System.out.println("Maximum Grades: "
				+ performance.maxGrade(studentArray));
		System.out.println("Minimum Grades: "
				+ performance.minGrade(studentArray));
		System.out.println("Passing Percentage : "
				+ performance.studentPass(studentArray));
		}
		catch(ArithmeticException e){
			System.out.println("Error : not valid entries, " + e.getMessage());
		}
		scan.close();
	}

}
