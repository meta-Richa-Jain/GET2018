/**
 * Student class stores student's information, their unique id and grades
 * 
 * @author Richa Jain
 *
 */
public class Student {
	private int studentId;
	private double grade;

	public Student(int id, double grade) {
		this.setStudentId(id);
		this.setGrade(grade);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

}
