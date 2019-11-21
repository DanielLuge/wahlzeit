package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
	private final double decimalPlace = 1E-5;

	@Override
	public double getCentralAngle(Coordinate coordinate) {

		SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();
		double centralAngle = doGetCentralAngle(sphericCoordinate, sphericCoordinateCaller);

		return centralAngle;
	}

	protected  double doGetCentralAngle(SphericCoordinate sphericCoordinate,
			SphericCoordinate sphericCoordinateCaller) {
		
		double sinTheta1 = Math.sin(sphericCoordinate.getTheta());
		double sinTheta2 = Math.sin(sphericCoordinateCaller.getTheta());
		double cosTheta1 = Math.cos(sphericCoordinate.getTheta());
		double cosTheta2 = Math.cos(sphericCoordinateCaller.getTheta());
		double cosPhi = Math.cos(sphericCoordinate.getPhi() - sphericCoordinateCaller.getPhi());
		// for distance the central Angle must be multiplied by the earth radius
		double centralAngle = Math.acos(sinTheta1 * sinTheta2 + cosTheta1 * cosTheta2 * cosPhi);
		return centralAngle;
	}
	protected boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate cartesianCoordinateCaller = this.asCastesianCoordinate();
		CartesianCoordinate cartesianCoordinateCall = coordinate.asCastesianCoordinate();
		double cartesianDistance = doGetCartesianDistance(cartesianCoordinateCaller, cartesianCoordinateCall);
		return cartesianDistance;
	}
	
	private double doGetCartesianDistance(CartesianCoordinate caller, CartesianCoordinate call) {
		double resultX = Math.pow((caller.getX() - call.getX()), 2);
		double resultY = Math.pow(caller.getY() - call.getY(), 2);
		double resultZ = Math.pow(caller.getZ() - call.getZ(), 2);

		double cartesianDistance = Math.sqrt(resultX + resultY + resultZ);
		return cartesianDistance;
	}

}
