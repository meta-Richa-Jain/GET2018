package userInteraction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.QueryFactory;
import pojo.Category;
import pojo.Order;
import pojo.POJOFactory;
import pojo.Image;

/**
 * This class is used to perform insertion, deletion operation on database
 * 
 * @author Richa Jain
 *
 */
public class Main {

	private ConnectionPool dbCon;
	private List<Order> userOrders;
	private List<Category> parentList;

	public Main() {
		dbCon = new ConnectionPool();
		userOrders = new ArrayList<Order>();
		parentList = new ArrayList<Category>();

	}

	/**
	 * Method to return order details of a user
	 * 
	 * @param user_id
	 * @return list of orders placed by the user
	 */

	public List<Order> getAllOrders(int user_id) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(QueryFactory.orderDetail);
			ps.setInt(1, user_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Order orders = POJOFactory.getAllOrdersFromResultSet(res);
				userOrders.add(orders);
			}
			return userOrders;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbCon.releaseConnection(con);
		}
		return null;

	}

	/**
	 * Method to insert image details
	 * 
	 * @param list_of_images
	 * @return number of images inserted
	 */
	public int insertImage(List<Image> listImages) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement stmt = con
					.prepareStatement(QueryFactory.insertImage);
			con.setAutoCommit(false);
			for (int count = 0; count < listImages.size(); count++) {
				stmt.setString(1, listImages.get(count).getUrl());
				stmt.setString(2, listImages.get(count).getTitle());
				stmt.setInt(3, listImages.get(count).getProductId());
				stmt.addBatch();
			}

			int[] result = stmt.executeBatch();
			con.commit();
			return result.length;
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			dbCon.releaseConnection(con);
		}

		return 0;
	}

	public List<Category> getCountChildCategories() {
		Connection con = null;

		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(QueryFactory.countChildCategories);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Category category = POJOFactory
						.getCountChildCategoriesFromResultSet(res);
				parentList.add(category);
			}
			return parentList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			dbCon.releaseConnection(con);
		}
		return null;

	}

	/**
	 * Method to delete products which have not been ordered in one year
	 * 
	 * @return number of products deleted
	 */
	public int productStatus() {
		int result = 0;
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement ps = con
					.prepareStatement(QueryFactory.updateProductStatus);
			System.out.println("HI");
			con.setAutoCommit(false);
			result = ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			dbCon.releaseConnection(con);
		}

		return result;
	}

	/**
	 * Helper function to return string value of list
	 * @param categoryList
	 * @return
	 */
	public String toStringCategory(List<Category> categoryList) {
		StringBuilder categories = new StringBuilder();
		for (int count = 0; count < categoryList.size(); count++) {
			categories.append(categoryList.get(count).getTitle() + " "
					+ categoryList.get(count).getCountChildren() + " ");
		}
		return categories.toString();
	}

	/**
	 * Helper function to return string value of list
	 * @param categoryList
	 * @return
	 */
	public String toStringOrders(List<Order> ordersList) {
		StringBuilder orders = new StringBuilder();
		for (int count = 0; count < ordersList.size(); count++) {
			orders.append(ordersList.get(count).getOrder_id() + " "
					+ ordersList.get(count).getProduct_id() + " "
					+ ordersList.get(count).getAmount() + " "
					+ ordersList.get(count).getPlaced_date() + " ");
		}
		return orders.toString();
	}
	
}
