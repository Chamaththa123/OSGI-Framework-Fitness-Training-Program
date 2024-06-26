package challengers.subscriber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import challenges.publisher.MonthlyChallengesInterface;

public class FitnessActivator implements BundleActivator {

    ServiceReference challengesServiceReference;

    Scanner scan = new Scanner(System.in);

    public void start(BundleContext bundleContext) throws Exception {
        int publisherType, selected, category, exType;
        double totalPrice = 0, discount = 0, extraPrice = 0;
        float discountPercentage = (float) 0.05;
        ArrayList<String> selectedChallenges = new ArrayList<String>();

        challengesServiceReference = bundleContext.getServiceReference(MonthlyChallengesInterface.class.getName());
        MonthlyChallengesInterface challengesPublisher = (MonthlyChallengesInterface) bundleContext
                .getService(challengesServiceReference);

        System.out.println("\n======================= Welcome to Monthly Fitness Challenges Consumer! =======================\n");
        System.out.println("Press 1 to continue with monthly fitness challenges.");
        System.out.println("Press 0 to exit.");

        try {
            System.out.print("Enter your choice: ");
            publisherType = scan.nextInt();
            System.out.println("_____________________________________________________________________________\n");

            if (publisherType == 1) {

                System.out.println("\n------------------------- Categories Of Fitness Challenges ---------------------------");
                System.out.println("1. Weight Loss Challenges");
                System.out.println("2. Muscle Building Challenges");

                System.out.println("\n****************************\n");

                System.out.println("(To exit and get the total, press 0.)");
                System.out.print("Enter the category of fitness challenge you want to select: ");
                category = scan.nextInt();

                while (category != 0) {

                    System.out.print("\nDo you want any extra items for the fitness challenge? (Y/N): ");
                    char isExtra = scan.next().charAt(0);

                    if (isExtra == 'Y' || isExtra == 'y') {
                        System.out.println("\n------------------------------ Extra Items ------------------------------");
                        
                        System.out.println("1. Nutritional Plan\t\tRs 2900.99");
                        System.out.println("2. Premium Workout App\t\tRs 4900.99");
                        System.out.println("3. Personal Coaching Session\tRs 9900.99");
                        System.out.println("4. Fitness Tracker Device\tRs 7900.99");
                        System.out.println("\n****************************\n");
                        System.out.println("(Enter -1 to exit)");

                        do {
                            System.out.print("Enter the number of the extra item you want to select: ");
                            exType = scan.nextInt();

                            switch (exType) {
                                case 1:
                                    extraPrice = 2900.99;
                                    break;
                                case 2:
                                    extraPrice = 4900.99;
                                    break;
                                case 3:
                                    extraPrice = 9900.99;
                                    break;
                                case 4:
                                    extraPrice = 7900.99;
                                    break;
                                default:
                                    extraPrice = 0;
                            }

                            totalPrice += extraPrice;

                        } while (exType != -1);

                        System.out.println("_____________________________________________________________________________\n");
                    }

                    System.out.println("\n------------------------------ Fitness Challenges ------------------------------\n");
                    challengesPublisher.displayChallengesByCategory(category);

                    System.out.println("\n(To quit the current category, enter -1.)");
                    System.out.print("Enter the fitness challenge you want to select: ");
                    selected = scan.nextInt();

                    while (selected != -1) {
                        totalPrice += challengesPublisher.getChallengePrice(category, selected);
                        selectedChallenges.add(challengesPublisher.getChallengeCategory(category, selected));

                        System.out.print("Enter the fitness challenge you want to select: ");
                        selected = scan.nextInt();
                    }

                    System.out.print("\nPress 0 to get the balance and subscribe to more fitness challenges.\n");
                    System.out.print("Enter the category of fitness challenge you want to purchase next: ");
                    category = scan.nextInt();
                }

                discount = totalPrice * discountPercentage;
                double finalPrice = totalPrice - discount;

                System.out.println("\n------------------------------ Summary Report ------------------------------");
//                System.out.println("Selected Challenges:");
//                for (String challenge : selectedChallenges) {
//                    System.out.println("- " + challenge);
//                }
                System.out.printf("\n%-20s %s", "Total Price:", "Rs " + String.format("%.2f", totalPrice));
                System.out.printf("\n%-20s %s", "Discount:", "Rs " + String.format("%.2f", discount));
                System.out.printf("\n%-20s %s", "Final Price:", "Rs " + String.format("%.2f", finalPrice));
                System.out.println("\n\n===========================================================================\n");

            } else if (publisherType == 0) {
                this.stop(bundleContext);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Fitness Subscriber has stopped.");
        bundleContext.ungetService(challengesServiceReference);
    }
}
