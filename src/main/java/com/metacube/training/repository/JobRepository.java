package com.metacube.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Job;

@Repository
@Transactional
public interface JobRepository<J> extends JpaRepository<Job, Integer> {

	Job findByCode(int code);
	
	Job findByTitle(String title);
	
}
