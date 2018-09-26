package com.metacube.training.EAD_EmployeePortal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EAD_EmployeePortal.models.Job;

@Repository
@Transactional
public interface JobRepository<J> extends JpaRepository<Job, Integer> {

	/**
	 * Method to return the job details of the given job code
	 * @param code
	 * @return
	 */
	Job findByCode(int code);
	
	/**
	 * Method to return the job details of the given job title
	 * @param title
	 * @return
	 */
	Job findByTitle(String title);
	
}
