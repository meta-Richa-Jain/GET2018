import java.util.Scanner;

public class ShoppingCart {
	public static void main(String arrgs[]) {

		Cart cart = new Cart();
		cart.addItem("jeans", 1, 300, 1);
		cart.addItem("wallet", 4, 600, 1);
		cart.addItem("handbag", 7, 1000, 1);
		cart.addItem("ring", 11, 20, 1);
		cart.removeItem(4);

		Scanner scan = new Scanner(System.in);
		System.out.println("Do you have any promo code (y/n)?");
		String answer = scan.next();
		if ("y".equalsIgnoreCase(answer)) {
			System.out.println("Enter 1 for Fixed Order Promo, " + "2 for Fixed Product Promo");
			int promoType = scan.nextInt();
			System.out.println("Enter the promo code");
			String promoCode = scan.next();
			System.out.println("Total Billing Amount (After discount): " 
					+ cart.generateReceiptWithPromo(promoCode, promoType));
		} else {
			System.out.println("Total Billing Amount : " 
					+ cart.getTotalPrice());
		}
		scan.close();
	}
}
