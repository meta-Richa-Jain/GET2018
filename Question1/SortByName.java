package Question1;

import java.util.Comparator;

/**
 * Class to sort employees list by name
 * @author Richa Jain
 *
 */
public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {
		
		return employee1.getName().compareToIgnoreCase(employee2.getName());
	}

}
