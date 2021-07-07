package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAOImpl;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Login;

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
	
	public Login checkLoginDetails(int code){
		return employeeDao.checkLoginDetails(code);
	}
	
	public Employee showProfile(int code) {
		return employeeDao.showProfile(code);
	}
	
	
}
