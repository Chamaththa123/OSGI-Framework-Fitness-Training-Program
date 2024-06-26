package bootcamppackagespublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class BootCampPackagesActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Adventure Publisher has Started.");

		BootCampPackagesInterface AdventurePublisher = new BootCampPackageImp();

		// Register service 
		pubServiceReg = bundleContext.registerService(BootCampPackagesInterface.class.getName(),
				AdventurePublisher, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Adventure Publisher has Stoped.");

		// Unregister service 
		pubServiceReg.unregister();
	}

}
