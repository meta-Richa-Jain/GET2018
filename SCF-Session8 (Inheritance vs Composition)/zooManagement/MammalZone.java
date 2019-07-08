package zooManagement;

/**
 * This class will add the Mammal zone into Zoo
 * @author Deekshika Sharma
 */
public class MammalZone extends Zone{
	
	/**
	 * It initializes the MammalZone properties into Zoo
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public MammalZone(int capacity, boolean hasPark, boolean hasCanteen)
	{
		super(AnimalFamily.MAMMAL, capacity, hasPark, hasCanteen);
	}
}
