package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.ModelPersistenceTestSuite;
import org.wahlzeit.services.ServiceTestSuite;
import org.wahlzeit.services.mailing.ServicemailingTestSuite;
import org.wahlzeit.utils.UtilesTestSuite;

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
