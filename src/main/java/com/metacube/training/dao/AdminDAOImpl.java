package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.EmployeeDTOMapper;
import com.metacube.training.mappers.JobMapper;
import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeDTO;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

@Repository
public class AdminDAOImpl {

	private static final String ADD_EMPLOYEE = "INSERT INTO employee ( first_name, last_name, email_id, dob, gender,password)"
			+ " VALUES (?,?,?,?,?,?)";

	private static final String DISABLE_EMPLOYEE = "UPDATE employee SET enabled = 'false' WHERE code = ? ";

	private static final String ADD_SKILL = "INSERT INTO skills (name) VALUES (?)";

	private static final String ADD_JOB = "INSERT INTO job_title_master (title) VALUES (?)";

	private static final String GET_JOB = "SELECT * FROM job_title_master";

	private static final String GET_SKILLS = "SELECT * FROM skills";

	private static final String SEARCH_EMPLOYEE_BY_NAME = "SELECT  ( first_name, last_name, email_id, dob, gender) FROM employee WHERE concat(first_name, ' ', last_name) LIKE concat('%', ? , '%')";

	private static final String SEARCH_EMPLOYEE = "SELECT * FROM employee WHERE code = ?";

	private static final String SEARCH_EMPLOYEE_BY_PROJECT = "SELECT  ( first_name, last_name, email_id, dob, gender) FROM employee AS e INNER JOIN "
			+ "job_details j ON j.emp_code = e.code INNER JOIN project p ON p.id = j.curr_proj_id WHERE p.id = ? ";

	private static final String SEARCH_EMPLOYEE_BY_TOTAL_EXPERIENCE = "SELECT  ( first_name, last_name, email_id, dob, gender) FROM employee AS e INNER JOIN "
			+ "job_details j on e.code = j.emp_code WHERE j.total_exp = ? AND e.enabled = 'true' ";

	private static final String SEARCH_EMPLOYEE_BY_SKILL = "SELECT  ( first_name, last_name, email_id, dob, gender) FROM employee AS e INNER JOIN "
			+ "employee_skills es ON es.emp_code = e.code INNER JOIN skills s ON s.id = es.skill_code WHERE s.anme = ? ";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addEmployee(Employee employee) {
		return jdbcTemplate.update(ADD_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getEmailId(),
				employee.getDob(), employee.getGender(), employee.getPassword()) > 0;
	}

	public boolean addSkill(String name) {
		return jdbcTemplate.update(ADD_SKILL, name) > 0;
	}

	public boolean addJob(String title) {
		return jdbcTemplate.update(ADD_JOB, title) > 0;
	}

	public List<Job> getAllJobs() {
		return jdbcTemplate.query(GET_JOB, new JobMapper());
	}

	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(GET_SKILLS, new SkillMapper());
	}

	public boolean deleteEmployee(String code) {
		return jdbcTemplate.update(DISABLE_EMPLOYEE, code) > 0;

	}

	public List<EmployeeDTO> searchEmployeeByName(String name) {
		return jdbcTemplate.query(SEARCH_EMPLOYEE_BY_NAME, new Object[] { name }, new EmployeeDTOMapper());
	}

	public List<EmployeeDTO> searchEmployeeByProject(int id) {
		return jdbcTemplate.query(SEARCH_EMPLOYEE_BY_PROJECT, new Object[] { id }, new EmployeeDTOMapper());
	}

	public List<EmployeeDTO> searchEmployeeByTotalExperience(int exp) {
		return jdbcTemplate.query(SEARCH_EMPLOYEE_BY_TOTAL_EXPERIENCE, new Object[] { exp }, new EmployeeDTOMapper());
	}

	public List<EmployeeDTO> searchEmployeeBySkill(String name) {
		return jdbcTemplate.query(SEARCH_EMPLOYEE_BY_SKILL, new Object[] { name }, new EmployeeDTOMapper());
	}

}
