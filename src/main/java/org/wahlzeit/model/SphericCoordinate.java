package org.wahlzeit.model;

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

	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);

		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

}
