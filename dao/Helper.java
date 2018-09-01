package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import enums.Status;

public class Helper {

	private MySQLConnectionPool dbCon;

	public Helper() {
		dbCon = new MySQLConnectionPool();
	}

	public Status checkDuplicacy(String email) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(Queries.CHECK_DUPLICATE_EMAIL);
			ps.setString(1, email);

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				if (res.getInt("Present") != 0)
					return Status.FOUND;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.NOT_FOUND;

	}

	public Status checkEmail(String email, String password) {
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
			e.printStackTrace();
		} finally {
			dbCon.releaseConnection(con);
		}
		System.out.println("BYE");
		return Status.NOT_FOUND;
	}

	// image ??
	public Status addEmployee(Employee emp) {
		Status check = checkDuplicacy(emp.getEmail());
		if (check == Status.FOUND) {
			return Status.DUPLICATE;
		} else {
			Connection con = null;
			try {
				con = dbCon.getAvailableConnection();
				PreparedStatement ps = con
						.prepareStatement(Queries.ADD_EMPLOYEE);
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
				return Status.FAIL;
			} finally {
				dbCon.releaseConnection(con);
			}
			return Status.SUCCESS;
		}
	}

	public List<Employee> getEmployeeDetails(String email) {
		List<Employee> employeeDetails = new ArrayList<Employee>();

		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(Queries.SHOW_EMPLOYEE_DETAILS);
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Employee emp = new Employee(res.getString("first_name"),
						res.getString("last_name"), res.getString("email"),
						res.getInt("age"), res.getDate("dob"),
						res.getString("contact_number"), res.getString("pwd"),
						res.getString("organization_name"));
				employeeDetails.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.releaseConnection(con);
		}
		return employeeDetails;
	}

	public static void main(String[] args) {
		Helper h = new Helper();
		System.out.println(h.checkEmail("richa@gmail.com", "richa"));
		
		List<Employee> ls = h.getEmployeeDetails("richa@gmail.com");
		Employee e = ls.get(0);
		System.out.println(e.getFirstName() + " " + e.getLastName());

	}

}
