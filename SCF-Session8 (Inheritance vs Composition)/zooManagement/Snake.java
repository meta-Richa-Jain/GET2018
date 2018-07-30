package zooManagement;

/**
 * Snake is the subclass of Reptile
 * @author Richa Jain
 * It initializes the properties of Snake when added to Zoo
 */
public class Snake extends Reptile{

	private static int id = 1;
	
	public Snake(double weight, int age) {
		
		super("Snake" + (id++), weight, age, "Hiss", 0, true, "cold", AnimalName.SNAKE);
		// TODO Auto-generated constructor stub
	}

}
