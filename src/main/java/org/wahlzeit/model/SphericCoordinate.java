package org.wahlzeit.model;
/**
 * @invariant  0<= radius, 0<=theta <=180, 0<=phi<=180
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
	}

	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
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

		assert this.getRadius() >= 0;

		assert this.getTheta() >= 0;
		assert this.getTheta() <= 180;

		assert this.getPhi() >= 0;
		assert this.getPhi() <= 360;
	}

	@Override
	protected void assertIsValidCoordinate() {

		assert this.getRadius() >= 0;

		assert this.getTheta() >= 0;
		assert this.getTheta() <= 180;

		assert this.getPhi() >= 0;
		assert this.getPhi() <= 360;
	}
}
