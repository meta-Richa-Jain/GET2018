import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to perform insertion, deletion operation on database
 * 
 * @author Richa Jain
 *
 */
public class HelperFunction {

	ConnectionPool dbCon;
	List<Order> userOrders;
	List<Category> parentList;

	public HelperFunction() {
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
				Order orders = UpdateDB.getAllOrdersFromResultSet(res);
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
	public int insert_image(List<Image> list_of_images) {
		Connection con = null;
		try {
			con = dbCon.getAvailableConnection();
			PreparedStatement stmt = con
					.prepareStatement(QueryFactory.insertImage);
			con.setAutoCommit(false);
			for (int count = 0; count < list_of_images.size(); count++) {
				stmt.setString(1, list_of_images.get(count).getUrl());
				stmt.setString(2, list_of_images.get(count).getTitle());
				stmt.setInt(3, list_of_images.get(count).getProductId());
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
				Category category = UpdateDB
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
					.prepareStatement(QueryFactory.countChildCategories);
			result = ps.executeUpdate();
			return result;
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
