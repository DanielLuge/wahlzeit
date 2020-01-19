package org.wahlzeit.model;

import java.util.HashMap;

public class SwimmerManager {
	//evtl noch swimmers löschen
	HashMap<Integer, Swimmer> swimmers = new HashMap<Integer, Swimmer>();
	HashMap<String, SwimmerType> swimmerTypes = new HashMap<String, SwimmerType>();
	protected static SwimmerManager instance = null;

	private SwimmerManager() {
	}

	public static synchronized SwimmerManager getInstance() {
		if (instance == null) {
			instance = new SwimmerManager();
		}
		return instance;
	}

	public Swimmer createSwimmer(String typeName, int id, String club) {
		assertIsValidSwimmer(typeName, id, club);

		SwimmerType swimmerType = getSwimmerType(typeName);

		Swimmer result = swimmerType.createInstance(id, club);
		swimmers.put(result.getId(), result);
		return result;

	}
	

	private SwimmerType getSwimmerType(String typeName) {
		SwimmerType swimmerType = swimmerTypes.get(typeName);

		if (swimmerType == null) {
			swimmerType = new SwimmerType(typeName);
			swimmerTypes.put(typeName, swimmerType);
		}
		return swimmerType;
	}

	private void assertIsValidSwimmer(String typeName, int id, String club) {
		if ((typeName.isEmpty())) {
			throw new IllegalStateException("typeName is empty");
		}
		if (id <= 0) {
			throw new IllegalStateException("id must be bigger then 0");
		}
		if (club.isEmpty()) {
			throw new IllegalStateException("club is empty");
		}
	}
}
