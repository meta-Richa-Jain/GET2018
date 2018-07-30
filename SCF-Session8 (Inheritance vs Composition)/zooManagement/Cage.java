package zooManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * The Cage class will add the cage to the Zoo
 * 
 * @author Richa Jain 
 *         
 */
public class Cage {

	private AnimalName animalType;
	private int capacity;
	List<Animal> listOfAnimals = new ArrayList<>();

	public Cage(AnimalName animalType, int capacity) {
		this.animalType = animalType;
		this.capacity = capacity;
	}

	public AnimalName getAnimalType() {
		return animalType;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Animal> getListOfAnimals() {
		return listOfAnimals;
	}

	public void getInfo() {

		for (Animal animal : listOfAnimals) {
			System.out.println(animal.getName());
		}
	}

	public void addAnimal(Animal animal) {
		listOfAnimals.add(animal);

	}

	public boolean removeAnimal() {

		boolean removed = false;

		if (listOfAnimals.size() > 0) {
			listOfAnimals.remove(0);
			removed = true;
		}
		return removed;
	}

	public int spareCapacity() {
		return capacity - listOfAnimals.size();
	}
}
