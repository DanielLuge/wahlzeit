package org.wahlzeit.model;

public class Swimmer {
	protected SwimmerType swimmerType = null;

	private int id;
	private String club;

	public int getId() {
		return id;
	}

	public String getClub() {
		return club;
	}

	public SwimmerType getSwimmerType() {
		return swimmerType;
	}

	public void setSwimmerType(SwimmerType swimmerType) {
		this.swimmerType = swimmerType;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Swimmer(SwimmerType swimmerType, int id, String club) {
		this.swimmerType = swimmerType;
		this.id = id;
		this.club = club;
	}

	public SwimmerType getType() {
		return swimmerType;
	}

	public void setType(SwimmerType swimmerType) {
		this.swimmerType = swimmerType;
	}
}
