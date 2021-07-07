package com.metacube.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeDTOMapper;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.LoginMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Login;

@Repository
public class EmployeeDAOImpl {

	private static final String RESET_PASSWORD = "UPDATE employee SET password = ? WHERE code = ? ";

	private static final String UPDATE_PROFILE = "UPDATE employee SET dob = ? , primary_contact_no = ? , "
			+ "secondary_contact_no = ? , skype_id = ? , profile_picture = ? WHERE code = ? ";

	private static final String LOGIN_DETAILS = "SELECT code, password FROM employee WHERE code = ? ";

	private static final String SHOW_PROFILE = "SELECT code, first_name, last_name, dob, gender, primary_contact_no,"
			+ "secondary_contact_no, email_id, skype_id, profile_picture, password where code = ?";

	private static final String GET_EMPLOYEE_BY_EMAIL = "SELECT first_name, last_name, email_id, dob, gender FROM employee WHERE email_id = ? ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean resetPassword(String password, int code) {
		return jdbcTemplate.update(RESET_PASSWORD, password, code) > 0;

	}

	public boolean updateProfile(Employee employee) {
		return jdbcTemplate.update(UPDATE_PROFILE, employee.getDob(), employee.getPrimaryContactNo(),
				employee.getSecondaryContactNo(), employee.getSkypeId(), employee.getProfilePicture(),
				employee.getCode()) > 0;
	}

	public Login checkLoginDetails(int code) {
		return jdbcTemplate.queryForObject(LOGIN_DETAILS, new Object[] { code }, new LoginMapper());
	}

	public Employee showProfile(int code) {
		return jdbcTemplate.queryForObject(SHOW_PROFILE, new EmployeeMapper());
	}

	public EmployeeDTO getEmployeeByEmail(String email) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_EMAIL, new Object[] { email }, new EmployeeDTOMapper());
	}

}
