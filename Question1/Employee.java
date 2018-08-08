package Question1;

/**
 * This class is used to store employee's details
 * @author Richa Jain
 *
 */
public class Employee {

	private int empId;
	private String name;
	private String address;

	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String toString() {
		return this.empId + " " + this.name + " " + this.address;
	}

}
