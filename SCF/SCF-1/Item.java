// stores description of each item

class Item{
	
	private String itemName;
	private int itemId;
	private double price;
	private int quantity;
	
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
	
	public String toString(){
		return "ItemID : " + itemId + " ItemName : " + itemName +
				" ItemPrice : " +  price + " Quantity in the cart : " + quantity;
	}
	
}