package org.wahlzeit.model;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;



@Entity
public class Swimmer {
	protected SwimmerType swimmerType = null;
	@Id
	Long id;
	private String club;

	public long getId() {
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

	public void setId(long id) {
		this.id = id;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Swimmer(SwimmerType swimmerType, long id, String club) {
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
