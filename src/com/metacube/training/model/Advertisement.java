package com.metacube.training.model;

/**
 * Class containing the advertisement entities
 */
public class Advertisement extends BaseEntity {
	
	private String title;
	private String description;
	private int categoryId;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategory_id(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
