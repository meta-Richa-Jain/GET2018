package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import Model.EmployeeTransferObject;
import Model.Friend;
import dao.MySQLConnectionPool;
import dao.Queries;
import enums.Status;

public class MySQLEmployeeDao implements BaseDao{

	private MySQLConnectionPool dbCon;
	
	private static MySQLEmployeeDao mySQLEmployeeDao = new MySQLEmployeeDao();

	public MySQLEmployeeDao() {
		dbCon = new MySQLConnectionPool();
	}
	
	public static MySQLEmployeeDao getInstance() {
		return mySQLEmployeeDao;
	}

	private Status checkDuplicacy(String email) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.CHECK_DUPLICATE_EMAIL);
			ps.setString(1, email);

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				if (res.getInt("Present") != 0)
					return Status.FOUND;
			}
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.NOT_FOUND;

	}

	public Status checkLoginDetails(String email, String password) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.LOGIN_EMPLOYEE);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				if (res.getInt("present") != 0)
					return Status.FOUND;
			}
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.NOT_FOUND;
	}

	
	public Status addEmployee(Employee emp) {
		Status check = checkDuplicacy(emp.getEmail());
		if (check == Status.FOUND) {
			return Status.FAIL;
		} else {
			Connection con = null;
			try {
				con = dbCon.getAvailableConnection();
				PreparedStatement ps = con.prepareStatement(Queries.ADD_EMPLOYEE);
				ps.setString(1, emp.getFirstName());
				ps.setString(2, emp.getLastName());
				ps.setString(3, emp.getEmail());
				ps.setInt(4, emp.getAge());
				ps.setDate(5, new java.sql.Date((emp.getDob().getTime())));
				ps.setString(6, emp.getContactNumber());
				ps.setString(7, emp.getPassword());
				ps.setString(8, emp.getOrgName());

				int res = ps.executeUpdate();
			} catch (SQLException e) {
				return Status.ERROR;
			} finally {
				dbCon.releaseConnection(con);
			}
			return Status.SUCCESS;
		}
	}

	public List<EmployeeTransferObject> getEmployeeDetails(String email) {
		List<EmployeeTransferObject> employeeDetails = new ArrayList<EmployeeTransferObject>();

		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.SHOW_EMPLOYEE_DETAILS);
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				EmployeeTransferObject emp = new EmployeeTransferObject(res.getString("first_name"), res.getString("last_name"),
						res.getString("email"), res.getInt("age"), res.getDate("dob"), res.getString("contact_number"),
						 res.getString("organization_name"));
				employeeDetails.add(emp);
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return employeeDetails;
	}

	public List<Friend> getFriendsList(String orgName, String firstName, String lastName) {
		List<Friend> friendsList = new ArrayList<Friend>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.SHOW_FRIENDS);
			ps.setString(1, orgName);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Friend friend = new Friend(res.getString("first_name"), res.getString("last_name"),
						res.getString("email"));
				friendsList.add(friend);
			}
		} catch (SQLException e) {
			
		} finally {
			dbCon.releaseConnection(con);
		}
		return friendsList;
	}
	
	public Status editEmployee(EmployeeTransferObject emp) {
		Connection con = null;
		try{
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.CHANGE_DETAIL);
			ps.setString(1,  emp.getFirstName());
			ps.setString(2,  emp.getLastName());
			ps.setInt(3,  emp.getAge());
			ps.setDate(4, (Date) emp.getDob());
			ps.setString(5, emp.getContactNumber());
			ps.setString(6, emp.getOrgName());
			ps.executeUpdate();
		} catch(SQLException e){
			return Status.FAIL;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.SUCCESS;
	}

}
