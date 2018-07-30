package zooManagement;

/**
 * This class inherites the Zone class and used to add Bird Zone in the Zoo
 * @author Richa Jain
 */
public class BirdZone extends Zone{

	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
	}
	
}
