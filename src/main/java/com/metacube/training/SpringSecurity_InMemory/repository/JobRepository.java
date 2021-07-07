package com.metacube.training.SpringSecurity_InMemory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.SpringSecurity_InMemory.model.Job;



@Repository
@Transactional
public interface JobRepository<J> extends JpaRepository<Job, Integer> {

	/**
	 * Method to return the job details of the given job code
	 * @param code
	 * @return
	 */
	public Job findByCode(int code);
	
	/**
	 * Method to return the job details of the given job title
	 * @param title
	 * @return
	 */
	public Job findByTitle(String title);
	
}
