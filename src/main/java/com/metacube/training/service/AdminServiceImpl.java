package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.AdminDAOImpl;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

@Service
public class AdminServiceImpl {

	@Autowired
	private AdminDAOImpl adminDao;

	public boolean addEmployee(Employee employee) {
		return adminDao.addEmployee(employee);
	}

	public boolean disableEmployee(String empCode) {
		return adminDao.deleteEmployee(empCode);
	}

	public boolean addJob(String title) {
		return adminDao.addJob(title);
	}

	public boolean addSkills(String name) {
		return adminDao.addSkill(name);
	}

	public List<Job> getAllJob() {
		return adminDao.getAllJobs();
	}

	public List<Skill> getAllSkills() {
		return adminDao.getAllSkills();
	}

	
	public List<EmployeeDTO> searchEmployee(String searchBy, String value){
		if("name".equals(searchBy)) {
			return adminDao.searchEmployeeByName(value);
		} else if("project".equals(searchBy)) {
			return adminDao.searchEmployeeByProject(Integer.parseInt(value));
		} else if("skills".equals(searchBy)) {
			return adminDao.searchEmployeeBySkill(value);
		} else if("experience".equals(searchBy)) {
			return adminDao.searchEmployeeByTotalExperience(Integer.parseInt(value));
		}
		return null;
	}
	

}
