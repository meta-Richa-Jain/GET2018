import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelperFunction {

	List<Order> userOrders;
	List<Category> parentList;

	public HelperFunction() {
		userOrders = new ArrayList<Order>();
		parentList = new ArrayList<Category>();

	}

	/*
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
	 * that user which are in shipped state. Orders should be sorted by order
	 * date column in chronological order.
	 */

	public List<Order> getAllOrders(int user_id) {

		Connection con = DBConnection.getConnection();

		try {
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
		}
		return null;

	}

	public int insert_image(List<Image> list_of_images) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(QueryFactory.insertImage);) {
			try {
				conn.setAutoCommit(false);
				for (int count = 0; count < list_of_images.size(); count++) {
					stmt.setString(1, list_of_images.get(count).getUrl());
					stmt.setString(2, list_of_images.get(count).getTitle());
					stmt.setInt(3, list_of_images.get(count).getProductId());
					stmt.addBatch();
				}

				int[] result = stmt.executeBatch();
               
				conn.commit();
				return result.length;
			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}

		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Category> getCountChildCategories() {
		Connection con = DBConnection.getConnection();

		try {
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
		}
		return null;

	}
	
	public int productStatus() {
		int result =0;
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(QueryFactory.updateProductStatus);) {
			try {
				result = stmt.executeUpdate();
				return result;
			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}

		}
		// Step 5: Close the resources - Done automatically by
		// try-with-resources
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String toStringCategory(List<Category> categoryList) {
		StringBuilder categories = new StringBuilder();
		for (int count = 0; count < categoryList.size(); count++) {
			categories.append(categoryList.get(count).getTitle() + " "
					+ categoryList.get(count).getCountChildren() + " ");
		}
		return categories.toString();
	}

	public String toStringOrders(List<Order> ordersList) {
		StringBuilder orders = new StringBuilder();
		for (int count = 0; count < ordersList.size(); count++) {
			orders.append(ordersList.get(count).getOrder_id() + " "
					+ ordersList.get(count).getProduct_id()+ " " + ordersList.get(count).getAmount() + " "
					+ ordersList.get(count).getPlaced_date() + " ");
		}
		return orders.toString();
	}

}
