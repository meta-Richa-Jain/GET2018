package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addProject(Project person) {
		try {
			sessionFactory.getCurrentSession().save(person);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		List<Project> projectsList = new ArrayList<>();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Project");
			projectsList = query.getResultList();
		} catch (Exception e) {
			return projectsList;
		}
		return projectsList;
	}

	public Project getProjectById(int id) {
		Project project = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Project WHERE id=:id");
			query.setParameter("id", id);
			project = (Project) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return project;
	}

	public boolean updateProject(Project project) {
		Query query = null;
		try {
			query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE Project SET description =:description , startDate =:startDate , "
							+ "endDate =:endDate , projectLogo =:projectLogo ," + " WHERE id =:id ");
			query.setParameter("description", project.getDescription());
			query.setParameter("startDate", project.getStartDate());
			query.setParameter("endDate", project.getEndDate());
			query.setParameter("projectLogo", project.getProjectLogo());
		} catch (Exception e) {
			return false;
		}
		return query.executeUpdate() > 0;
	}
}