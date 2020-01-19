package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwimmerTypeTest {

	// Todo: add testClass to testSuite
	private String swimmingClub = "swimmingClub";
	SwimmerType superType;
	SwimmerType subType1;
	SwimmerType subType2 ;
	Swimmer swimmer;
	
	@Before
	public void init() {
		 superType = new SwimmerType("swimmerType1");
		 subType1 = new SwimmerType("subSwimmerType1");
		 subType2 = new SwimmerType("subSwimmerType2");
		swimmingClub = "swimmingClub";
	}

	@After
	public void finalize() {
		 superType = null;
		 subType1 = null;
		 subType2 = null;
		 swimmer = null;
	}
	@Test
	public void testAddingSubtypeIsSuccessfull() {

		superType.addSubType(subType1);

		assertTrue(subType1.getSuperType().equals(superType));
	}

	@Test
	public void testCreatingSwimmerInstanceSuccessfull() {

		Swimmer swimmer = superType.createInstance(5, swimmingClub);
		assertTrue(swimmer.getClub().equals(swimmingClub));
		assertTrue(superType.hasInstance(swimmer));

	}
	@Test
	public void testTypeHierachyForSwimmersSuccessfull() {
		superType.addSubType(subType1);
		Swimmer swimmer = subType1.createInstance(50, swimmingClub);
		
		assertTrue(superType.hasInstance(swimmer));
	}
	@Test
	public void testTypeHierachyForSwimmersUnsuccessfull() {
		superType.addSubType(subType1);
		
		
		Swimmer swimmer = subType2.createInstance(50, swimmingClub);
		
		assertTrue(!superType.hasInstance(swimmer));
	}

	@Test
	public void testIsSubtypeIsTrue() {

		superType.addSubType(subType1);
		assertTrue(subType1.isSubtype());
	}

	@Test
	public void testIsSubtypeIsFalse() {

		assertTrue(!superType.isSubtype());
	}

	@Test
	public void testSubTypeIteratorCorrectIterations() {

		superType.addSubType(subType1);
		superType.addSubType(subType2);
		
		superType.getSubtypes().contains(subType1);
		
		assertTrue(superType.getSubtypes().contains(subType1));
		assertTrue(superType.getSubtypes().contains(subType1));
	}
	
	
}
