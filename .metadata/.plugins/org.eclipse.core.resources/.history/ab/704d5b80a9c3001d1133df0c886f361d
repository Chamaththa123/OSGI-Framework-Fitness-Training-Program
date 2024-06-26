package pub_adventure;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.BundleContext;

import pub_adventure.AdventurePublisher;
import pub_adventure.AdventurePubImpl;

public class AdventureActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;

	// The start Adventure Publisher
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Adventure Publisher has Started.");

		AdventurePublisher AdventurePublisher = new AdventurePubImpl();

		// Register service 
		pubServiceReg = bundleContext.registerService(AdventurePublisher.class.getName(),
				AdventurePublisher, null);
	}

	// The stop Adventure Publisher
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Adventure Publisher has Stoped.");

		// Unregister service 
		pubServiceReg.unregister();
	}

}
