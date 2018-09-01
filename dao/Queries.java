package dao;

public class Queries {

	public final static String ADD_EMPLOYEE = "INSERT INTO EmployeeDetails(first_name, last_name, email, age, dob, contact_number, pwd, organization_name)"
			+ "VALUES (?,?,?,?,?,?,?,?)";

	public final static String SHOW_EMPLOYEE_DETAILS = "SELECT first_name, last_name, email, age, dob, contact_number, pwd, organization_name FROM "
			+ "EmployeeDetails WHERE email = ?";

	public final static String SEARCH_EMPLOYEE = "SELECT first_name, last_name , email, age FROM EmployeeDetails "
			+ "WHERE concat(first_name, ' ', last_name) LIKE concat('%', ? , '%')";

	public final static String CHANGE_DETAIL = "UPDATE EmployeeDetails SET first_name = ? , "
			+ "last_name = ? , age = ?  WHERE email = ? ";

	public final static String LOGIN_EMPLOYEE = "SELECT COUNT(email) as present FROM EmployeeDetails WHERE email = ? AND pwd = ? ";
	
	public final static String CHECK_DUPLICATE_EMAIL = "SELECT count(email) as present FROM EmployeeDetails WHERE email = ?";
}
