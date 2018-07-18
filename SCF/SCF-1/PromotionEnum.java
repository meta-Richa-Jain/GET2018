/*
 * creates an enum with fields as code, start date and end date of the month
 */

public enum PromotionEnum{
	
	PROMO1 ("PROMO20", 1, 27),
	PROMO2 ("PROMO30", 8, 11), 
	PROMO3 ("EOR50", 12, 20),
	PROMO4 ("JULY60", 21, 30);
	
	private final String code;
	private final int startDate;
	private final int endDate;
	
	PromotionEnum(String code, int startDate, int endDate){
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getCode(){
		return code;
	}
	
	public int getStartDate(){
		return startDate;
	}
	
	public int getEndDate(){
		return endDate;
	}
}