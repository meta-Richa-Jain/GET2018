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
import com.metacube.training.model.Advertisement;

/**
 * AdvertisementDao is for performing different operations like insertion ,
 * deletion and update operations on advertisement table
 */
public class AdvertisementDao implements BaseDao<Advertisement> {
	private static BaseDao<Advertisement> mysqlAdvertisementDao = new AdvertisementDao();
	private ConnectionPool dbCon = new ConnectionPool();

	public static BaseDao<Advertisement> getInstance() {
		return mysqlAdvertisementDao;
	}

	@Override
	public List<Advertisement> getAll() {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();

		Connection con = null;
		try {
			String queryString = Query.GET_ALL_ADVERTISMENT;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Advertisement advertisement = new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return advertisementList;
	}

	/**
	 * Method to insert new advertisement into database
	 * 
	 * @param advertisement
	 * @return status
	 */
	public Status insert(Advertisement advertisement) {

		Connection con = null;
		try {
			String queryString = Query.INSERT_NEW_ADVERTISEMENT;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, advertisement.getTitle());
			preparedStatement.setString(2, advertisement.getDescription());
			preparedStatement.setInt(3, advertisement.getCategoryId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.INSERTED;

	}

	/**
	 * Method to update name of the advertisement
	 * 
	 * @param    name, new name of the advertisement
	 * @param id of the advertisement
	 */
	public Status updateName(String name, int id) {

		Connection con = null;
		try {
			String queryString = Query.UPDATE_ADVERTISEMENT_NAME;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.UPDATED;

	}

	/**
	 * Method to delete the advertisement
	 * 
	 * @param id of the advertisement
	 * @return status
	 */
	public Status deleteAdvertisement(int id) {

		Connection con = null;
		try {
			String queryString = Query.DELETE_ADVERTISEMENT;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | AssertionError e) {
			return Status.ERROR;
		} finally {
			dbCon.releaseConnection(con);
		}
		return Status.DELETED;

	}

	/**
	 * Method to return the list of all the advertisements of a particular category
	 * 
	 * @param id of the category
	 * @return list of advertisements
	 */
	public List<Advertisement> getAllById(int id) {
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		Connection con = null;
		try {
			String queryString = Query.GET_ALL_ADVERTISMENT_BY_CATEGORY_ID;
			ResultSet resultSet = null;
			con = dbCon.getAvailableConnection();
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			Advertisement advertisement = new Advertisement();
			while (resultSet.next()) {
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategory_id(resultSet.getInt("category_id"));
				advertisementList.add(advertisement);

			}

		} catch (SQLException e) {

		} finally {
			dbCon.releaseConnection(con);
		}
		return advertisementList;
	}

}
