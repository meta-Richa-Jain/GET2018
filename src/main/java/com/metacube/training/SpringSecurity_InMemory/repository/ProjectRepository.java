package com.metacube.training.SpringSecurity_InMemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.SpringSecurity_InMemory.model.Project;


@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {
	
	/**
	 * Method to return the project details of the given project id
	 * @param id
	 * @return
	 */
	public Project findById(int id);
	
}
