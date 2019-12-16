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
import org.wahlzeit.utils.PatternInstance;

/**
 * @invariant (x, y, z) !=Double.NaN
 */
@PatternInstance(
		patternName = "Immutable",
		participants = {"CartesianCoordinate"}
)
public class CartesianCoordinate extends AbstractCoordinate {

	private static Set<CartesianCoordinate> instances = new HashSet<CartesianCoordinate>();

	private final X x;
	private final Y y;
	private final Z z;

	public double getX() {
		return x.getValue();
	}

	public double getY() {
		return y.getValue();
	}

	public double getZ() {
		return z.getValue();
	}

	private CartesianCoordinate(X x, Y y, Z z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}

	public static CartesianCoordinate getInstance(X x, Y y, Z z) {

		CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
		for (Iterator<CartesianCoordinate> it = instances.iterator(); it.hasNext();) {
			CartesianCoordinate f = it.next();
			if (f.equals(coordinate))

				coordinate = f;
		}
		synchronized (instances) {
			instances.add(coordinate);
		}
		return coordinate;
	}



	@Override
	public CartesianCoordinate asCastesianCoordinate() {
		assertClassInvariants();
		return this;
	}

	/**
	 * @post returned Coordinate: 0<= radius, 0<=theta <=180, 0<=phi<=180
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();

		SphericCoordinate coordinate = doTransformToSphericCoordinate();

		coordinate.assertIsValidCoordinate();
		assertClassInvariants();

		return coordinate;
	}

	private SphericCoordinate doTransformToSphericCoordinate() {
		Radius radius = new Radius(
				Math.sqrt(Math.pow(x.getValue(), 2) + Math.pow(y.getValue(), 2) + Math.pow(z.getValue(), 2)));
		Phi phi = new Phi(Math.atan(y.getValue() / x.getValue()));
		Theta theta = new Theta(Math.acos(z.getValue()
				/ (Math.sqrt(Math.pow(x.getValue(), 2) + Math.pow(y.getValue(), 2) + Math.pow(z.getValue(), 2)))));

		return SphericCoordinate.getInstance(phi, theta, radius);
	}

	@Override
	protected void assertClassInvariants() throws IllegalStateException {
		doAssertClassCoordinate(this);

	}

	@Override
	protected void assertIsValidCoordinate() {
		doAssertClassCoordinate(this);

	}

	private void doAssertClassCoordinate(CartesianCoordinate coordinate) {
		if (Double.isNaN(coordinate.x.getValue())) {
			throw new IllegalStateException("x is not a number");
		}
		if (Double.isNaN(coordinate.y.getValue())) {

			throw new IllegalStateException("x is not a number");
		}
		if (Double.isNaN(coordinate.z.getValue())) {

			throw new IllegalStateException("x is not a number");
		}
	}

}
