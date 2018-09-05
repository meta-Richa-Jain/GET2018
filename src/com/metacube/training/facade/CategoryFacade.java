package com.metacube.training.facade;

import java.util.List;

import com.metacube.training.dao.BaseDao;
import com.metacube.training.dao.CategoryDao;
import com.metacube.training.enums.Status;
import com.metacube.training.model.Category;

/**
 * Facade class for Category
 */
public class CategoryFacade {

	private static CategoryFacade categoryFacade = new CategoryFacade();

	BaseDao<Category> categoryDao = CategoryDao.getInstance();

	/**
	 * Method to create singleton object
	 * 
	 * @return object
	 */
	public static CategoryFacade getInstance() {
		return categoryFacade;
	}

	/**
	 * Function to return status for insertion
	 * 
	 * @param name
	 *            name of category to be inserted
	 * @return status status of operation
	 */
	public Status insertCategory(String name) {
		List<Category> categoryList = categoryDao.getAll();

		for (Category category : categoryList) {
			if (category.getName().equals(name)) {
				return Status.DUPLICATE;
			}
		}
		return ((CategoryDao) categoryDao).insert(name);
	}

	/**
	 * Function to return the list of category
	 * 
	 * @return list of all categories
	 */
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	/**
	 * Function to return the status for updated
	 * 
	 * @param category
	 *            category name
	 * @param id
	 *            category id
	 * @return status status of operation
	 */
	public Status updateCategory(Category category) {
		return ((CategoryDao) categoryDao).updateCategory(category);
	}
}
