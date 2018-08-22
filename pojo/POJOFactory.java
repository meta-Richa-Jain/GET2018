package pojo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to return objects of POJO class
 * @author Richa Jain
 *
 */
public class POJOFactory {

	public static Order getAllOrdersFromResultSet(ResultSet res)
			throws SQLException {

		Order orders = new Order(res.getInt("id"), res.getInt("product_id"),
				res.getDate("placed_date"), res.getDouble("total_amount"));

		return orders;
	}

	public static Category getCountChildCategoriesFromResultSet(ResultSet res)
			throws SQLException {

		Category category = new Category(res.getString("title"),
				res.getInt("count_child_categories"));

		return category;
	}

}
