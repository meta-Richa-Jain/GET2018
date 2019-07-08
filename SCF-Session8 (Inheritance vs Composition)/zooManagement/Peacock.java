package zooManagement;

/**
 * Peacock is the subclass of Bird
 * @author Richa Jain 
 * It initializes the properties of Parrot when added to Zoo
 */
public class Peacock extends Bird{

	private static int id = 1;
	
	public Peacock(double weight, int age) {
		
		super("Peacock" + (id++), weight, age, "scream", true, AnimalName.PEACOCK);
		// TODO Auto-generated constructor stub
	}

}
