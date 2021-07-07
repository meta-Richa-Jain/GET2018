package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.ProjectDAOImpl;
import com.metacube.training.model.Project;

@Service
public class ProjectServiceImpl {

	@Autowired
	private ProjectDAOImpl projectDAO;
	

	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	public boolean updateProject(Project project) {
		return projectDAO.updateProject(project);
	}

	public boolean addProject(Project project) {
		
		return projectDAO.addProject(project);
	}

	
}
