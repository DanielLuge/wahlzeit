package org.wahlzeit.model;

/**
 * @invariant 0<= radius, 0<=theta <=180, 0<=phi<=180
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double phi;
	private double theta;
	private double radius;

	public SphericCoordinate(double phi, double theta, double radius) {
		super();
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}

	public double getPhi() {
		return phi;
	}

	public double getTheta() {
		return theta;
	}

	public double getRadius() {
		return radius;
	}

	/**
	 * @post return: ( x, y, z) !=Double.NaN
	 */
	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		assertClassInvariants();

		CartesianCoordinate coordinate = doTransformToCartesianCoordinate();

		coordinate.assertIsValidCoordinate();
		assertClassInvariants();
		return coordinate;
	}

	private CartesianCoordinate doTransformToCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);

		CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
		return coordinate;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	protected void assertClassInvariants() {
		if (!(this.getRadius() >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(this.getTheta() >= 0 && this.getTheta() <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(this.getPhi() >= 0 && this.getPhi() <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}

	@Override
	protected void assertIsValidCoordinate() {

		if (!(this.getRadius() >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(this.getTheta() >= 0 && this.getTheta() <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(this.getPhi() >= 0 && this.getPhi() <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}
}
