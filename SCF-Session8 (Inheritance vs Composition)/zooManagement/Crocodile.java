package zooManagement;

/**
 * The Crocodile class is the subclass of the Reptile
 * @author Richa Jain
 *
 */
public class Crocodile extends Reptile{

	private static int id = 1;
	
	public Crocodile(double weight, int age) {
		
		super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalName.CROCODILE);
		// TODO Auto-generated constructor stub
	}

}
