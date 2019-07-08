package zooManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will perform various operations on Zoo management
 * 
 * @author Richa Jain
 */
public class Zoo {

	List<Zone> listOfZone = new ArrayList<Zone>(); // create the list of zones

	/**
	 * This method add the zone for a specific type of animal
	 * 
	 * @param zoneType
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public boolean addZone(AnimalFamily zoneType, int capacity, boolean hasPark, boolean hasCanteen) {
		Zone zone = null;

		switch (zoneType) {
		case BIRD:
			zone = new BirdZone(capacity, hasPark, hasCanteen);
			break;
		case MAMMAL:
			zone = new MammalZone(capacity, hasPark, hasCanteen);
			break;
		case REPTILE:
			zone = new ReptileZone(capacity, hasPark, hasCanteen);
			break;
		}

		listOfZone.add(zone);
		return true;
	}

	/**
	 * This method will add cage to a particular zone
	 * 
	 * @param animal
	 * @param capacity, capacity of the cage
	 * @return true if cage can be added to the zone else false
	 */
	public boolean addCage(AnimalName animal, int capacity) {
		Cage cage = new Cage(animal, capacity);
		boolean flag = false;

		for (Zone zone : listOfZone) {
			if (zone.spareCapacity() != 0) {
				if (zone.getZoneType() == AnimalFamily.BIRD
						&& (animal.equals(AnimalName.PARROT) || animal.equals(AnimalName.PEACOCK))) {
					zone.addCage(cage);
					flag = true;
					break;
				} else if (zone.getZoneType() == AnimalFamily.MAMMAL
						&& (animal.equals(AnimalName.LION) || animal.equals(AnimalName.ELEPHANT))) {
					zone.addCage(cage);
					flag = true;
					break;
				} else if (zone.getZoneType() == AnimalFamily.REPTILE
						&& (animal.equals(AnimalName.CROCODILE) || animal.equals(AnimalName.SNAKE))) {
					zone.addCage(cage);
					flag = true;
					break;
				}
			}
		}

		if (!flag) {
			throw new AssertionError("You need to add a zone first");
		}
		return flag;
	}

	/**
	 * This method adds the animal to a specific cage
	 * 
	 * @param animal
	 * @return true if added successfully
	 */
	public boolean addAnimal(Animal animal) {
		boolean flag = false;

		for (Zone zone : listOfZone) {
			if (zone.getZoneType().equals(animal.getCategory()) && zone.addAnimal(animal)) {
				flag = true;
				break;
			}
		}

		if (!flag)
			throw new AssertionError("All zones are full!!You need to add a zone first");

		return flag;
	}

	/**
	 * This method removes the specific animal from the cage
	 * 
	 * @param animal
	 *            takes the animal name
	 */
	public boolean removeAnimal(AnimalName animal) {
		boolean flag = false;
		AnimalFamily category = null;

		switch (animal) {
		case CROCODILE:
			category = AnimalFamily.REPTILE;
			break;
		case ELEPHANT:
			category = AnimalFamily.MAMMAL;
			break;
		case LION:
			category = AnimalFamily.MAMMAL;
			break;
		case PARROT:
			category = AnimalFamily.BIRD;
			break;
		case PEACOCK:
			category = AnimalFamily.BIRD;
			break;
		case SNAKE:
			category = AnimalFamily.REPTILE;
			break;
		}

		for (Zone zone : listOfZone) {
			if (zone.getZoneType().equals(category) && zone.removeAnimal(animal)) {
				flag = true;
				break;
			}
		}

		if (!flag)
			throw new AssertionError("Animal not found!");

		return flag;
	}
}
