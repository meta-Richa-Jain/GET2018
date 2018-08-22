import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DatabaseTest {

	HelperFunction func = new HelperFunction();

	@Test
	public void testCategory() {
		List<Category> categoryList = func.getCountChildCategories();
		String expectedResult = "Clothing 1 Electronics 1 TV Appliances 1 ";
		String actualResult = func.toStringCategory(categoryList);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testOrders() {
		List<Order> ordersList = func.getAllOrders(5);
		String expectedResult = "5 4 400.0 2018-07-22 ";
		String actualResult = func.toStringOrders(ordersList);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testImage() {
		List<Image> list_of_images = new ArrayList<Image>();
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
		list_of_images.add(image1);
		list_of_images.add(image2);
		list_of_images.add(image3);
		list_of_images.add(image4);
		list_of_images.add(image5);
		list_of_images.add(image6);
		list_of_images.add(image7);
		int actualResult = func.insert_image(list_of_images);
		assertEquals(7, actualResult);
	}

	@Test
	public void testStatus() {
		int actual = func.productStatus();
		assertEquals(3, actual);
	}
}
