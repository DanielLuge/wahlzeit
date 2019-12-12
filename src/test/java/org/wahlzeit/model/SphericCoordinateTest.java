package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.CartesianCoordinateValues.X;
import org.wahlzeit.model.CartesianCoordinateValues.Y;
import org.wahlzeit.model.CartesianCoordinateValues.Z;
import org.wahlzeit.model.SphericCoordinate2.Phi;
import org.wahlzeit.model.SphericCoordinate2.Radius;
import org.wahlzeit.model.SphericCoordinate2.Theta;

public class SphericCoordinateTest {
	private final double decimalPlace = 1E-5;

	private CartesianCoordinate cartesianCoordinate1;
	private CartesianCoordinate cartesianCoordinate2;
	private SphericCoordinate sphericCoordinate1;
	private SphericCoordinate sphericCoordinate2;

	@Before
	public void init() {
		cartesianCoordinate1 = CartesianCoordinate.getInstance(new X(10), new Y(10), new Z(10));
		cartesianCoordinate2 = CartesianCoordinate.getInstance(new X(5), new Y(5), new Z(5));
		sphericCoordinate1 = SphericCoordinate.getInstance(new Phi(Math.toRadians(45)), new Theta(Math.toRadians(45)),
				new Radius(6360));
		sphericCoordinate2 = SphericCoordinate.getInstance(new Phi(Math.toRadians(46)), new Theta(Math.toRadians(46)),
				new Radius(6360));
	}

	@After
	public void finalize() {
		cartesianCoordinate1 = null;
		cartesianCoordinate2 = null;

		sphericCoordinate1 = null;
		sphericCoordinate2 = null;
	}

	@Test
	public void testConvertTwoWayConversion() {

		sphericCoordinate2 = cartesianCoordinate1.asSphericCoordinate();
		cartesianCoordinate1 = sphericCoordinate2.asCastesianCoordinate();
		assertTrue(cartesianCoordinate1.equals(cartesianCoordinate1));
	}

	@Test
	public void testGreatCentralAngle() {
		sphericCoordinate1 = SphericCoordinate.getInstance(new Phi(Math.toRadians(10)), new Theta(Math.toRadians(10)),
				new Radius(6360));
		sphericCoordinate2 = SphericCoordinate.getInstance(new Phi(Math.toRadians(50)), new Theta(Math.toRadians(50)),
				new Radius(6360));

		double centralAngle = sphericCoordinate1.getCentralAngle(sphericCoordinate2);
		assertTrue(compNumbers(centralAngle, 0.904669));
	}

	private boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}

	@Test
	public void testSphericCoordinateIsEqualIsTrue() {

		sphericCoordinate2 = SphericCoordinate.getInstance(sphericCoordinate1.getPhi(), sphericCoordinate1.getTheta(),
				sphericCoordinate1.getRadius());
		assertTrue(sphericCoordinate1.equals(sphericCoordinate2));
	}

	@Test
	public void testSphericCoordinateIsEqualIsFalse() {

		assertFalse(sphericCoordinate1.equals(sphericCoordinate2));
	}

	@Test
	public void testSpericCoordinatesEqualsisInterchangeability() {
		CartesianCoordinate c = sphericCoordinate1.asCastesianCoordinate();
		assertTrue(sphericCoordinate1.equals(c));
	}
	
	@Test
	public void testSphericCoordinateGetInstanceReturnsSameObjectWhenEqual() {
	sphericCoordinate1 = SphericCoordinate.getInstance(new Phi(Math.toRadians(50)), new Theta(Math.toRadians(50)),
			new Radius(6360));
	sphericCoordinate2 = SphericCoordinate.getInstance(new Phi(Math.toRadians(50)), new Theta(Math.toRadians(50)),
			new Radius(6360));
	assertTrue(sphericCoordinate1.hashCode() == sphericCoordinate2.hashCode());
	}
	@Test
	public void testSphericCoordinateGetInstanceReturnsDifferentObjectWhenNotEqual() {
	sphericCoordinate1 = SphericCoordinate.getInstance(new Phi(Math.toRadians(50)), new Theta(Math.toRadians(50)),
			new Radius(6360));
	sphericCoordinate2 = SphericCoordinate.getInstance(new Phi(Math.toRadians(20)), new Theta(Math.toRadians(50)),
			new Radius(6360));
	assertTrue(sphericCoordinate1.hashCode() != sphericCoordinate2.hashCode());
	}
}
