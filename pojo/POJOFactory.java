package pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to return objects of POJO class
 * 
 * @author Richa Jain
 *
 */
public class POJOFactory {

	/**
	 * Method to return object of order class
	 * 
	 * @param res
	 * @return order
	 * @throws SQLException
	 */
	public static Order getOrderFromResultSet(ResultSet res) throws SQLException {

		Order order = null;

		if (res != null) {
			order = new Order(res.getInt("id"), res.getInt("product_id"), res.getDate("placed_date"),
					res.getDouble("total_amount"));
		} else {
			order = new Order(-1, -1, null, -1);
		}
		return order;
	}

	/**
	 * Method to return object of category class
	 * 
	 * @param res
	 * @return category
	 * @throws SQLException
	 */
	public static Category getCountChildCategoriesFromResultSet(ResultSet res) throws SQLException {
		Category category = null;
		if (res != null) {
			category = new Category(res.getString("title"), res.getInt("count_child_categories"));

		} else {
			category = new Category(null, -1);
		}
		return category;
	}

}
