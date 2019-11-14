package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class SwimmingPhoto extends Photo {

	public String swimmStroke;
	public String swimmingPoolName;
	
	/**
	 * @methodtype constructor
	 */
	public SwimmingPhoto() {
	super();
	}
	
	/**
	 * @methodtype constructor with id
	 */
	public SwimmingPhoto (PhotoId myId) {
		super(myId);

		incWriteCount();
	}
}
