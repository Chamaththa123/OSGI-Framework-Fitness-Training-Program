package challenges.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;

import challenges.publisher.MonthlyChallengesInterface;
import challenges.publisher.MonthlyChallengesImp;

import org.osgi.framework.BundleContext;

public class MonthlyChallengesActivator implements BundleActivator {

    ServiceRegistration pubServiceReg;

    // The start Monthly Challenges Publisher
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Monthly Challenges Publisher has Started.");

        MonthlyChallengesInterface MonthlyChallengesPublisher = new MonthlyChallengesImp();

        // Register service
        pubServiceReg = bundleContext.registerService(MonthlyChallengesInterface.class.getName(),
                MonthlyChallengesPublisher, null);
    }

    // The stop Monthly Challenges Publisher
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Monthly Challenges Publisher has Stopped.");

        // Unregister service
        pubServiceReg.unregister();
    }

}
