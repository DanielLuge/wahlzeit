package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.model.CartesianCoordinateValues.X;
import org.wahlzeit.model.CartesianCoordinateValues.Y;
import org.wahlzeit.model.CartesianCoordinateValues.Z;
import org.wahlzeit.model.SphericCoordinate2.Phi;
import org.wahlzeit.model.SphericCoordinate2.Radius;
import org.wahlzeit.model.SphericCoordinate2.Theta;

/**
 * @invariant 0<= radius, 0<=theta <=180, 0<=phi<=180
 */
public class SphericCoordinate extends AbstractCoordinate {

	private final Phi phi;
	private final Theta theta;
	private final Radius radius;
	private static Set<SphericCoordinate> instances = new HashSet<SphericCoordinate>();

	private SphericCoordinate(Phi phi, Theta theta, Radius radius) {
		super();
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}

	public static SphericCoordinate getInstance(Phi phi, Theta theta, Radius radius) {

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

	public Phi getPhi() {
		return phi;
	}

	public Theta getTheta() {
		return theta;
	}

	public Radius getRadius() {
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
		double xValue = radius.getValue() * Math.sin(theta.getValue()) * Math.cos(phi.getValue());
		double yValue = radius.getValue() * Math.sin(theta.getValue()) * Math.sin(phi.getValue());
		double zValue = radius.getValue() * Math.cos(theta.getValue());

		CartesianCoordinate coordinate = CartesianCoordinate.getInstance(new X(xValue), new Y(yValue), new Z(zValue));
		return coordinate;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	protected void assertClassInvariants() {
		if (!(radius.getValue() >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(theta.getValue() >= 0 && theta.getValue() <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(phi.getValue() >= 0 && phi.getValue() <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}

	@Override
	protected void assertIsValidCoordinate() {

		if (!(radius.getValue() >= 0)) {
			throw new IllegalStateException("Radius is <0");
		}
		if (!(theta.getValue() >= 0 && theta.getValue() <= 180)) {
			throw new IllegalStateException("Theta is not in valid space");
		}
		if (!(phi.getValue() >= 0 && phi.getValue() <= 360)) {
			throw new IllegalStateException("Phi is not in valid space");
		}
	}
}
