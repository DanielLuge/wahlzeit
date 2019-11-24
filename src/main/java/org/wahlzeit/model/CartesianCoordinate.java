package org.wahlzeit.model;

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
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		double phi = Math.atan(y / x);
		double theta = Math.acos(z / radius);

		return new SphericCoordinate(phi, theta, radius);
	}

}
