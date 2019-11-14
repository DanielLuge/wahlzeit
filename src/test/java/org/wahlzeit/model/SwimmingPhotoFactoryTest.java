package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;
import org.wahlzeit.testEnvironmentProvider.WebFormHandlerProvider;


@SuppressWarnings("deprecation")
public class SwimmingPhotoFactoryTest {

	   @ClassRule
	    public static SysConfigProvider sysConfigProvider = new SysConfigProvider();
	    @ClassRule
	    public static WebFormHandlerProvider webFormHandlerProvider = new WebFormHandlerProvider();

	    @Rule
	    public TestRule chain = RuleChain.
	            outerRule(new LocalDatastoreServiceTestConfigProvider()).
	            around(new RegisteredOfyEnvironmentProvider()).
	            around(new UserSessionProvider());


	@Test
	public void createSwimmingPhoto() {
		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
		SwimmingPhoto sp = spFactory.createPhoto();
		assertNotNull(sp);
	}

	@Test
	public void createSwimmingPhotoWithId() {
		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
		SwimmingPhoto sp = spFactory.createPhoto(new PhotoId(1234));
		assertNotNull(sp);
		assertEquals(1234, sp.id.value);
	}

	@Test
	public void testSavingSwimmingPhotoInCache() {
		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
		SwimmingPhoto sp = spFactory.createPhoto();

		SwimmingPhotoManager swManager = new SwimmingPhotoManager();
		swManager.doAddPhoto(sp);
		assertTrue(!swManager.getPhotoCache().isEmpty());

	}

	@Test
	public void testSavingMultipleSwimmingPhotoInCache() {
		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
		SwimmingPhoto sp = spFactory.createPhoto(new PhotoId(1234));
		SwimmingPhoto sp2 = spFactory.createPhoto();
		SwimmingPhoto sp3 = spFactory.createPhoto();

		SwimmingPhotoManager swManager = new SwimmingPhotoManager();
		swManager.doAddPhoto(sp);
		swManager.doAddPhoto(sp2);
		swManager.doAddPhoto(sp3);
		assertEquals(swManager.getPhotoCache().size(), 3);
		
		}
	@Test
	public void testIfSwimmingPhotoIsSavedAsSwimmingPhoto() {
		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
		PhotoId id = new PhotoId(1234);
		SwimmingPhoto sp = spFactory.createPhoto(id);

		SwimmingPhotoManager swManager = new SwimmingPhotoManager();
		try {
			swManager.addPhoto(sp);
		} catch (IOException e) {
			//should not happen
		}
		assertTrue(swManager.doGetPhotoFromId(id) instanceof SwimmingPhoto);
		}
	

	/*
	 * Loading SwimmingPhotos or even Photos is not possible by the following two
	 * approaches. Most likely because the datastore needs to be mocked. However
	 * even by extensive trying I was not possible to make it work.
	 */
//	@Test
//	public void testSwimmingPhotoLoading() throws IOException {
//		SwimmingPhotoFactory spFactory = SwimmingPhotoFactory.getInstance();
//		SwimmingPhoto sp = spFactory.createPhoto();
//		SwimmingPhotoManager swManager = new SwimmingPhotoManager();
//
//		swManager.doAddPhoto(sp);
//		swManager.photoCache.clear();
//		swManager.init();
//		
//		assertTrue(!swManager.photoCache.isEmpty());
//	}
//	@Test	
//	public void testPhotoLoading() throws IOException {
//		PhotoFactory factory = new PhotoFactory();
//		Photo p = factory.createPhoto();
//		PhotoManager manager = new PhotoManager();
//		
//		manager.doAddPhoto(p);
//		manager.photoCache.clear();
//		manager.init();
//		
//		assertTrue(!manager.photoCache.isEmpty());
//	}
}
