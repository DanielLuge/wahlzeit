package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	private final double decimalPlace = 1E-5;

	@Override
	public double getCentralAngle(Coordinate coordinate) {

		SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();
		double centralAngle = doGetCentralAngle(sphericCoordinate, sphericCoordinateCaller);

		return centralAngle;
	}

	protected double doGetCentralAngle(SphericCoordinate caller, SphericCoordinate call) {

		double sinTheta1 = Math.sin(caller.getTheta());
		double sinTheta2 = Math.sin(call.getTheta());
		double cosTheta1 = Math.cos(caller.getTheta());
		double cosTheta2 = Math.cos(call.getTheta());
		double cosPhi = Math.cos(caller.getPhi() - call.getPhi());
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
		double cartesianDistance = doGetCartesianDistance(cartesianCoordinateCall, cartesianCoordinateCaller);
		return cartesianDistance;
	}

	private double doGetCartesianDistance(CartesianCoordinate caller, CartesianCoordinate call) {
		double resultX = Math.pow((caller.getX() - call.getX()), 2);
		double resultY = Math.pow(caller.getY() - call.getY(), 2);
		double resultZ = Math.pow(caller.getZ() - call.getZ(), 2);

		double cartesianDistance = Math.sqrt(resultX + resultY + resultZ);
		return cartesianDistance;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();
		SphericCoordinate sphericCoordinateCall = coordinate.asSphericCoordinate();

		boolean thetaIsEquals = compNumbers(sphericCoordinateCaller.getTheta(), sphericCoordinateCall.getTheta());
		boolean phiIsEquals = compNumbers(sphericCoordinateCaller.getPhi(), sphericCoordinateCall.getPhi());
		boolean radiusIsEquals = compNumbers(sphericCoordinateCaller.getRadius(), sphericCoordinateCall.getRadius());

		return thetaIsEquals && phiIsEquals && radiusIsEquals;
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
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();

		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(sphericCoordinateCaller.getTheta());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sphericCoordinateCaller.getPhi());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sphericCoordinateCaller.getRadius());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
