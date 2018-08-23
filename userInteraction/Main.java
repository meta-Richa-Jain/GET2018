package userInteraction;

import java.util.ArrayList;
import java.util.List;
import database.HelperClass;
import pojo.Category;
import pojo.Order;
import pojo.Image;

/**
 * This class is used to perform insertion, deletion operation on the database
 * 
 * @author Richa Jain
 *
 */
public class Main {

	private HelperClass helper;
	private List<Order> userOrders;
	private List<Category> parentList;

	public Main(String url, String username, String password) {
		helper = new HelperClass(url, username, password);
		userOrders = new ArrayList<Order>();
		parentList = new ArrayList<Category>();

	}

	/**
	 * Method to return order details of a user
	 * 
	 * @param user_id
	 * @return list of orders placed by the user
	 */

	public List<Order> getAllOrders(int userId) {

		userOrders = helper.getAllOrdersFromDatabase(userId);
		return userOrders;

	}

	/**
	 * Method to insert image details
	 * 
	 * @param list_of_images
	 * @return number of images inserted
	 */
	public int insertImage(List<Image> listImages) {

		int imageInserted = helper.insertImageIntoDatabase(listImages);
		return imageInserted;

	}

	public List<Category> getCountChildCategories() {

		parentList = helper.getCountChildCategoriesFromDatabase();
		return parentList;

	}

	/**
	 * Method to delete products which have not been ordered in one year
	 * 
	 * @return number of products deleted
	 */
	public int productStatus() {

		int countChangedStatus = helper.updateProductStatusIntoDatabase();
		return countChangedStatus;
	}

	/**
	 * Helper function to return string value of list
	 * 
	 * @param categoryList
	 * @return
	 */
	public String toStringCategory(List<Category> categoryList) {
		StringBuilder categories = new StringBuilder();
		for (int count = 0; count < categoryList.size(); count++) {
			categories.append(
					categoryList.get(count).getTitle() + " " + categoryList.get(count).getCountChildren() + " ");
		}
		return categories.toString();
	}

	/**
	 * Helper function to return string value of list
	 * 
	 * @param categoryList
	 * @return
	 */
	public String toStringOrders(List<Order> ordersList) {
		StringBuilder orders = new StringBuilder();
		for (int count = 0; count < ordersList.size(); count++) {
			orders.append(ordersList.get(count).getOrderId() + " " + ordersList.get(count).getProductId() + " "
					+ ordersList.get(count).getAmount() + " " + ordersList.get(count).getPlacedDate() + " ");
		}
		return orders.toString();
	}

}
