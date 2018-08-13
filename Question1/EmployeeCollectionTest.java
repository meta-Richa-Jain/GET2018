package Question1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest {

	EmployeeCollection employeeCollection = new EmployeeCollection();

	@Test
	public void testSortById() throws InvalidInputError {
		employeeCollection.addEmployee(1, "arjita", "gwalior");
		employeeCollection.addEmployee(2, "richa", "jaipur");
		employeeCollection.addEmployee(4, "aastha", "bikaner");
		employeeCollection.addEmployee(6, "prakshi", "ajmer");
		employeeCollection.addEmployee(3, "shruti", "agra");
		employeeCollection.addEmployee(5, "tanu", "jaipur");
		employeeCollection.sortEmployeeById();

		List<Employee> actualList = employeeCollection.employeeList;
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(1, "arjita", "gwalior"));
		expectedResult.add(new Employee(2, "richa", "jaipur"));
		expectedResult.add(new Employee(3, "shruti", "agra"));
		expectedResult.add(new Employee(4, "aastha", "bikaner"));
		expectedResult.add(new Employee(5, "tanu", "jaipur"));
		expectedResult.add(new Employee(6, "prakshi", "ajmer"));

		String actualString = employeeCollection.toString(actualList);
		String expectedString = employeeCollection.toString(expectedResult);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void testSortByName() throws InvalidInputError {
		employeeCollection.addEmployee(1, "arjita", "gwalior");
		employeeCollection.addEmployee(2, "richa", "jaipur");
		employeeCollection.addEmployee(4, "aastha", "bikaner");
		employeeCollection.addEmployee(6, "prakshi", "ajmer");
		employeeCollection.addEmployee(3, "shruti", "agra");
		employeeCollection.addEmployee(5, "tanu", "jaipur");
		employeeCollection.sortEmployeeByName();
		List<Employee> actualList = employeeCollection.employeeList;
		
		List<Employee> expectedResult = new ArrayList<Employee>();
		expectedResult.add(new Employee(4, "aastha", "bikaner"));
		expectedResult.add(new Employee(1, "arjita", "gwalior"));
		expectedResult.add(new Employee(6, "prakshi", "ajmer"));
		expectedResult.add(new Employee(2, "richa", "jaipur"));
		expectedResult.add(new Employee(3, "shruti", "agra"));
		expectedResult.add(new Employee(5, "tanu", "jaipur"));

		String actualString = employeeCollection.toString(actualList);
		String expectedString = employeeCollection.toString(expectedResult);
		assertEquals(expectedString, actualString);

	}

	@Test
	public void testDuplicateId() throws InvalidInputError {
		assertEquals(true,
				employeeCollection.addEmployee(1, "arjita", "gwalior"));
		assertEquals(true, employeeCollection.addEmployee(2, "richa", "jaipur"));
		assertEquals(true, employeeCollection.addEmployee(5, "tanu", "jaipur"));
		assertEquals(false,
				employeeCollection.addEmployee(5, "aastha", "bikaner"));
	}

	@Test(expected = InvalidInputError.class)
	public void testInvalidId() throws InvalidInputError {
		employeeCollection.addEmployee(1, "arjita", "gwalior");
		employeeCollection.addEmployee(0, "richa", "jaipur");

	}

	@Test(expected = InvalidInputError.class)
	public void testInvalidName() throws InvalidInputError {
		employeeCollection.addEmployee(1, "arjita", "gwalior");
		employeeCollection.addEmployee(0, null, "jaipur");

	}

	@Test(expected = InvalidInputError.class)
	public void testInvalidAddress() throws InvalidInputError {
		employeeCollection.addEmployee(1, "arjita", "gwalior");
		employeeCollection.addEmployee(0, "richa", null);

	}

}
