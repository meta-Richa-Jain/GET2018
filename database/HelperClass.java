package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Category;
import pojo.Image;
import pojo.Order;
import pojo.POJOFactory;

/**
 * Helper class to make connection with the database and to get results from or
 * update into the database
 * 
 * @author Richa Jain
 *
 */
public class HelperClass {

	private ConnectionPool dbCon;
	private List<Order> userOrders;
	private List<Category> parentList;
	private Connection con;

	/**
	 * Constructor to initialize all the class members
	 */
	public HelperClass(String url, String username, String password) {
		dbCon = new ConnectionPool(url, username, password);
		this.con = null;
		userOrders = new ArrayList<Order>();
		parentList = new ArrayList<Category>();
	}

	/**
	 * Method to return order details of a user from the databse
	 * 
	 * @param user_id
	 * @return list of orders placed by the user
	 */

	public List<Order> getAllOrdersFromDatabase(int userId) {
		try {
			PreparedStatement ps = getPreparedStatement(QueryFactory.orderDetail);
			ps.setInt(1, userId);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Order order = POJOFactory.getOrderFromResultSet(res);
				userOrders.add(order);
			}
			return userOrders;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;

	}

	/**
	 * Method to insert image details into the database
	 * 
	 * @param list_of_images
	 * @return number of images inserted
	 */
	public int insertImageIntoDatabase(List<Image> listImages) {
		try {
			PreparedStatement ps = getPreparedStatement(QueryFactory.insertImage);
			if (ps != null) {
				setAutoCommit();
				for (int count = 0; count < listImages.size(); count++) {
					ps.setString(1, listImages.get(count).getUrl());
					ps.setString(2, listImages.get(count).getTitle());
					ps.setInt(3, listImages.get(count).getProductId());
					ps.addBatch();
				}
				int[] result = ps.executeBatch();
				commit();
				return result.length;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			rollback();
		} finally {
			closeConnection();
		}

		return 0;
	}

	/**
	 * Method to get the count of child categories of each parent category
	 * 
	 * @return parentList, list of parent category and their corresponding count
	 */
	public List<Category> getCountChildCategoriesFromDatabase() {
		try {
			PreparedStatement ps = getPreparedStatement(QueryFactory.countChildCategories);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Category category = POJOFactory.getCountChildCategoriesFromResultSet(res);
				parentList.add(category);
			}
			return parentList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;

	}

	/**
	 * Method to delete products which have not been ordered in one year
	 * 
	 * @return number of products deleted
	 */
	public int updateProductStatusIntoDatabase() {
		int result = 0;
		try {
			PreparedStatement ps = getPreparedStatement(QueryFactory.updateProductStatus);
			setAutoCommit();
			result = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			rollback();
		} finally {
			closeConnection();
		}

		return result;
	}

	/**
	 * Helper function to get the object of prepared statement
	 * 
	 * @param query,
	 *            query that has to be executed
	 * @return ps, object of preparedStatement
	 */
	private PreparedStatement getPreparedStatement(String query) {
		try {
			this.con = dbCon.getAvailableConnection();
			PreparedStatement ps = this.con.prepareStatement(query);
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Helper method to close the database connection
	 */
	private void closeConnection() {
		dbCon.releaseConnection(this.con);
	}

	/**
	 * Helper method to set auto commit to false
	 */
	private void setAutoCommit() {
		try {
			this.con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Helper method to commit changes to the database
	 */
	private void commit() {
		try {
			this.con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Helper method to rollback the update done on the database
	 */
	private void rollback() {
		try {
			this.con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
