import java.util.Date;

/**
 * POJO class to store details of an order
 * @author Richa Jain
 *
 */
public class Order {

	private int order_id;
	private int product_id;
	private Date placed_date;
	private double amount;

	public Order(int order_id, int product_id, Date placed_date, double amount) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.placed_date = placed_date;
		this.amount = amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getPlaced_date() {
		return placed_date;
	}

	public void setPlaced_date(Date placed_date) {
		this.placed_date = placed_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
