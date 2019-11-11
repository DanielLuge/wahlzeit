package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class SwimmingPhotoFactory extends PhotoFactory {
	private static SwimmingPhotoFactory instance = null;
	private static final Logger log = Logger.getLogger(SwimmingPhotoFactory.class.getName());

	/**
	 * @methodtype factory
	 */
	@Override
	public SwimmingPhoto createPhoto() {
		return new SwimmingPhoto();
	}

	/**
	 * Creates a new swimming photo with the specified id
	 */
	@Override
	public SwimmingPhoto createPhoto(PhotoId id) {
		return new SwimmingPhoto(id);
	}

	protected SwimmingPhotoFactory() {
		// do nothing
	}

	/**
	 * Hidden singleton instance; needs to be initialized from the outside.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}

	/**
	 * Public singleton access method.
	 */
	public static synchronized SwimmingPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic SwimmingPhotoFactory").toString());
			setInstance(new SwimmingPhotoFactory());
		}

		return instance;
	}

	/**
	 * Method to set the singleton instance of SwimmingPhotoFactory.
	 */
	protected static synchronized void setInstance(SwimmingPhotoFactory swimmingPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize SwimmingPhotoFactory twice");
		}

		instance = swimmingPhotoFactory;
	}
}
