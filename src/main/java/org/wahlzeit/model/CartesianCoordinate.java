package org.wahlzeit.model;

/**
 * @invariant (x, y, z) !=Double.NaN
 */
public class CartesianCoordinate extends AbstractCoordinate {
	private double x;
	private double y;
	private double z;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
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
		double theta = Math.acos(z / radius);

		return new SphericCoordinate(phi, theta, radius);
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
