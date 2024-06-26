
package fitnessequipment.subscriber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import fitnessequipment.publisher.FitnessEquipmentInterface;

public class FitnessEquipmentActivator implements BundleActivator {

	ServiceReference equipmentServiceReference;

	Scanner scan = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {

		int publisherType, selected, type, exType;
		double totalPrice = 0, discount = 0, extraPrice = 0;
		float discountPercentage = (float) 0.05;
		ArrayList<String> selectedItems = new ArrayList<String>();

		equipmentServiceReference = bundleContext.getServiceReference(FitnessEquipmentInterface.class.getName());
		FitnessEquipmentInterface equipmentPublisher = (FitnessEquipmentInterface) bundleContext.getService(equipmentServiceReference);

		System.out.println("===================================================================================");
		System.out.println("=                                                                                 =");
		System.out.println("======================= Welcome to Home Fitness Solutions !! ======================");
		System.out.println("=                                                                                 =");
		System.out.println("===================================================================================\n");
		System.out.println("Press 1 to continue with Home Fitness Solutions packages.");
		System.out.println("Press 0 to exit.");

		try {
			System.out.print("Enter your choice: ");
			publisherType = scan.nextInt();
			System.out.println("_____________________________________________________________________________\n");

			if (publisherType == 1) {
				System.out.println("\n------------------------------------------------------------------------------------");
				System.out.println("-------------------------- Your Fitness Equipment Bundles --------------------------");
				System.out.println("------------------------------------------------------------------------------------\n");
				System.out.println("01. Basic Fitness Equipment Bundle: (LKR 15000.00) \n    * Dumbbells (2x5kg) \n    * Resistance Bands (Set of 3) \n    * Yoga Mat \n   * Jump Rope");
				System.out.println("02. Intermediate Fitness Equipment Bundle: (LKR 18000.00) \n    * Dumbbells (2x5kg, 2x10kg) \n    * Resistance Bands (Set of 5)) \n    * Yoga Mat \n    * Workout Bench \n    * Stability Ball");
				System.out.println("03. Advanced Bundle: Fitness Equipment (LKR 22000.00)\n    * Dumbbells (2x5kg, 2x10kg, 2x15kg) \n    * Resistance Bands (Set of 5) \n    * Yoga Mat \n    * Workout Bench \n    * Kettlebell \n    * TRX Suspension Trainer");
				System.out.println();

				System.out.println("(To exit and get the total, press 0.)");
				System.out.print("Enter the fitness equipment bundle you want to select: ");
				type = scan.nextInt();

				while (type != 0) {
					
					
					System.out.print("\nDo you want any extra items for the fitness equipment bundle? (Y/N): ");
					char isExtra = scan.next().charAt(0);

					
					if (isExtra == 'Y' || isExtra == 'y') {
						
						
						System.out.println("\n---------------------------------------------------------------------------");
						System.out.println("----------------------------- Extra Items ---------------------------------");
						System.out.println("---------------------------------------------------------------------------\n");
						System.out.println("1. Foam Roller - Helps with muscle recovery and flexibility.                   \t\tLKR 1500.00");
						System.out.println("2. Pull-Up Bar - Perfect for upper body strength training.                     \t\tLKR 3000.00");
						System.out.println("3. Medicine Ball - Adds versatility to your workouts.                          \t\tLKR 2000.00");
						System.out.println("4. Adjustable Weighted Vest - Intensify your workouts with added resistance.   \t\tLKR 4000.00");
						System.out.println("\n(Enter -1 to exit)");

						do {
							System.out.print("Enter the number of the extra item you want to select: ");
							exType = scan.nextInt();
	
							
							switch (exType) {
								case 1:
									extraPrice = 1500;
									break;
								case 2:
									extraPrice = 3000;
									break;
								case 3:
									extraPrice = 2000;
									break;
								case 4:
									extraPrice = 4000;
									break;
								default:
									extraPrice = 0;
							}
							
							totalPrice += extraPrice;
							
						} while (exType != -1);

						System.out.println("\n");
					}

					System.out.println("\n------------------------------------------------------------------------------------");
					System.out.println("------------------- Your Training Programs for Home Workouts -----------------------");
					System.out.println("------------------------------------------------------------------------------------\n");

					
					equipmentPublisher.displayEquipmentByCategory(type);

					System.out.println("\n(To quit the current category, enter -1.)");
					System.out.print("Enter the Training Programs for Home Workouts you want to select: ");
					selected = scan.nextInt();

					
					while (selected != -1) {
						
						totalPrice += equipmentPublisher.getEquipmentPrice(type, selected);
						selectedItems.add(equipmentPublisher.getEquipmentCategory(type, selected));
						
						System.out.print("Enter the Training Programs for Home Workouts you want to select: ");
						selected = scan.nextInt();
					}

					System.out.print("\nPress 0 to get the balance and buy next packages.\n");
					System.out.print("Enter the Training Programs for Home Workouts you want to purchase next: ");
					type = scan.nextInt();
				}
				
				discount = totalPrice * discountPercentage;
				double finalPrice = totalPrice - discount;
				
				System.out.println("\n************************************************************************************");
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("--------------------------------- Summary Report -----------------------------------");
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println("************************************************************************************\n");
				
				System.out.println("Selected Package:");
				for (String item : selectedItems) {
				    System.out.println("- " + item);
				}
				System.out.printf("\n%-20s %s", "Total Price:", "LKR " + String.format("%.2f", totalPrice));
				System.out.printf("\n%-20s %s", "Discount:", "LKR " + String.format("%.2f", discount));
				System.out.printf("\n%-20s %s", "Final Price:", "LKR " + String.format("%.2f", finalPrice));
				System.out.println("\n\n===========================================================================");
				
			} else if(publisherType == 0) {
				
				this.stop(bundleContext);
			}	
			
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Please enter an integer.");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Equipment Subscriber has stopped.");
		bundleContext.ungetService(equipmentServiceReference);
	}

}
