package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

		AccessRightsTest.class,
		CoordinateTest.class,
		FlagReasonTest.class,
		GenderTest.class,
		GuestTest.class,
		PhotoFilterTest.class,
		TagsTest.class,
		UserStatusTest.class,
		ValueTest.class,
		SwimmingPhotoFactoryTest.class

})
public class ModelTestSuite {

}