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

	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	public boolean updateProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addProject(Project project) {
		try {
			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Project getProjectById(int id) {
		return projectRepository.findById(id);
	}

}
