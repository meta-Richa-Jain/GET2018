package zooManagement;

/**
 * Lion is the subclass of Mammal
 * @author Richa Jain
 * 
 */
public class Lion extends Mammal{

private static int id = 1;
	
	public Lion(double weight, int age) {
		super("Lion" + (id++), weight, age, "Roar", false, AnimalName.LION);
		// TODO Auto-generated constructor stub
	}

}
