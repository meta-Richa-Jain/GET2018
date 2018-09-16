package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

//	public boolean resetPassword(String password, int code) {
//		try {
//			return employeeRepository.setPasswordFor(password, code);
//		} catch (Exception e) {
//			return false;
//		}
//	}

	public boolean updateProfile(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Employee checkLoginDetails(int code) {
		return employeeRepository.findByCode(code);
	}

	public Employee getEmployeeByEmail(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}

	public Employee getEmployeeByCode(int code) {
		return employeeRepository.findByCode(code);
	}

}
