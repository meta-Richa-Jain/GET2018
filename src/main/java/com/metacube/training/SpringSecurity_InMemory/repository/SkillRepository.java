package com.metacube.training.SpringSecurity_InMemory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.SpringSecurity_InMemory.model.Skill;


public interface SkillRepository<S> extends JpaRepository<Skill, Integer> {

	/**
	 * Method to return the skill details of the given skill id
	 * @param id
	 * @return
	 */
	public Skill findById(int id);

	/**
	 * Method to return the skill details with the given skill name
	 * @param name
	 * @return
	 */
	public Skill findByName(String name);

}
