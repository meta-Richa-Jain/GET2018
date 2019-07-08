package zooManagement;

import java.util.Scanner;

/**
 * This is the main method from where zoo management begins
 * 
 * @author Richa Jain
 */
public class ZooManagementSystem {

	public static void main(String[] args) {

		Zoo zoo = new Zoo();

		while (true) {
			System.out.println("1. Add Zone to the Zoo");
			System.out.println("2. Add Cage to the Zone");
			System.out.println("3. Add Animal to cage");
			System.out.println("4. Remove animal from cage");

			Scanner scan = new Scanner(System.in);

			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				AnimalFamily zoneType = chooseZone(scan);
				System.out.println("Please enter the capacity");
				int capacity = scan.nextInt();
				System.out.println("Does the zone has a park (Enter true or false)");
				boolean hasPark = scan.nextBoolean();
				System.out.println("Does the zone has a canteen (Enter true or false)");
				boolean hasCanteen = scan.nextBoolean();

				zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
				break;

			case 2:
				AnimalName cageType = chooseCage(scan);
				System.out.println("Enter the capacity of the cage");
				int capacityOfCage = scan.nextInt();

				if (zoo.addCage(cageType, capacityOfCage)) {
					System.out.println("Cage is successfully added");
				}
				break;

			case 3:
				AnimalName animalType = chooseCage(scan);
				Animal animal = addNewAnimal(scan, animalType);
				if (zoo.addAnimal(animal))
					System.out.println("Animal added successfully");
				break;

			case 4:
				AnimalName animalType1 = chooseCage(scan);
				if (zoo.removeAnimal(animalType1))
					System.out.println("Remove successfully");
				break;
			}
		}
	}

	/**
	 * This will create a animal object to add animal
	 * 
	 * @param scan
	 * @param animalType
	 * @return animal object
	 */
	private static Animal addNewAnimal(Scanner scan, AnimalName animalType) {

		Animal animal = null;
		double weight;
		int age;
		switch (animalType) {
		case CROCODILE:
			System.out.println("Enter the weight and age of crocodile");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Crocodile(weight, age);
			break;

		case ELEPHANT:
			System.out.println("Enter the weight and age of elephant");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Elephant(weight, age);
			break;

		case LION:
			System.out.println("Enter the weight and age of Lion");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Lion(weight, age);
			break;

		case PARROT:
			System.out.println("Enter the weight, age of Parrot");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Parrot(weight, age);
			break;

		case PEACOCK:
			System.out.println("Enter the weight, age of Peacock");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Peacock(weight, age);
			break;

		case SNAKE:
			System.out.println("Enter the weight and age of snake");
			weight = scan.nextDouble();
			age = scan.nextInt();
			animal = new Snake(weight, age);
			break;

		}
		return animal;
	}

	/**
	 * Used to find animal name
	 * 
	 * @param scan
	 *            takes scanner as input
	 * @return the animal name form AnimalName
	 */
	private static AnimalName chooseCage(Scanner scan) {
		AnimalName cageType = null;
		System.out.println("List of Cage Types");
		System.out.println("1. Lion");
		System.out.println("2. Elephant");
		System.out.println("3. Parrot");
		System.out.println("4. Peacock");
		System.out.println("5. Snake");
		System.out.println("6. Crocodile");
		System.out.println("Choose from the cage types..");

		int cage = scan.nextInt();

		switch (cage) {
		case 1:
			cageType = AnimalName.LION;
			break;
		case 2:
			cageType = AnimalName.ELEPHANT;
			break;
		case 3:
			cageType = AnimalName.PARROT;
			break;
		case 4:
			cageType = AnimalName.PEACOCK;
			break;
		case 5:
			cageType = AnimalName.SNAKE;
			break;
		case 6:
			cageType = AnimalName.CROCODILE;
			break;
		default:
			System.out.println("No result found!!");
			break;
		}
		return cageType;
	}

	/**
	 * This is useful to select a particular zone
	 * 
	 * @param scan
	 * @return the zone type from AnimalFamily
	 */
	private static AnimalFamily chooseZone(Scanner scan) {

		AnimalFamily zoneType = null;
		System.out.println("List of Zones");
		System.out.println("1. Bird");
		System.out.println("2. Mammal");
		System.out.println("3. Reptile");
		System.out.println("Choose from the zone types..");

		int zone = scan.nextInt();

		switch (zone) {
		case 1:
			zoneType = AnimalFamily.BIRD;
			break;
		case 2:
			zoneType = AnimalFamily.MAMMAL;
			break;
		case 3:
			zoneType = AnimalFamily.REPTILE;
			break;
		default:
			System.out.println("No result found!!");
			break;
		}
		return zoneType;
	}

}
