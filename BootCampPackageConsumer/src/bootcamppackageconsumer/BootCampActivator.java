package bootcamppackageconsumer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import bootcamppackagespublisher.BootCampPackagesInterface;


public class BootCampActivator implements BundleActivator {

	// Declare service reference variable
	ServiceReference bootCampServiceReference;

	// Declare scanner object for user input
	Scanner scan = new Scanner(System.in);

	// Start method for bundle activation
	public void start(BundleContext bundleContext) throws Exception {

		// Declare and initialize variables
		int publisherType, selected, type, mainType, option;
		double totalPrice = 0, discount = 0, admitionAmount = 0;
		float discountPercentage = (float) 0.05;
		ArrayList<String> selectedPlaces = new ArrayList<String>();

		// Get service reference for Adventure Packages interface
		bootCampServiceReference = bundleContext.getServiceReference(BootCampPackagesInterface.class.getName());
		BootCampPackagesInterface bootCampPublisher = (BootCampPackagesInterface) bundleContext.getService(bootCampServiceReference);

		System.out.println("\n======================= Welcome to Bootcamp Packages Consumer! =======================\n");
		System.out.println("Press 1 to continue with bootcamp packages.");
		System.out.println("Press 0 to exit.");

		try {
			System.out.print("Enter your choice: ");
			publisherType = scan.nextInt();
			System.out.println("_____________________________________________________________________________\n");

			if (publisherType == 1) {
						
				// Display extra items and their prices
				System.out.println("\n------------------------------ Chose Type ------------------------------");
				System.out.println("1. Bootcamp \t\tLKR 1000.00");
				System.out.println("2. Retreats            \t\tLKR 2000.00");
				System.out.println("****************************\n");
				System.out.println("\n(Enter -1 to exit)");

				System.out.print("Enter the number which type you prefer: ");
				mainType = scan.nextInt();

				// Calculate and add extra item price to total price
				switch (mainType) {
					case 1:
						admitionAmount = 1000;
						break;
					case 2:
						admitionAmount = 2000;
						break;
					default:
						admitionAmount = 0;
						System.out.println("Invalide Input Program will end ..");
						this.stop(bundleContext);
				}
						
				totalPrice += admitionAmount;

				System.out.println("_____________________________________________________________________________\n");
				if (mainType == 1) {
					bootCampPublisher.displayBootCampByCategory(mainType);
				} 
				else if (mainType == 2) {
					bootCampPublisher.displayBootCampByCategory(mainType);
				} else {
					System.out.println("Invalide Input Program will end ..");
					this.stop(bundleContext);
				} 
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				double price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Accomadation__________________________________________\n");
				mainType = 3;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Meals__________________________________________\n");
				System.out.println("___________________________________lean Proteins__________________________________________\n");
				mainType = 4;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Meals__________________________________________\n");
				System.out.println("___________________________________Grains_________________________________________\n");
				mainType = 5;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Meals__________________________________________\n");
				System.out.println("___________________________________Health Fats_________________________________________\n");
				mainType = 6;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Meals__________________________________________\n");
				System.out.println("___________________________________Vegitable_________________________________________\n");
				mainType = 7;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.println("___________________________________Meals__________________________________________\n");
				System.out.println("___________________________________Fruits_________________________________________\n");
				mainType = 8;
				bootCampPublisher.displayBootCampByCategory(mainType);
				System.out.print("Enter the number which type you prefer: ");
				option = scan.nextInt();
				price = bootCampPublisher.getBootCampPrice(mainType, option);
				totalPrice += price;
				
				System.out.print("\nPress 0 to get the total of Bootcamp Accomadation packages.\n");
				type = scan.nextInt();
				
				System.out.println("\n------------------------------ Summary Report ------------------------------");
				System.out.println("Total is : " + totalPrice);
				
				
			} else if (publisherType == 0) {
				// If user wants to exit, stop bundle activation
				this.stop(bundleContext);
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Please enter an integer.");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Stop method for bundle deactivation
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Bootcamp Subscriber has stopped.");
		bundleContext.ungetService(bootCampServiceReference);
	}

}
