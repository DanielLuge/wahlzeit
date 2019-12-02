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

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	protected void assertClassInvariants() {
		assert Double.isNaN(x) == false;
		assert Double.isNaN(x) == false;
		assert Double.isNaN(z) == false;

	}

	@Override
	protected void assertIsValidCoordinate() {
		assert Double.isNaN(x) == false;
		assert Double.isNaN(y) == false;
		assert Double.isNaN(z) == false;
	}

}
