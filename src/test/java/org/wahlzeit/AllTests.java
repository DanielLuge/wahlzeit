package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.AccessRightsTest;
import org.wahlzeit.model.CoordinateTest;
import org.wahlzeit.model.FlagReasonTest;
import org.wahlzeit.model.GenderTest;
import org.wahlzeit.model.GuestTest;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.PhotoFilterTest;
import org.wahlzeit.model.TagsTest;
import org.wahlzeit.model.UserStatusTest;
import org.wahlzeit.model.ValueTest;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.ServiceTestSuite;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.services.mailing.ServicemailingTestSuite;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.TestEnvironmentProviderTestSuite;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;
import org.wahlzeit.testEnvironmentProvider.WebFormHandlerProvider;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.UtilesTestSuite;
import org.wahlzeit.utils.VersionTest;

@RunWith(Suite.class)
//@SelectPackages({" org.wahlzeit.model","com.howtodoinjava.junit5.examples.packageB"}) 
@Suite.SuiteClasses({ 
	HandlersTestSuite.class,
	ModelTestSuite.class,
	ModelPersistenceTestSuite.class,
	ServiceTestSuite.class,
	ServicemailingTestSuite.class,
	UtilesTestSuite.class
	
	
	
})public class AllTests {

}
