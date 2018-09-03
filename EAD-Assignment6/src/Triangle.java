
public class Triangle {
	
	public double getArea(int side1, int side2, int side3){
		int s = (side1  + side2 +side3)/2;
		
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}

}
