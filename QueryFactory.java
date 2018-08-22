/**
 * This class contains all the queries required in this project
 * @author Richa Jain
 *
 */
public class QueryFactory {
	
	public static final String orderDetail = "SELECT  orders.id, items_status.product_id, orders.placed_date,orders.total_amount " +
										"FROM orders " +
										"INNER JOIN users ON users.id=orders.user_id " +
										"INNER JOIN items_status ON orders.id=items_status.order_id "+
										"WHERE users.id= ? AND items_status.status='placed' ";
	
	
	public static final String insertImage = "INSERT INTO image(url, title, product_id) VALUES(?,?,?)";
	
	public static final String countChildCategories = "SELECT parent.title, count(*) as count_child_categories " +
													  "FROM category parent " + 
													  "INNER JOIN category child " +
													  "ON parent.id = child.parent_category " +
													  "GROUP BY child.parent_category " +
													  "ORDER BY parent.title"; 	
	
	public static final String updateProductStatus = "UPDATE product "
													+ "SET product.state='inactive' "
													+ "WHERE product.id NOT IN "
													+ "(SELECT items_status.product_id "
													+ "FROM items_status "
													+ "INNER JOIN orders ON items_status.order_id=orders.id "
													+ "WHERE DATEDIFF(CURDATE(),orders.placed_date)<365)";

}
