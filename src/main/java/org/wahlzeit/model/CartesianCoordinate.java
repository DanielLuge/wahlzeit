package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.utils.PatternInstance;

/**
 * @invariant (x, y, z) !=Double.NaN
 */
@PatternInstance(patternName = "Immutable", participants = { "CartesianCoordinate" })
public class CartesianCoordinate extends AbstractCoordinate {

	private static Set<CartesianCoordinate> instances = new HashSet<CartesianCoordinate>();

	private final double x;
	private final double y;
	private final double z;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	private CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}

	public static CartesianCoordinate getInstance(double x, double y, double z) {

		CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
		for (Iterator<CartesianCoordinate> it = instances.iterator(); it.hasNext();) {
			CartesianCoordinate f = it.next();
			if (f.equals(coordinate))

				coordinate = f;
		}
		synchronized (instances) {
			instances.add(coordinate);
		}
		return coordinate;
	}

	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		assertClassInvariants();
		return this;
	}

	/**
	 * @post returned Coordinate: 0<= radius, 0<=theta <=180, 0<=phi<=180
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();

		SphericCoordinate coordinate = doTransformToSphericCoordinate();

		coordinate.assertIsValidCoordinate();
		assertClassInvariants();

		return coordinate;
	}

	private SphericCoordinate doTransformToSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		double phi = Math.atan(y / x);
		double theta = Math.acos(z / (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2))));

		return SphericCoordinate.getInstance(phi, theta, radius);
	}

	@Override
	protected void assertClassInvariants() throws IllegalStateException {
		doAssertClassCoordinate(this);

	}

	@Override
	protected void assertIsValidCoordinate() {
		doAssertClassCoordinate(this);

	}

	private void doAssertClassCoordinate(CartesianCoordinate coordinate) {
		if (Double.isNaN(coordinate.x)) {
			throw new IllegalStateException("x is not a number");
		}
		if (Double.isNaN(coordinate.y)) {

			throw new IllegalStateException("x is not a number");
		}
		if (Double.isNaN(coordinate.z)) {

			throw new IllegalStateException("x is not a number");
		}
	}

}
