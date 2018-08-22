package userInteraction;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pojo.Category;
import pojo.Order;
import pojo.Image;
public class DatabaseTest {

	Main func = new Main();

	@Test
	public void testCategory() {
		List<Category> categoryList = func.getCountChildCategories();
		String expectedResult = "Clothing 1 Electronics 1 TV Appliances 1 ";
		String actualResult = func.toStringCategory(categoryList);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testOrders() {
		List<Order> ordersList = func.getAllOrders(4);
		String expectedResult = "5 4 500.0 2018-02-15 6 4 700.0 2018-03-12 ";
		String actualResult = func.toStringOrders(ordersList);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testImage() {
		List<Image> listImages = new ArrayList<Image>();
		Image image1 = new Image("https://image5_product3", "image5 product 3",
				3);
		Image image2 = new Image("https://image6_product3", "image6 product 3",
				3);
		Image image3 = new Image("https://image7_product3", "image7 product 3",
				3);
		Image image4 = new Image("https://image8_product3", "image8 product 3",
				3);
		Image image5 = new Image("https://image4_product4", "image4 product 4",
				4);
		Image image6 = new Image("https://image5_product4", "image5 product 4",
				4);
		Image image7 = new Image("https://image6_product4", "image6 product 4",
				4);
		listImages.add(image1);
		listImages.add(image2);
		listImages.add(image3);
		listImages.add(image4);
		listImages.add(image5);
		listImages.add(image6);
		listImages.add(image7);
		int actualResult = func.insertImage(listImages);
		assertEquals(7, actualResult);
	}

	@Test
	public void testStatus() {
		int actual = func.productStatus();
		assertEquals(2, actual);
	}
	
}
