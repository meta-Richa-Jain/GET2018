package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Job;
import com.metacube.training.model.JobDetails;
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
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("from Employee");
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<Job> getAllJobs() {
		List<Job> jobsList = new ArrayList<Job>();
		try {
			TypedQuery<Job> query = sessionFactory.getCurrentSession()
					.createQuery("from Job");
			jobsList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return jobsList;
	}

	@SuppressWarnings("unchecked")
	public List<Skill> getAllSkills() {
		List<Skill> skillsList = new ArrayList<Skill>();
		try {
			TypedQuery<Skill> query = sessionFactory.getCurrentSession()
					.createQuery("from Skill");
			skillsList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return skillsList;
	}

	public boolean deleteEmployee(int code) {
		Query query = null;
		try {
			query = sessionFactory.getCurrentSession().createQuery(
					"UPDATE Employee SET enabled ='false' WHERE code =:code");
			query.setParameter("code", code);

		} catch (Exception e) {
			return false;
		}
		return query.executeUpdate() > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> searchEmployeeByName(String firstName) {
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			TypedQuery<Employee> query = sessionFactory.getCurrentSession()
					.createQuery("FROM Employee WHERE  firstName =:firstName");
			query.setParameter("firstName", firstName);
			employeeList = query.getResultList();
		} catch (Exception e) {
			return null;
		}
		return employeeList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> searchEmployeeByProject(int id) {
		List<Employee> employeeList = new ArrayList<Employee>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class, "jobDetails");
		c.createAlias("jobDetails.empCode", "employee");
		c.add(Restrictions.like("jobDetails.projectId", id));
		c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		for (Object jobDetails : c.list()) {
			JobDetails j = (JobDetails) jobDetails;
			employeeList.add(j.getEmpCode());
		}
		/*
		 * try { System.out.println("CALL PROCS"); TypedQuery<Employee> query =
		 * sessionFactory.getCurrentSession()
		 * .createQuery("CALL getEmployeeByProject(:id)");
		 * query.setParameter("id", id); employeeList = query.getResultList();
		 * System.out.println("BYE");
		 * System.out.println(employeeList.get(0).getCode()); } catch (Exception
		 * e) { return null; }
		 */
		return employeeList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> searchEmployeeByTotalExperience(int exp) {
		List<Employee> employeeList = new ArrayList<Employee>();
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				JobDetails.class, "jobDetails");
		c.createAlias("jobDetails.empCode", "employee");
		c.add(Restrictions.like("jobDetails.totalExp", exp));
		c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		for (Object jobDetails : c.list()) {
			JobDetails j = (JobDetails) jobDetails;
			employeeList.add(j.getEmpCode());
		}
		/*
		 * try { TypedQuery<Employee> query = sessionFactory.getCurrentSession()
		 * .createQuery("CALL getEmployeeByExperience(:exp)");
		 * query.setParameter("exp", exp); employeeList = query.getResultList();
		 * } catch (Exception e) { return null; }
		 */
		return employeeList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Employee> searchEmployeeBySkill(String name) {
		List<Employee> employeeList = new ArrayList<Employee>();

		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				EmployeeSkills.class, "employee");
		c.createAlias("employee.skillCode", "skill");
		c.add(Restrictions.like("skill.name", name + "%"));
		c = c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		for (Object empSkill : c.list()) {
			EmployeeSkills es = (EmployeeSkills) empSkill;
			employeeList.add(es.getEmpCode());
		}
		/*
		 * try { TypedQuery<Employee> query = sessionFactory.getCurrentSession()
		 * .createQuery("CALL getEmployeeBySkill(:name)");
		 * query.setParameter("name", name); employeeList =
		 * query.getResultList(); } catch (Exception e) { return null; }
		 */
		return employeeList;
	}

}
