package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {
	
	/**
	 * Method to return the project details of the given project id
	 * @param id
	 * @return
	 */
	Project findById(int id);
	
}
