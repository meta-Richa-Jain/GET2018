package com.Database;

public class Queries {

	public final static String INSERT_EMPLOYEE = "INSERT INTO EmployeeDetails(first_name, last_name, email, age) "
			+ "VALUES (?,?,?,?)";

	public final static String SHOW_EMPLOYEE = "SELECT first_name, last_name, email, age FROM "
			+ "EmployeeDetails";

	public final static String SEARCH_EMPLOYEE = "SELECT first_name, last_name , email, age FROM EmployeeDetails "
			+ "WHERE concat(first_name, ' ', last_name) LIKE concat('%', ? , '%')";
	
	public final static String CHANGE_DETAIL = "UPDATE EmployeeDetails SET first_name = ? , "
			+ "last_name = ? , age = ?  WHERE email = ? ";
}
