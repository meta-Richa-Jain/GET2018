package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAOImpl;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOImpl employeeDao;

	public boolean resetPassword(String password, int code) {
		return employeeDao.resetPassword(password, code);
	}

	public boolean updateProfile(Employee employee) {
		return employeeDao.updateProfile(employee);
	}

	public Employee checkLoginDetails(int code) {
		return employeeDao.getEmployeeByCode(code);
	}

	public Employee getEmployeeByEmail(String email) {
		return employeeDao.getEmployeeByEmail(email);
	}

	public Employee getEmployeeByCode(int code) {
		return employeeDao.getEmployeeByCode(code);
	}

}
