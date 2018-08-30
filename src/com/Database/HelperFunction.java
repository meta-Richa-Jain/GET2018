package com.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.POJO.Employee;

public class HelperFunction {

	private ConnectionPool dbCon;

	public HelperFunction() {
		dbCon = new ConnectionPool();
	}

	public void addEmployee(Employee emp) throws SQLException {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(Queries.INSERT_EMPLOYEE);
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getEmail());
			ps.setInt(4, emp.getAge());

			int res = ps.executeUpdate();

		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			dbCon.releaseConnection(con);
		}

	}

	public List<Employee> showEmployeeDetails() throws SQLException {
		List<Employee> employeeDetails = new ArrayList<Employee>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.SHOW_EMPLOYEE);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Employee emp = new Employee(res.getString("first_name"),
						res.getString("last_name"), res.getString("email"),
						res.getInt("age"));
				employeeDetails.add(emp);
			}
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			dbCon.releaseConnection(con);
		}
		return employeeDetails;
	}
	
	public List<Employee> searchEmployee(String name) throws SQLException{
		List<Employee> searchDetails = new ArrayList<Employee>();
		Connection con = null;
		try{
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.SEARCH_EMPLOYEE);
			ps.setString(1, name);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				Employee emp = new Employee(res.getString("first_name"), res.getString("last_name"), 
						res.getString("email"), res.getInt("age"));
				searchDetails.add(emp);
			}
		} catch(SQLException e){
			throw new SQLException();
		} finally{
			dbCon.releaseConnection(con);
		}
		return searchDetails;
	}
	
	public void UpdateEmployeeDetails(Employee emp) throws SQLException{
		Connection con = null;
		try{
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(Queries.CHANGE_DETAIL);
			ps.setString(1,  emp.getFirstName());
			ps.setString(2,  emp.getLastName());
			ps.setString(4,  emp.getEmail());
			ps.setInt(3,  emp.getAge());
			
			ps.executeUpdate();
		} catch(SQLException e){
			throw new SQLException();
		} finally {
			dbCon.releaseConnection(con);
		}
	}

}
