
public class ShoppingCart {
	public static void main(String arrgs[]){
		
		Cart c1 = new Cart();
		c1.addItem("nike shoes", 1 , 30, 1);
		c1.addItem("wallet", 4 , 60, 1);
		c1.addItem("handbag", 7 , 10, 1);
		c1.addItem("ring", 11 , 20, 1);
		c1.removeItem(4);
		System.out.println("Total Amount: " + c1.generateReceipt());
		
	}
}
