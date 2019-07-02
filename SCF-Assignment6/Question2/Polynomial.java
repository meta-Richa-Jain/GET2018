package Question2;
 /**
  * Interface to implement Poly class (ADT)
  * @author Richa Jain
  *
  */
public interface Polynomial {
	
	public float evaluate(float xVal);
	public int degree();
	public Poly addPoly(Poly polynomial1, Poly polynomial2);
	public Poly multiplyPoly(Poly p1, Poly p2);

}
