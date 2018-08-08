package Question1;

import java.util.Comparator;

/**
 * Class to sort list of employees by id
 * @author Richa Jain
 *
 */
public class SortById implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		
		return employee1.getEmpId() - employee2.getEmpId();
	}

}
