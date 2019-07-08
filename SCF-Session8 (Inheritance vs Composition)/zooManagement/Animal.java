package zooManagement;

/**
 * The Animal class is the superclass of many subclasses which generally shows
 * the properties of animal
 * 
 * @author Richa Jain
 * 
 */
public class Animal {

	private final String name;
	private double weight;
	private int age;
	private final String sound;
	private final AnimalFamily category;
	private final AnimalName animalType;

	public Animal(String name, double weight, int age, String sound, AnimalFamily category,
			AnimalName animalType) {
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.sound = sound;
		this.category = category;
		this.animalType = animalType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public AnimalName getAnimalType() {
		return animalType;
	}

	public AnimalFamily getCategory() {
		return category;
	}
}
