package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	/**
	 * Method to reset the password of an employee
	 * @param password
	 * @param code
	 * @return
	 */
	public boolean resetPassword(String password, int code) {
		try {
			return employeeRepository.setPasswordFor(password, code);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to update the profile of an employee
	 * @param employee
	 * @return
	 */
	public boolean updateProfile(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to check the login details of an employee
	 * @param code
	 * @return
	 */
	public Employee checkLoginDetails(int code) {
		return employeeRepository.findByCode(code);
	}

	/**
	 * Method to get the employee details of an employee with the given email id 
	 * @param emailId
	 * @return
	 */
	public Employee getEmployeeByEmail(String emailId) {
		return employeeRepository.findByEmailId(emailId);
	}

	/**
	 * Method to get the employee details of an employee with the given employee code
	 * @param code
	 * @return
	 */
	public Employee getEmployeeByCode(int code) {
		return employeeRepository.findByCode(code);
	}

}
