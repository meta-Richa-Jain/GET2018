import java.util.ArrayList;
import java.util.HashMap;

class Cart{
	
	private double totalPrice;
	private int totalItems;
	private ArrayList<String> list;
	HashMap<Integer, Double> itemPriceList; 
	HashMap<Integer, String> itemNameId; 
	private Item item;
	
	Cart(){
		itemPriceList = new HashMap<>();
		itemNameId = new HashMap<>(); 
		list = new ArrayList<>();
		totalPrice = 0;
		totalItems = 0;
	}
	
	void addItem(String itemName, int itemId, double itemPrice, int quantity){
		item = new Item(itemName,itemId,itemPrice,quantity);
		totalPrice = totalPrice + item.getPrice();
		totalItems = totalItems + item.getQuantity();
		list.add(item.getItemName());
		itemPriceList.put(itemId,itemPrice);
		itemNameId.put(itemId,itemName);
	}
	
	void removeItem(int itemId){
		totalItems -= 1;
		Double price = itemPriceList.get(itemId);
		totalPrice = totalPrice - price;
		String name = itemNameId.get(itemId);
		list.remove(name);
	}
	
	/*
	 * returns total amount to be paid at the time of checkout
	 */
	double generateReceipt(){
		/**double payableAmount = 0.0;
		   *for(Item i: list){
			*payableAmount =+ i.getPrice();
		}*/
		return totalPrice;
	}
	
	/*
	 * to clear the cart
	 */
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