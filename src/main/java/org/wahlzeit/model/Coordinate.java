package org.wahlzeit.model;

public class Coordinate {
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

	private boolean isEqual(Coordinate coordinate) {

		boolean xIsEquals = compNumbers(this.getX(),coordinate.getX());
		boolean yIsEquals = compNumbers(this.getY(), coordinate.getY());
		boolean zIsEquals = compNumbers(this.getZ(), coordinate.getZ());

		return xIsEquals && yIsEquals && zIsEquals;
	}
	private boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coordinate) {
			return isEqual((Coordinate)obj);
		}else {
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
