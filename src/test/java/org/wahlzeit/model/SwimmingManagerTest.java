package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SwimmingManagerTest {
	@Test
	public void testCreateInstanceWhenNonExistingSuccessfull() {
		SwimmerManager swimmerManager = SwimmerManager.getInstance();
		assertTrue(swimmerManager != null);
	}

	@Test
	public void testManagerReturnSameInstanceByMultipleInsnciations() {
		SwimmerManager swimmerManager = SwimmerManager.getInstance();
		SwimmerManager swimmerManager2 = SwimmerManager.getInstance();
		assertTrue(swimmerManager.equals(swimmerManager2));
	}

	@Test
	public void testSubTypeCreationSuccessfull() {
		SwimmerManager swimmerManager = SwimmerManager.getInstance();

		Swimmer swimmer = swimmerManager.createSwimmer("swimmerType", 30, "swimmingClub");

		assertTrue(swimmer.getType().getName() == "swimmerType" && swimmer.getId() == 30
				&& swimmer.getClub() == "swimmingClub");
	}
}
