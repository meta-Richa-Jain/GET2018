package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.metacube.training.model.Employee;

public class EmployeeDAOImpl {

	private static final String RESET_PASSWORD = "UPDATE employee SET password = ? WHERE emp_code = ? ";

	private static final String UPDATE_PROFILE = "UPDATE employee SET dob = ? , primary_contact_no = ? , "
			+ "secondary_contact_no = ? , skype_id = ? , profile_picture = ? WHERE emp_code = ? ";

	private ConnectionPool dbCon = new ConnectionPool();

	private static EmployeeDAOImpl employeeDao = new EmployeeDAOImpl();

	public static EmployeeDAOImpl getInstance() {
		return employeeDao;
	}

	public boolean resetPassword(String empCode, String password) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(RESET_PASSWORD);
			ps.setString(1, password);
			ps.setString(2, empCode);
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}

	public boolean updateProfile(Employee employee) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_PROFILE);
			ps.setDate(1, (Date) employee.getDob());
			ps.setString(2, employee.getPrimaryContactNo());
			ps.setString(3, employee.getSecondaryContactNo());
			ps.setString(4, employee.getSkypeId());
			ps.setString(5, employee.getProfilePicture());
			ps.setInt(6, employee.getEmpCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}

}
