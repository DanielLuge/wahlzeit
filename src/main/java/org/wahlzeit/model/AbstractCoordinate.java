package org.wahlzeit.model;

/**
 * @invariant 0<= radius, 0<=theta <=180, 0<=phi<=180 || (x, y, z) !=Double.NaN
 */
public abstract class AbstractCoordinate implements Coordinate {
	private final double decimalPlace = 1E-5;

	protected abstract void assertClassInvariants();

	protected abstract void assertIsValidCoordinate();

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		assertClassInvariants();
		SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();

		double centralAngle = doGetCentralAngle(sphericCoordinate, sphericCoordinateCaller);

		assertIsValidAngle(centralAngle);
		assertClassInvariants();

		return centralAngle;
	}

	private void assertIsValidAngle(double centralAngle) throws IllegalArgumentException {
		if (!(centralAngle >= Math.toRadians(0)) && !(centralAngle <= 2 * Math.PI)) {
			throw new IllegalStateException("Centralangle has non valid value");
		}
	}

	/**
	 * @pre caller and call: 0<= radius, 0<=theta <=180, 0<=phi<=180
	 * @post 0 <= return <= 2 * Math.PI
	 */
	protected double doGetCentralAngle(SphericCoordinate caller, SphericCoordinate call) {

		double sinTheta1 = Math.sin(caller.getTheta().getValue());
		double sinTheta2 = Math.sin(call.getTheta().getValue());
		double cosTheta1 = Math.cos(caller.getTheta().getValue());
		double cosTheta2 = Math.cos(call.getTheta().getValue());
		double cosPhi = Math.cos(caller.getPhi().getValue() - call.getPhi().getValue());
		// for distance the central Angle must be multiplied by the earth radius
		double centralAngle = Math.acos(sinTheta1 * sinTheta2 + cosTheta1 * cosTheta2 * cosPhi);
		return centralAngle;
	}

	protected boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		assertClassInvariants();

		CartesianCoordinate cartesianCoordinateCaller = this.asCastesianCoordinate();
		CartesianCoordinate cartesianCoordinateCall = coordinate.asCastesianCoordinate();

		cartesianCoordinateCaller.assertIsValidCoordinate();
		cartesianCoordinateCall.assertIsValidCoordinate();

		double cartesianDistance = doGetCartesianDistance(cartesianCoordinateCall, cartesianCoordinateCaller);

		assertIsValidDistance(cartesianDistance);
		assertClassInvariants();

		return cartesianDistance;
	}

	private void assertIsValidDistance(double cartesianDistance) {
		if (!(cartesianDistance >= 0)) {
			throw new IllegalStateException("Distance cannot be <0");
		}

	}

	/**
	 * @pre x, y, z!= Double.NaN
	 * @post 0 <= return
	 */

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

		boolean thetaIsEquals = sphericCoordinateCaller.getTheta().equals(sphericCoordinateCall.getTheta());
		boolean phiIsEquals = sphericCoordinateCaller.getPhi().equals(sphericCoordinateCall.getPhi());
		boolean radiusIsEquals = sphericCoordinateCaller.getRadius().equals(sphericCoordinateCall.getRadius());

		return thetaIsEquals && phiIsEquals && radiusIsEquals;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Coordinate) {
			assertClassInvariants();

			return isEqual((Coordinate) obj);

		} else {
			return false;
		}
	}

//	@Override
//	public int hashCode() {
//		SphericCoordinate sphericCoordinateCaller = this.asSphericCoordinate();
//
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(sphericCoordinateCaller.getTheta());
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(sphericCoordinateCaller.getPhi());
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(sphericCoordinateCaller.getRadius());
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}

}
