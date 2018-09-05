package com.metacube.training.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.training.database.ConnectionPool;
import com.metacube.training.database.Query;
import com.metacube.training.enums.Status;
import com.metacube.training.model.Category;

/**
 * CategoryDao is for performing insertion , deletion and update operations on
 * category table
 */
public class CategoryDao implements BaseDao<Category> {

	private static BaseDao<Category> mysqlCategoryDao = new CategoryDao();
	private ConnectionPool dbCon = new ConnectionPool();

	public static BaseDao<Category> getInstance() {
		return mysqlCategoryDao;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<Category>();
		Connection con = null;
		try {
			String query = Query.GET_ALL_CATEGORIES;
			ResultSet resultSet = null;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				categoryList.add(category);
			}

		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return categoryList;

	}

	/**
	 * Method to insert new category into database
	 * 
	 * @param name of the category
	 */
	public Status insert(String name) {
		Connection con = null;
		try {
			String query = Query.INSERT_NEW_CATEGORY;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.INSERTED;

	}

	/**
	 * Method to update category name
	 * 
	 * @param categoryName, name of the category
	 * @param id, id of the category
	 */
	public Status updateCategory(Category category) {
		Connection con = null;
		try {
			String query = Query.UPDATE_CATEGORY;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.UPDATED;

	}

}
