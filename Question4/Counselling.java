package Question4;

import java.io.File;
import java.io.IOException;

import Question2.Queue;
import Question2.QueueException;
import Question2.QueueUsingArray;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

public class Counselling {

	private Program programList[];
	private int size;
	private StudentAllocationList studentsList[];
	private int size1= 0;

	public void programs() {

		try {
			Workbook workbook = Workbook.getWorkbook(
					new java.io.File("C:/Users/User12/workspace/DS-Assignment2/src/Question4/Programs.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet
			this.programList = new Program[sheet.getRows()];
			String programName = null;
			int capacity = 0;
			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						programName = cell.getContents();
					} else if (type == CellType.NUMBER) {
						capacity = Integer.parseInt(cell.getContents());
					}
				}
				Program p = new Program(programName, capacity);
				this.programList[i] = p;
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void allocate(Queue<StudentNode> queue) throws QueueException {
		this.studentsList = new StudentAllocationList[size];
		int count3=0;
		while (!queue.isEmpty()) {
			StudentNode student = queue.remove();
			String preferences[] = student.getData();
			outerloop: for (int count1 = 0; count1 < preferences.length; count1++) {
				for (int count = 0; count < this.programList.length; count++) {
					String programName = this.programList[count].getName();
					if (preferences[count1].equalsIgnoreCase(programName)) {
						int remaining = programList[count].getRemainig();
						if (remaining > 0) {
							String allocatedProgram = programName;
							String name = student.getName();
							StudentAllocationList st = new StudentAllocationList(name, allocatedProgram);
							//System.out.println(allocatedProgram);
							studentsList[count3] = st;
							count3++;
							size1++;
							programList[count].setRemainig(remaining - 1);
							break outerloop;
						}
					}

				}

			}

		}
	}

	public void updateExcel() throws IOException {
		
		int i=0;
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(
					new File("C:/Users/User12/workspace/DS-Assignment2/src/Question4/allocationList.xls"));
			WritableSheet wSheet = workbook.createSheet("sheet1",0);
			int count1;
			//Label labTemp1;
			String program1 = this.studentsList[4].getAllocatedProgram();
			//System.out.println("CHECK " + program1);
			for (count1 = 0; count1 < this.size1; count1++) {
				String name= this.studentsList[i].getName();
				Label labTemp1 = new Label(0, count1, name);
				wSheet.addCell(labTemp1);
				String program = this.studentsList[i].getAllocatedProgram();
				Label labTemp2 = new Label(1, count1, program);
				i++;
				wSheet.addCell(labTemp2);
				
			}
			
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public Queue<StudentNode> addStudents() throws QueueException {
		this.size = 0;
		Queue<StudentNode> queue = null;
		try {
			Workbook workbook = Workbook.getWorkbook(
					new java.io.File("C:/Users/User12/workspace/DS-Assignment2/src/Question4/Students.xls"));
			// Obtain the reference to the first sheet in the workbook
			Sheet sheet = workbook.getSheet(0);
			// Obtain reference to the Cell using getCell(int col, int row)
			// method of sheet

			queue = new QueueUsingArray<>(sheet.getRows());
			this.size = sheet.getRows();

			for (int i = 0; i < sheet.getRows(); i++) {
				Cell name = sheet.getCell(0, i);
				String studentName = name.getContents();
				String[] pref = new String[5];
				for (int j = 1; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						pref[j - 1] = cell.getContents();
					}
				}
				StudentNode student = new StudentNode(studentName, pref);
				queue.insert(student);

			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return queue;

	}

	public static void main(String[] args) throws QueueException, IOException {
		Counselling c = new Counselling();
		c.programs();
		Queue<StudentNode> queue = c.addStudents();
		c.allocate(queue);
		c.updateExcel();
	}
}