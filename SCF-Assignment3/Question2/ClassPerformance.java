/**
 * This class performs functions to calculate overall average grade, min grade,
 * maximum grade and passing percentage
 * 
 * @author Richa Jain
 *
 */
public class ClassPerformance {

	/**
	 * find average grade of all students
	 * 
	 * @param stuInfo
	 *            , containing information of students
	 * @return averageGrade
	 */
	double getAvgGrades(Student stuInfo[]) {
		double sumGrade = 0;
		int classStrength = stuInfo.length;
		for (int i = 0; i < classStrength; i++) {
			if (stuInfo[i].getGrade() < 0) {
				throw new ArithmeticException("Grades of Id" + (i + 1)
						+ "is not greater than zero");
			} else {
				sumGrade += stuInfo[i].getGrade();
			}
		}
		double averageGrade = sumGrade / classStrength;
		return averageGrade;
	}

	/**
	 * find maximum grade amongst all grades
	 * 
	 * @param stuInfo
	 *            , containing information of students
	 * @return highestGrade
	 */
	double maxGrade(Student stuInfo[]) {
		double highestGrade = 0;
		for (int i = 0; i < stuInfo.length; i++) {
			if (stuInfo[i].getGrade() < 0) {
				throw new ArithmeticException("Grades of " + (i + 1)
						+ "is not greater than zero");
			} else {
				if (highestGrade < stuInfo[i].getGrade()) {
					highestGrade = stuInfo[i].getGrade();
				}
			}
		}
		return highestGrade;
	}

	/**
	 * find minimum grade amongst all grades
	 * 
	 * @param stuInfo
	 *            , containing information of students
	 * @return lowestGrade
	 */
	double minGrade(Student stuInfo[]) {
		double lowestGrade = 100;
		for (int i = 0; i < stuInfo.length; i++) {
			if (stuInfo[i].getGrade() < 0) {
				throw new ArithmeticException("Grades of " + (i + 1)
						+ "is not greater than zero");
			} else {
				if (lowestGrade > stuInfo[i].getGrade()) {
					lowestGrade = stuInfo[i].getGrade();
				}
			}
		}
		return lowestGrade;
	}

	/**
	 * find percentage of total student pass, passing percentage is 40
	 * 
	 * @param stuInfo
	 *            , containing information of all the students
	 * @return noOfPassStudent, percentage of students passed
	 */
	double studentPass(Student stuInfo[]) {
		double passingPer = 40;
		double noOfPassStudent = 0;
		double studentPassCount = 0;
		for (int i = 0; i < stuInfo.length; i++) {
			if (stuInfo[i].getGrade() < 0) {
				throw new ArithmeticException("Grades of " + (i + 1)
						+ "is not greater than zero");
			} else {
				if (stuInfo[i].getGrade() >= passingPer) {
					studentPassCount++;
				}
			}
		}
		noOfPassStudent = (studentPassCount / stuInfo.length) * 100;
		return noOfPassStudent;
	}
}
