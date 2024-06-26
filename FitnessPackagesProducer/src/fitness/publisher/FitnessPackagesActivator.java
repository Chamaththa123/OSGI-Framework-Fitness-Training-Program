package fitness.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class FitnessPackagesActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Fitness Packages Publisher has Started.");

		FitnessPacakgesInterface fitnesspublisher= new FitnessPacakgesImpl();

		// Register service 
		pubServiceReg = bundleContext.registerService(FitnessPacakgesInterface.class.getName(),
				fitnesspublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Fitness Packages Publisher has Stoped.");

		// Unregister service 
		pubServiceReg.unregister();
	}

}
