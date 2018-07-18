public class FixedOrderPromotion implements Promotions{

	private double minimumPrice;
	private double fixedDiscount;
	private PromotionEnum validPromo;
	
	public FixedOrderPromotion() {
		// TODO Auto-generated constructor stub
		this.setMinimumPrice(1000);
		this.setFixedDiscount(5);
	}
	@Override
	public double getMinimumPrice() {
		return minimumPrice;
	}

	@Override
	public void setMinimumPrice(double amount) {
		this.minimumPrice = amount;
		
	}

	@Override
	public double getFixedDiscount() {
		return fixedDiscount/100;
	}

	@Override
	public void setFixedDiscount(double discount) {
		this.fixedDiscount = discount;
		
	}
	
	/*
	 * checks if the promo code entered is correct or not by looking up 
	 * in the PromotionEnum 
	 * @param promoCode entered by user
	 * @returns true if it is correct else false
	 */
	public boolean isValidPromo(String promoCode){
		for(PromotionEnum p : PromotionEnum.values()){
			if(promoCode.equals(p.getCode())){
				this.validPromo= p;
				return true;
			}
		}
		return false;
	}
	
	@Override
	/*
	 * checks if the entered promo code is valid for today's date or not and 
	 * there is sufficient amount of the cart so that the promo code can be used
	 * @param promocode entered by the user and total biling price of the cart
	 * @returns true if it is applicable else false 
	 */
	public boolean isPromotionApplicable(String promoCode, double price) {
		double totalPrice = price;
		// To return todays date
		CurrentDate currDate = new CurrentDate();
		int currentDayOfMonth = currDate.getDate();
		if(totalPrice>getMinimumPrice()){
			if(isValidPromo(promoCode)){
				if(currentDayOfMonth>=validPromo.getStartDate() && 
						currentDayOfMonth<=validPromo.getEndDate()){
					return true;
				} else{
					System.out.println("Not valid for today's date : "
							+ "Check the validity of the code");
					return false;
				}
			} else{
				System.out.println("Not a valid promo code");
				return false;
			}
		} else{
			System.out.println("Insufficient amount of the cart");
			return false;
		}
	}
	
}
