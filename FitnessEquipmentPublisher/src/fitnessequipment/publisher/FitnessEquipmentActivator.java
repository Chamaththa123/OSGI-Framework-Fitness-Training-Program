package fitnessequipment.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.ServiceRegistration;

import fitnessequipment.publisher.FitnessEquipmentImp;
import fitnessequipment.publisher.FitnessEquipmentInterface;

import org.osgi.framework.BundleContext;

public class FitnessEquipmentActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Equipment Publisher has Started.");

		FitnessEquipmentInterface equipmentPublisher = new FitnessEquipmentImp();

		pubServiceReg = bundleContext.registerService(FitnessEquipmentInterface.class.getName(),
				equipmentPublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Equipment Publisher has Stoped.");

		pubServiceReg.unregister();
	}

}
