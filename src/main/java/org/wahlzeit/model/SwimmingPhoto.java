package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;

@Entity
public class SwimmingPhoto extends Photo {

	public String swimmStroke;
	public String swimmingPoolName;
	@Ignore
	public Swimmer swimmer;
	

	/**
	 * @methodtype constructor
	 */
	public SwimmingPhoto() {
	}

	/**
	 * @methodtype constructor
	 */
	public SwimmingPhoto(String swimStroke, String swimmmingPoolName) throws IllegalArgumentException {
		super();
		assertIsValidString(swimStroke);
		assertIsValidString(swimmmingPoolName);
		this.swimmStroke = swimStroke;
		this.swimmingPoolName = swimmmingPoolName;
	}
	public SwimmingPhoto(String swimStroke, String swimmmingPoolName, Swimmer swimmer) throws IllegalArgumentException {
		super();
		
		assertIsValidString(swimStroke);
		assertIsValidString(swimmmingPoolName);
		this.swimmStroke = swimStroke;
		this.swimmingPoolName = swimmmingPoolName;
		this.swimmer = swimmer;
	}
	public Swimmer getSwimmer() {
		return swimmer;
	}
	public void setSwimmer(Swimmer swimmer) {
		this.swimmer = swimmer;
	}


	public String getSwimmStroke() {
		return swimmStroke;
	}

	public void setSwimmStroke(String swimmStroke) {
		assertIsValidString(swimmStroke);
		this.swimmStroke = swimmStroke;
	}

	public String getSwimmingPoolName() {
		return swimmingPoolName;
	}

	public void setSwimmingPoolName(String swimmingPoolName) {
		assertIsValidString(swimmingPoolName);

		this.swimmingPoolName = swimmingPoolName;
	}

	/**
	 * @methodtype constructor with id
	 */
	public SwimmingPhoto(PhotoId myId) throws IllegalArgumentException {

		super(myId);
		assertIsPhotoId(myId);

		incWriteCount();
	}

	private void assertIsPhotoId(PhotoId myId) {
		if (!PhotoId.class.equals(myId.getClass())) {
			throw new IllegalArgumentException("Not of type PhotoId");
		}
	}

	void assertIsValidString(String string) {
		if (string == null) {
			throw new IllegalArgumentException("Argument is null");
		}
	}
}
