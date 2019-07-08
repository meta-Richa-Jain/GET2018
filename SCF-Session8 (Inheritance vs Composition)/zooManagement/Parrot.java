package zooManagement;

/**
 * Parrot is the subclass of Bird
 * 
 * @author Richa Jain
 * 
 */
public class Parrot extends Bird {

	private static int id = 1;

	public Parrot(double weight, int age) {

		super("Parrot" + (id++), weight, age, "squawk", true, AnimalName.PARROT);
		// TODO Auto-generated constructor stub
	}

}
