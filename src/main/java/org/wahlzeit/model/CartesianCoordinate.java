package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	private double x;
	private double y;
	private double z;
	private final double decimalPlace = 1E-5;

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

	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate cartesianCoordinate = coordinate.asCastesianCoordinate();
		double resultX = Math.pow((this.x - cartesianCoordinate.x), 2);
		double resultY = Math.pow(this.y - cartesianCoordinate.y, 2);
		double resultZ = Math.pow(this.z - cartesianCoordinate.z, 2);

		double distance = Math.sqrt(resultX + resultY + resultZ);
		return distance;
	}

	public boolean isEqual(Coordinate coordinate) {
		CartesianCoordinate cartesianCoordinate = coordinate.asCastesianCoordinate();
		
		boolean xIsEquals = compNumbers(getX(), (cartesianCoordinate.getX()));
		boolean yIsEquals = compNumbers(getY(), (cartesianCoordinate.getY()));
		boolean zIsEquals = compNumbers(getZ(), (cartesianCoordinate.getZ()));

		return xIsEquals && yIsEquals && zIsEquals;
	}

	private boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CartesianCoordinate) {
			return isEqual((CartesianCoordinate) obj);
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

	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) +Math.pow(z, 2) );
		double phi = Math.atan(y/x);
		double theta = Math.acos(z/radius);
		
		return new SphericCoordinate( phi , theta, radius);
	}
	@Override
	public double getCentralAngle(Coordinate coordinate) {
		
		SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();
		double centralAngle = sphericCoordinateCaller.getCentralAngle(sphericCoordinate);
		return centralAngle;
	}


}
