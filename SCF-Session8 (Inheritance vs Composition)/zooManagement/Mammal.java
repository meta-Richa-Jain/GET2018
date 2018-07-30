package zooManagement;

/**
 * Mammals is the subclass of Animal and it adds the Mammal type animal into Zoo
 * @author Richa Jain
 */
public class Mammal extends Animal{
	
	private final boolean hasFurs;
	
	public Mammal(String name, double weight, int age, String sound,
			 boolean hasFurs, AnimalName animalType) {
		
		super(name, weight, age, sound, AnimalFamily.MAMMAL, animalType);
		
		this.hasFurs = hasFurs;
	}

	public boolean isHasFurs() {
		return hasFurs;
	}
}
