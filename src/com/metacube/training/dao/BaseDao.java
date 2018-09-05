package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
	
	/**
	 * Method to return the list of T objects
	 * @return list
	 */
	public List<T> getAll();
	

}
