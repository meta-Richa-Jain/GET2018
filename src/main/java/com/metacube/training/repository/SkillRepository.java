package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Skill;

public interface SkillRepository<S> extends JpaRepository<Skill, Integer> {

	/**
	 * Method to return the skill details of the given skill id
	 * @param id
	 * @return
	 */
	Skill findById(int id);

	/**
	 * Method to return the skill details with the given skill name
	 * @param name
	 * @return
	 */
	Skill findByName(String name);

}
