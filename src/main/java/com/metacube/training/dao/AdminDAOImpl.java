package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

public class AdminDAOImpl {

	private static final String ADD_EMPLOYEE = "INSERT INTO employee ( first_name, last_name, email_id, dob, gender,password)"
			+ " VALUES (?,?,?,?,?,?)";

	private static final String ADD_EMPLOYEE_JOB_DETAIL = "INSERT INTO job_details (code, date_of_joining, total_exp,"
			+ "job_code, reporting_mgr, team_lead, curr_proj_id VALUES (?,?,?,?,?,?,?)";

	private static final String DISABLE_EMPLOYEE = "UPDATE employee SET enabled = 'false' WHERE code = ? ";

	private static final String ADD_SKILL = "INSERT INTO skills (name) VALUES (?)";

	private static final String ADD_JOB = "INSERT INTO job_title_master (title) VALUES (?)";

	private static final String GET_JOB = "SELECT * FROM job_title_master";

	private static final String GET_SKILLS = "SELECT * FROM skills";

	private static final String SEARCH_EMPLOYEE_BY_NAME = "SELECT  ( first_name, last_name, email_id, dob, gender) FROM employee WHERE concat(first_name, ' ', last_name) LIKE concat('%', ? , '%')";

	private static final String SEARCH_EMPLOYEE = "SELECT * FROM employee WHERE code = ?";
			
	private ConnectionPool dbCon = new ConnectionPool();

	private static AdminDAOImpl adminDao = new AdminDAOImpl();

	public static AdminDAOImpl getInstance() {
		return adminDao;
	}

	public boolean addEmployee(Employee employee) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(ADD_EMPLOYEE);
			ps.setInt(1, employee.getEmpCode());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getEmailId());
			ps.setDate(5, (Date) employee.getDob());
			ps.setString(6, employee.getGender());
			ps.setString(7, employee.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;

	}

	public boolean disableEmployee(String empCode) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(DISABLE_EMPLOYEE);
			ps.setString(1, empCode);
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;

	}

	public boolean addSkill(String name) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(ADD_SKILL);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
		return true;
	}

	public boolean addJob(String title) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(ADD_JOB);
			ps.setString(1, title);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			dbCon.releaseConnection(con);
		}
	}

	public List<Skill> getAllSkills() {
		List<Skill> skillsList = new ArrayList<Skill>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(GET_SKILLS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Skill skill = new Skill();
				skill.setId(rs.getInt("id"));
				skill.setName(rs.getString("name"));
				skillsList.add(skill);
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return skillsList;
	}

	public List<Job> getAllJob() {
		List<Job> jobList = new ArrayList<Job>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(GET_JOB);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Job job = new Job();
				job.setCode(rs.getInt("code"));
				job.setTitle(rs.getString("title"));
				jobList.add(job);
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return jobList;
	}
	
	public List<EmployeeDTO> getEmployeeByName(String name) {
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDTO employee = new EmployeeDTO();
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setEmailId(rs.getString("email_id"));
				employee.setDob(rs.getDate("dob"));
				employee.setGender(rs.getString("gender"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return employeeList;
	}
	
	public List<EmployeeDTO> getEmployeeByEmpCode(int code) {
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con.prepareStatement(SEARCH_EMPLOYEE);
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeeDTO employee = new EmployeeDTO();
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setEmailId(rs.getString("email_id"));
				employee.setDob(rs.getDate("dob"));
				employee.setGender(rs.getString("gender"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return employeeList;
	}
}
