package dao;

public class Queries {

	public final static String ADD_EMPLOYEE = "INSERT INTO EmployeeDetails(first_name, last_name, email, age, dob, contact_number, pwd, organization_name)"
			+ "VALUES (?,?,?,?,?,?,?,?)";

	public final static String SHOW_EMPLOYEE_DETAILS = "SELECT first_name, last_name, email, age, dob, contact_number, organization_name FROM "
			+ "EmployeeDetails WHERE email = ?";

	public final static String CHANGE_DETAIL = "UPDATE EmployeeDetails SET first_name = ? , "
			+ "last_name = ? , age = ?, dob = ?, contact_number = ?, organization_name = ?  WHERE email = ? ";

	public final static String LOGIN_EMPLOYEE = "SELECT COUNT(email) as present FROM EmployeeDetails WHERE email = ? AND pwd = ? ";
	
	public final static String SHOW_FRIENDS = "SELECT first_name, last_name, email FROM employeedetails WHERE organization_name = ? AND first_name != ? AND last_name != ?";
	
	public final static String CHECK_DUPLICATE_EMAIL = "SELECT count(email) as present FROM EmployeeDetails WHERE email = ?";
}
