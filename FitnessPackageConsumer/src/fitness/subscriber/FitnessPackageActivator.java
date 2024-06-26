package fitness.subscriber;


import fitness.publisher.FitnessPacakgesInterface;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class FitnessPackageActivator implements BundleActivator {

	// Declare service reference variable
    ServiceReference fitnessServiceReference;

    // Declare scanner object for user input
    Scanner scan = new Scanner(System.in);

    // Start method for bundle activation
    public void start(BundleContext bundleContext) throws Exception {

        // Declare and initialize variables
        int publisherType, selected, type, exType;
        double totalPrice = 0, discount = 0, extraPrice = 0;
        float discountPercentage = (float) 0.05;
        ArrayList<String> selectedPrograms = new ArrayList<String>();

        // Get service reference for Fitness Packages interface
        fitnessServiceReference = bundleContext.getServiceReference( FitnessPacakgesInterface.class.getName());
        FitnessPacakgesInterface fitnessPublisher = ( FitnessPacakgesInterface) bundleContext.getService(fitnessServiceReference);

        System.out.println("\n======================= Welcome to Fitness Packages Consumer! =======================\n");
        System.out.println("Press 1 to continue with fitness packages.");
        System.out.println("Press 0 to exit.");

        try {
            System.out.print("Enter your choice: ");
            publisherType = scan.nextInt();
            System.out.println("_____________________________________________________________________________\n");

            if (publisherType == 1) {

                System.out.println("\n------------------------- Categories Of Fitness Programs ---------------------------");
                System.out.println("1. Cardio Workouts");
                System.out.println("2. Strength Training");
                System.out.println("3. Yoga and Pilates");
                System.out.println("4. CrossFit\n");
                System.out.println("****************************");
                System.out.println();

                System.out.println("(To exit and get the total, press 0.)");
                System.out.print("Enter the category of fitness program you want to select: ");
                type = scan.nextInt();

                while (type != 0) {
                    
                    // Get user input for extra activities selection
                    System.out.print("\nDo you want any extra activities for the fitness program? (Y/N): ");
                    char isExtra = scan.next().charAt(0);

                    // If user wants extra activities
                    if (isExtra == 'Y' || isExtra == 'y') {
                        
                        // Display extra activities and their prices
                        System.out.println("\n------------------------------ Extra Stuff ------------------------------");
                        System.out.println("1. Personal Training Session \t\tLKR 2500.00");
                        System.out.println("2. Fitness Assessment            \t\tLKR 1500.00");
                        System.out.println("3. Nutritional Plan \t\tLKR 2000.00\n");
                        System.out.println("****************************\n");
                        System.out.println("\n(Enter -1 to exit)");

                        do {
                            System.out.print("Enter the number of the extra activities you want to select: ");
                            exType = scan.nextInt();

                            // Calculate and add extra item price to total price
                            switch (exType) {
                                case 1:
                                    extraPrice = 2500;
                                    break;
                                case 2:
                                    extraPrice = 1500;
                                    break;
                                case 3:
                                    extraPrice = 2000;
                                    break;
                                default:
                                    extraPrice = 0;
                            }
                            
                            totalPrice += extraPrice;
                            
                        } while (exType != -1);

                        System.out.println("_____________________________________________________________________________\n");
                    }

                    System.out.println("\n------------------------------ Fitness Programs ------------------------------\n");
                    // Display fitness programs under user's selected category
                    fitnessPublisher.displayFitnessProgramsByCategory(type);

                    System.out.println("\n(To quit the current category, enter -1.)");
                    System.out.print("Enter the fitness program you want to select: ");
                    selected = scan.nextInt();

                    // Loop through selected fitness programs
                    while (selected != -1) {
                        // Calculate and add fitness program price to total price
                        totalPrice += fitnessPublisher.getProgramPrice(type, selected);
                        selectedPrograms.add(fitnessPublisher.getProgramCategory(type, selected));
                        
                        System.out.print("Enter the fitness program you want to select: ");
                        selected = scan.nextInt();
                    }

                    System.out.print("\nPress 0 to get the balance and buy more fitness packages.\n");
                    System.out.print("Enter the category of fitness program you want to purchase next: ");
                    type = scan.nextInt();
                }
                
                discount = totalPrice * discountPercentage;
                double finalPrice = totalPrice - discount;
                
                System.out.println("\n------------------------------ Summary Report ------------------------------");
                System.out.println("Selected Programs:");
                for (String program : selectedPrograms) {
                    System.out.println("- " + program);
                }
                System.out.printf("\n%-20s %s", "Total Price:", "LKR " + String.format("%.2f", totalPrice));
                System.out.printf("\n%-20s %s", "Discount:", "LKR " + String.format("%.2f", discount));
                System.out.printf("\n%-20s %s", "Final Price:", "LKR " + String.format("%.2f", finalPrice));
                System.out.println("\n\n===========================================================================");
                
            } else if(publisherType == 0) {
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
        System.out.println("Fitness Subscriber has stopped.");
        bundleContext.ungetService(fitnessServiceReference);
    }

}

