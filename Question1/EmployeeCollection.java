package Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is used to add employees and sort them by their id or name
 * 
 * @author Richa Jain
 *
 */
public class EmployeeCollection {

	List<Employee> employeeList = new ArrayList<Employee>();
	private Set<Integer> empIdList = new HashSet<Integer>();

	/**
	 * Method to add employee to employeeList
	 * 
	 * @param empId
	 * @param name
	 * @param address
	 * @return true if no duplicate id is present else false
	 * @throws InvalidInputError
	 *             if employee id is negative or zero, or name or address is
	 *             null
	 */
	public boolean addEmployee(int empId, String name, String address)
			throws InvalidInputError {
		try {
			if (empId <= 0 || name == null || address == null) {
				throw new InvalidInputError(
						"Sorry can't add employee with invalid input");
			}
			if (!empIdList.contains(empId)) {
				employeeList.add(new Employee(empId, name, address));
				empIdList.add(empId);
				return true;
			} else {
				return false;
			}
		} catch (InvalidInputError message) {
			throw new InvalidInputError(
					"Sorry can't add employee with invalid input");
		}

	}

	/**
	 * Method calls compare method of SortById class to sort employees on the
	 * basis of id
	 */
	public void sortEmployeeById() {
		Collections.sort(employeeList, new SortById());
	}

	/**
	 * Method calls compare method of SortByName class to sort employees on the
	 * basis of name
	 */
	public void sortEmployeeByName() {
		Collections.sort(employeeList, new SortByName());
	}

	/**
	 * Method to return text value of the list
	 * 
	 * @param listOfEmployees, containing information about 
	 * @return text value of the string
	 */
	public String toString(List<Employee> listOfEmployees) {
		StringBuilder result = new StringBuilder();
		for (int count = 0; count < listOfEmployees.size(); count++) {
			Employee employee = listOfEmployees.get(count);
			result.append(employee.getEmpId() + " " + employee.getName() + " "
					+ employee.getAddress());
		}
		return result.toString();

	}

}
