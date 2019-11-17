package org.wahlzeit.model;

public interface Coordinate {

	public CartesianCoordinate asCastesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate);

	public SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate);

	public boolean isEqual(Coordinate coordinate);

}
