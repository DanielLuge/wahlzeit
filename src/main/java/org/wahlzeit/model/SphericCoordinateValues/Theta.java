package org.wahlzeit.model.SphericCoordinateValues;

import java.util.HashMap;

public class Theta {
	private final double decimalPlace = 1E-5;

	final double value;
	private static HashMap instances;
	public Theta(double theta) {
		super();
		this.value = theta;
	}

	public double getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theta other = (Theta) obj;
		if (!compNumbers(value, other.value))
			return false;
		return true;
	}
	protected boolean compNumbers(double x, double y) {
		return Math.abs(x - y) < decimalPlace;
	}


}
