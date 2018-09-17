package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl {

	@Autowired
	private ProjectRepository<Project> projectRepository;

	/**
	 * Method to get the list of all the projects
	 * @return
	 */
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	/**
	 * Method to update the project details
	 * @param project
	 * @return
	 */
	public boolean updateProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to add project to the project table
	 * @param project
	 * @return
	 */
	public boolean addProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Method to get the project details of the project with the given project id
	 * @param id
	 * @return
	 */
	public Project getProjectById(int id) {
		return projectRepository.findById(id);
	}

}
