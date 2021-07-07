package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Login;

public class LoginMapper implements RowMapper<Login> {

	public Login mapRow(ResultSet resultSet, int i) throws SQLException {

		Login login = new Login();
		login.setEmpCode(resultSet.getInt("code"));
		login.setPassword(resultSet.getString("password"));

		return login;

	}
}
