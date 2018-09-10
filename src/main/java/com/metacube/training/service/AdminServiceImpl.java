package com.metacube.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.dao.AdminDAOImpl;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

@Service
public class AdminServiceImpl {

	private AdminDAOImpl adminDao = AdminDAOImpl.getInstance();

	public boolean addEmployee(Employee employee) {
		return adminDao.addEmployee(employee);
	}

	public boolean disableEmployee(String empCode) {
		return adminDao.disableEmployee(empCode);
	}

	public boolean addJob(String title) {
		return adminDao.addJob(title);
	}

	public boolean addSkills(String name) {
		return adminDao.addSkill(name);
	}

	public List<Job> getAllJob() {
		return adminDao.getAllJob();
	}

	public List<Skill> getAllSkills() {
		return adminDao.getAllSkills();
	}

	public List<EmployeeDTO> getEmployeeByEmpCode(int code) {
		return adminDao.getEmployeeByEmpCode(code);
	}

	public List<EmployeeDTO> getEmployeeByName(String name) {
		return adminDao.getEmployeeByName(name);
	}

}
