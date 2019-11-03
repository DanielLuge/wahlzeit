package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.TellFriendTest;
import org.wahlzeit.model.AccessRightsTest;
import org.wahlzeit.model.CoordinateTest;
import org.wahlzeit.model.FlagReasonTest;
import org.wahlzeit.model.GenderTest;
import org.wahlzeit.model.GuestTest;
import org.wahlzeit.model.PhotoFilterTest;
import org.wahlzeit.model.TagsTest;
import org.wahlzeit.model.UserStatusTest;
import org.wahlzeit.model.ValueTest;
import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.LogBuilderTest;
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.testEnvironmentProvider.SysConfigProvider;
import org.wahlzeit.testEnvironmentProvider.UserServiceProvider;
import org.wahlzeit.testEnvironmentProvider.UserSessionProvider;
import org.wahlzeit.testEnvironmentProvider.WebFormHandlerProvider;
import org.wahlzeit.utils.StringUtilTest;
import org.wahlzeit.utils.VersionTest;

@RunWith(Suite.class)
//@SelectPackages({" org.wahlzeit.model","com.howtodoinjava.junit5.examples.packageB"}) 
@Suite.SuiteClasses({ 

    // package1
	TellFriendTest.class,
    
	//org.wahlzeit.model
	AccessRightsTest.class,
	CoordinateTest.class,
	FlagReasonTest.class,
	GenderTest.class,
	GuestTest.class,
	PhotoFilterTest.class,
	TagsTest.class,
	UserStatusTest.class,
	ValueTest.class,
	
	//org.wahlzeit.model.persistence
	DatastoreAdapterTest.class,
	
//	org.wahlzeit.services
	EmailAddressTest.class,
	LogBuilderTest.class,
	
//	org.wahlzeit.services.mailing
	EmailServiceTest.class,
	
	//org.wahlzeit.utils
	StringUtilTest.class,
	VersionTest.class,
	
})public class AllTests {

}
