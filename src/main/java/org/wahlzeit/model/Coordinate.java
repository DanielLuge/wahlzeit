package org.wahlzeit.model;

public class Coordinate {
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

	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getDistance(Coordinate coordinate) {
		double resultX = Math.pow((this.x - coordinate.x), 2);
		double resultY = Math.pow(this.y - coordinate.y, 2);
		double resultZ = Math.pow(this.z - coordinate.z, 2);

		double distance = Math.sqrt(resultX + resultY + resultZ);
		return distance;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coordinate) {
			return isEqual((Coordinate)obj);
		}else {
			return false;
		}
	}
	private boolean isEqual(Coordinate coordinate) {

		boolean result = false;
		if (this.getX() == coordinate.getX() && this.getY() == coordinate.getY() && this.getZ() == coordinate.getZ()) {
			result = true;
		}
		return result;
	}
}
