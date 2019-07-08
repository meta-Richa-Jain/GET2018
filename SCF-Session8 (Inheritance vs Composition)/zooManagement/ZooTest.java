package zooManagement;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ZooTest {

	Zoo zoo = new Zoo();
	
	@Test
	public void zooTest1() {
		
		assertTrue(zoo.addZone(AnimalFamily.BIRD, 2, false, true)); 
		assertTrue(zoo.addCage(AnimalName.PEACOCK, 2)); 
		assertTrue(zoo.addAnimal(new Peacock(5, 2))); 
		assertTrue(zoo.removeAnimal(AnimalName.PEACOCK)); 
	}
	
	@Test
	public void zooTest2() {
		assertTrue(zoo.addZone(AnimalFamily.MAMMAL, 2, true, true)); 
		assertTrue(zoo.addCage(AnimalName.LION, 2)); 
		assertTrue(zoo.addCage(AnimalName.ELEPHANT, 2)); 
		assertTrue(zoo.addAnimal(new Lion(129, 35))); 
		assertTrue(zoo.removeAnimal(AnimalName.LION));
	}

	
	@Test(expected = AssertionError.class)
	public void zooTest3() {
		assertTrue(zoo.addZone(AnimalFamily.MAMMAL, 2, false, true)); 
		assertTrue(zoo.addCage(AnimalName.LION, 2)); 
		assertTrue(zoo.removeAnimal(AnimalName.LION)); 
	}
}
