package org.wahlzeit.model;

/**
 * @invariant 0<= radius, 0<=theta <=180, 0<=phi<=180 || (x, y, z) !=Double.NaN
 */
public interface Coordinate {

	public CartesianCoordinate asCastesianCoordinate();

	public double getCartesianDistance(Coordinate coordinate);

	public SphericCoordinate asSphericCoordinate();

	public double getCentralAngle(Coordinate coordinate);

	public boolean isEqual(Coordinate coordinate);

}
