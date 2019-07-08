package zooManagement;

/**
 * Reptile is the subclass of Animal and it adds the Reptile type animal into Zoo
 * @author Richa Jain
 */
public class Reptile extends Animal{
	
	private final boolean isPoisonous;
	private final String bloodType;
	
   
	public Reptile(String name, double weight, int age, String sound,
			int numberOfLegs, boolean isPoisonous, String bloodType, AnimalName animlType) {
		super(name, weight, age, sound, AnimalFamily.REPTILE, animlType);
		
		this.isPoisonous = isPoisonous;
		this.bloodType = bloodType;
	}

	public boolean isPoisonous() {
		return isPoisonous;
	}

	public String getBloodType() {
		return bloodType;
	}
	
	
}
