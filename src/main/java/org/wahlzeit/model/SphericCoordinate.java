package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.utils.PatternInstance;

/**
 * @invariant 0<= radius, 0<=theta <=180, 0<=phi<=180
 */
@PatternInstance(
		patternName = "Immutable",
		participants = {"SphericCoordinate"}
)
public class SphericCoordinate extends AbstractCoordinate {

	private final double phi;
	private final double theta;
	private final double radius;
	private static Set<SphericCoordinate> instances = new HashSet<SphericCoordinate>();

	private SphericCoordinate(double phi, double theta, double radius) {
		super();
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}

	public static SphericCoordinate getInstance(double phi, double theta, double radius) {

		SphericCoordinate coordinate = new SphericCoordinate(phi, theta, radius);
		for (Iterator<SphericCoordinate> it = instances.iterator(); it.hasNext();) {
			SphericCoordinate f = it.next();
			if (f.equals(coordinate))

				coordinate = f;
		}
		synchronized (instances) {
			instances.add(coordinate);
		}
		return coordinate;
	}

	public double getPhi() {
		return phi;
	}

	public double getTheta() {
		return theta;
	}

	public double getRadius() {
		return radius;
	}

	/**
	 * @post return: ( x, y, z) !=Double.NaN
	 */
	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		assertClassInvariants();

		CartesianCoordinate coordinate = doTransformToCartesianCoordinate();

		coordinate.assertIsValidCoordinate();
		assertClassInvariants();
		return coordinate;
	}

	private CartesianCoordinate doTransformToCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		CartesianCoordinate coordinate = CartesianCoordinate.getInstance(x, y, z);
		return coordinate;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	protected void assertClassInvariants() {
		if (!(radius >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(theta >= 0 && theta <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(phi >= 0 && phi <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}

	@Override
	protected void assertIsValidCoordinate() {

		if (!(radius >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(theta >= 0 && theta <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(phi >= 0 && phi <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}
}
