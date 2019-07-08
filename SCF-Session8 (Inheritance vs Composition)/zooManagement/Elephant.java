package zooManagement;

/**
 * Elephant is the subclass of Mammal
 * @author Richa Jain
 * 
 */
public class Elephant extends Mammal{

	private static int id = 1;
	
	public Elephant(double weight, int age) {
		super("Elephant" + (id++), weight, age, "Trumpet", false, AnimalName.ELEPHANT);
		// TODO Auto-generated constructor stub
	}

}
