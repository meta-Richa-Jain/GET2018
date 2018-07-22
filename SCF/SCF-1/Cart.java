import java.util.ArrayList;
import java.util.HashMap;

class Cart{
	
	private double totalPrice;
	private int totalItems;
	private ArrayList<String> list;
	private HashMap<Integer, Double> itemPriceList; 
	private HashMap<Integer, String> itemNameId; 
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
		totalPrice = totalPrice + (item.getPrice()*item.getQuantity());
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
	 * to calculate final billing amount after discount with the correct promocode
	 * @param promocode entered
	 * @returns total amount to be paid at the time of checkout after discount 
	 */
	double generateReceiptWithPromo(String promo, int promoType)throws NullPointerException{
		Promotions promoObject = null ;
		try{
			if(promoType == 1){
				promoObject = new FixedOrderPromotion();
			} else if(promoType == 2){
				//FixedProduct Promotion is only applicable on shoes
				if(list.contains("shoes")){
					promoObject = new FixedProductPromotion();
				} else {
					System.out.println("Sorry : promo not valid on selected items");
					return totalPrice;
				}
			}
			if(promoObject.isPromotionApplicable(promo, totalPrice)){
				System.out.println("Billing Amount : " + totalPrice);
				double discount = (promoObject.getFixedDiscount())*totalPrice;
				System.out.println("            - Discount : " + discount);
				totalPrice = totalPrice - discount;
			}
		} catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
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
	
	public double getTotalPrice(){
		return this.totalPrice;
	}
}
