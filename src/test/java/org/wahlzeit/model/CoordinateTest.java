package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinateTest {
	private Coordinate x = new Coordinate(10, 10, 10);
	private Coordinate y = new Coordinate(5, 5, 5);
	
	

	@Test
	public void DistanceIsCalculatedCorrectly() {
		
		assertTrue(Math.sqrt(75) == x.getDistance(y));
	}
	@Test
	public void getDistanceIsCommutative() {
		
		assertTrue( y.getDistance(x) == x.getDistance(y));
	}
	
	@Test
	public void CoordinateEqualsIsTrue() {
		assertTrue(y.equals(y));
	}
	@Test
	public void CoordinateEqualsIsFalse() {
		assertFalse(y.equals(x));
	}
	@Test
	public void EqualsGetsDifferentObjType() {
		assertFalse(y.equals(123));
	}
}
