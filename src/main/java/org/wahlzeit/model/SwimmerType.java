package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SwimmerType {
	private String name;
	private Swimmer swimmer;

	protected SwimmerType superType=null;
	protected Set<SwimmerType> subTypes = new HashSet<SwimmerType>();

	public Set<SwimmerType> getSubtypes() {
		return subTypes;
	}

	public SwimmerType getSuperType() {
		return superType;
	}

	public SwimmerType(String typeName) {
		this.name = typeName;
	}

	public Swimmer createInstance(int id, String club) {
		return new Swimmer(this, id, club);
	}

	public Swimmer getSwimmer() {
		return swimmer;
	}

	public void setSwimmer(Swimmer swimmer) {
		this.swimmer = swimmer;
	}

	public Set<SwimmerType> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(Set<SwimmerType> subTypes) {
		this.subTypes = subTypes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isSubtype() {
		return !(this.superType == (null));
	}

	public void addSubType(SwimmerType st) {
		assert (st != null);
		
		if(st.superType != null) {
			st.superType.subTypes.remove(st);
		}

		st.setSuperType(this);
		subTypes.add(st);
	}

	private void setSuperType(SwimmerType swimmerType) {
		this.superType = swimmerType;
	}
	
	public boolean hasInstance(Swimmer swimmer) {
		assert (swimmer != null);
		if (swimmer.getType() == this) {
			return true;
		}
		for (SwimmerType type : subTypes) {
			if (type.hasInstance(swimmer)) {
				return true;
			}
		}
		return false;
	}

}
