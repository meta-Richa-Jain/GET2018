package pojo;
import java.util.Date;

/**
 * POJO class to store details of an order
 * @author Richa Jain
 *
 */
public class Order {

	private int orderId;
	private int productId;
	private Date placedDate;
	private double amount;

	public Order(int orderId, int productId, Date placedDate, double amount) {
		this.orderId = orderId;
		this.productId= productId;
		this.placedDate = placedDate;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getPlacedDate() {
		return this.placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}

	