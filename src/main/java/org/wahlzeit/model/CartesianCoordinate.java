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

	public boolean isEqual(Coordinate coordinate) {
		CartesianCoordinate cartesianCoordinate = coordinate.asCastesianCoordinate();

		boolean xIsEquals = compNumbers(getX(), (cartesianCoordinate.getX()));
		boolean yIsEquals = compNumbers(getY(), (cartesianCoordinate.getY()));
		boolean zIsEquals = compNumbers(getZ(), (cartesianCoordinate.getZ()));

		return xIsEquals && yIsEquals && zIsEquals;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coordinate) {
			return isEqual((Coordinate) obj);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
