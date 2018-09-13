package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.EmployeeDTO;

public class EmployeeDTOMapper implements RowMapper<EmployeeDTO> {

	public EmployeeDTO mapRow(ResultSet resultSet, int i) throws SQLException {
		EmployeeDTO employee = new EmployeeDTO();
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setLastName(resultSet.getString("last_name"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		return employee;
	}

}

