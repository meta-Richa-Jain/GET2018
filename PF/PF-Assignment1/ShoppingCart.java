import java.util.ArrayList;
import java.util.HashMap;

class Item{
	
	private String itemName;
	private int itemId;
	private double price;
	private int quantity;
	
	//private HashMap<Integer,String> itemDescription = new HashMap<>();
	
	Item(String itemName,int itemId, double price, int quantity){
		this.setItemName(itemName);
		this.setItemId(itemId);
		this.setPrice(price);
		this.setQuantity(quantity);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}

class Cart{
	
	private double totalPrice;
	private int totalItems;
	private ArrayList<String> list;
	HashMap<Integer, Double> itemPriceList = new HashMap<>(); 
	HashMap<Integer, String> itemNameId = new HashMap<>(); 
	private Item item;
	Cart(){
		list = new ArrayList<>();
		totalPrice = 0;
		totalItems = 0;
	}
	void addItem(String itemName, int itemId, double itemPrice, int quantity){
		item = new Item(itemName,itemId,itemPrice,quantity);
		totalPrice =+ item.getPrice();
		totalItems =+ item.getQuantity();
		list.add(item.getItemName());
		itemPriceList.put(itemId,itemPrice);
		itemNameId.put(itemId,itemName);
	}
	
	void removeItem(int itemId){
		totalItems =- 1;
		Double price = itemPriceList.get(itemId);
		totalPrice = totalPrice - price;
		String name = itemNameId.get(itemId);
		list.remove(name);
	}
	
	double generateReceipt(){
		/**double payableAmount = 0.0;
		   *for(Item i: list){
			*payableAmount =+ i.getPrice();
		}*/
		return totalPrice;
	}
	
	boolean emptyCart(){
		totalItems = 0;
		totalPrice = 0;
		list.clear();
	return true;
	}
	
	boolean equals(Item ItemId){
		return this.equals(ItemId) ? true:false;
	}
}
public class ShoppingCart {
	public static void main(String arrgs[]){
		
		Cart c1 = new Cart();
		c1.addItem("nike shoes", 1 , 3447, 1);
		c1.addItem("wallet", 4 , 650, 1);
		c1.addItem("handbag", 7 , 1845, 1);
		c1.addItem("ring", 11 , 250, 1);
		c1.removeItem(4);
		System.out.println(c1.generateReceipt());
		
	}
}
