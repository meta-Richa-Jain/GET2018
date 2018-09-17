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

	/**
	 * Method to add employee details to the employee table
	 * @param employee
	 * @return
	 */
	public boolean addEmployee(Employee employee) {
		try {
			employeeRepository.save(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to disable an employee
	 * @param code
	 * @return
	 */
	public boolean disableEmployee(int code) {
		try {
			return employeeRepository.DisableEmployee(code);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to add job to the job table
	 * @param job
	 * @return
	 */
	public boolean addJob(Job job) {
		try {
			jobRepository.save(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to add skill details to the skill table
	 * @param skill
	 * @return
	 */
	public boolean addSkills(Skill skill) {
		try {
			skillRepository.save(skill);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to get the list of all the jobs
	 * @return
	 */
	public List<Job> getAllJob() {
		return jobRepository.findAll();
	}

	/**
	 * Method to get the list of all the skills
	 * @return
	 */
	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	/**
	 * Method to search employees by first name and total experience
	 * @param searchBy
	 * @param value
	 * @return
	 */
	public List<Employee> searchEmployee(String searchBy, String value) {
		if ("name".equals(searchBy)) {
			return employeeRepository.findByFirstNameContainingIgnoreCase(value);
		} else if ("experience".equals(searchBy)) {
			return employeeRepository.searchEmployeeByTotalExperience(Integer.parseInt(value));
		}
		return null;
	}

}
