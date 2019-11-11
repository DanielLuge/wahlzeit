package org.wahlzeit.model;


public class SwimmingPhoto extends Photo {

	public String swimmStroke;
	public String swimmingPoolName;
	
	/**
	 * @methodtype constructor
	 */
	public SwimmingPhoto() {
		id = PhotoId.getNextId();
		incWriteCount();
	}
	
	/**
	 * @methodtype constructor with id
	 */
	public SwimmingPhoto (PhotoId myId) {
		id = myId;

		incWriteCount();
	}
}
