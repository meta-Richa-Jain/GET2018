package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class AdminDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().save(employee);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean addSkill(Skill skill) {
		try {
			sessionFactory.getCurrentSession().save(skill);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Job> getAllJobs() {
		List<Job> jobsList = new ArrayList<>();
		try {
			TypedQuery<Job> query = sessionFactory.getCurrentSession().createQuery("from Job");
			jobsList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return jobsList;
	}

	@SuppressWarnings("unchecked")
	public List<Skill> getAllSkills() {
		List<Skill> skillsList = new ArrayList<>();
		try {
			TypedQuery<Skill> query = sessionFactory.getCurrentSession().createQuery("from Skill");
			skillsList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return skillsList;
	}

	public boolean deleteEmployee(int code) {
		Query query = null;
		try {
			query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE Employee SET enabled ='false' WHERE code =:code");
			query.setParameter("code", code);

		} catch (Exception e) {
			return false;
		}
		return query.executeUpdate() > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployeeByName(String firstName) {
		List<Employee> employeeList = new ArrayList<>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("FROM Employee WHERE  firstName =: firstName");
			query.setParameter("firstName", firstName);
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployeeByProject(int id) {
		List<Employee> employeeList = new ArrayList<>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("CALL getEmployeeByProject(:id)");
			query.setParameter("id", id);
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployeeByTotalExperience(int exp) {
		List<Employee> employeeList = new ArrayList<>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("CALL getEmployeeByExperience(:exp)");
			query.setParameter("exp", exp);
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployeeBySkill(String name) {
		List<Employee> employeeList = new ArrayList<>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("CALL getEmployeeBySkill(:name)");
			query.setParameter("name", name);
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

}
