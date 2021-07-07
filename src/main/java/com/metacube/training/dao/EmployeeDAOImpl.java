package com.metacube.training.dao;

import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository
public class EmployeeDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean resetPassword(String password, int code) {
		Query query = null;
		try {
			query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE Employee SET password =:password WHERE code =:code");
			query.setParameter("password", password);
			query.setParameter("code", code);

		} catch (Exception e) {
			return false;
		}
		return query.executeUpdate() > 0;
	}

	public boolean updateProfile(Employee employee) {
		Query query = null;
		try {
			query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE Employee SET dob =:dob , primaryContactNo =:primaryContactNo , "
							+ "secondaryContactNo =:secondaryContactNo , skypeId =:skypeId , profilePicture =:profilePicture "
							+ " WHERE code =:code ");
			query.setParameter("dob", employee.getDob());
			query.setParameter("primaryContactNo", employee.getPrimaryContactNo());
			query.setParameter("secondaryContactNo", employee.getSecondaryContactNo());
			query.setParameter("skypeId", employee.getSkypeId());
			query.setParameter("profilePicture", employee.getProfilePicture());
			query.setParameter("code", employee.getCode());
		} catch (Exception e) {
			return false;
		}
		return query.executeUpdate() > 0;
	}

	public Employee getEmployeeByCode(int code) {
		Employee employee = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Employee WHERE code =:code");
			query.setParameter("code", code);
			employee = (Employee) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return employee;
	}

	public Employee getEmployeeByEmail(String email) {
		Employee employee = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Employee WHERE emailId=:email");
			query.setParameter("email", email);
			employee = (Employee) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return employee;
	}

}
