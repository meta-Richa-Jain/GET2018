package zooManagement;

/**
 * This Bird class inherites the Animal super class
 * @author Richa Jain
 */
public class Bird extends Animal{

	private final boolean isAbleToFly;
	
	public Bird(String name, double weight, int age, String sound
			, boolean isAbleToFly, AnimalName animalType) {
		
		super(name, weight, age, sound, AnimalFamily.BIRD, animalType);
		
		this.isAbleToFly = isAbleToFly;
	}	

	public boolean isAbleToFly() {
		return isAbleToFly;
	}

}
