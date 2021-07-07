package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeServiceImpl employeeDao;

	public boolean resetPassword(String empCode, String password) {
		return employeeDao.resetPassword(empCode, password);
	}

	public boolean updateProfile(Employee employee) {
		return employeeDao.updateProfile(employee);
	}

}
