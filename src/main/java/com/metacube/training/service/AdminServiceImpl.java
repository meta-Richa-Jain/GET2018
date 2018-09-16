package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class AdminServiceImpl {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	@Autowired
	private JobRepository<Job> jobRepository;

	@Autowired
	private SkillRepository<Skill> skillRepository;

	public boolean addEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	public boolean disableEmployee(int code) {
//		try {
//			return employeeRepository.DisableEmployee(code);
//		} catch (Exception e) {
//			return false;
//		}
//	}

	public boolean addJob(Job job) {
		try {
			jobRepository.save(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	public boolean addSkills(Skill skill) {
//		try {
//			skillRepository.save(skill);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	public List<Job> getAllJob() {
//		return jobRepository.findAll();
//	}
//
//	public List<Skill> getAllSkills() {
//		return skillRepository.findAll();
//	}
//
//	public List<Employee> searchEmployee(String searchBy, String value) {
//		if ("name".equals(searchBy)) {
//			return employeeRepository.findByfirstNameContainingIgnoreeCase(value);
////		} else if ("project".equals(searchBy)) {
////			return adminDao.searchEmployeeByProject(Integer.parseInt(value));
////		} else if ("skills".equals(searchBy)) {
////			return adminDao.searchEmployeeBySkill(value);
////		} else if ("experience".equals(searchBy)) {
////			return adminDao.searchEmployeeByTotalExperience(Integer.parseInt(value));
////		}
//		}
//		return null;
//	}

}
