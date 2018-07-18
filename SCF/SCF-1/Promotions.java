
public interface Promotions {

		public double getMinimumPrice();
		public void setMinimumPrice(double amount);
		public double getFixedDiscount(); 
		public void setFixedDiscount(double discount); 
		public boolean isPromotionApplicable(String promoCode, double totalPrice);
}


