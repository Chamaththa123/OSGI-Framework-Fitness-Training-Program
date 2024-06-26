package fitness.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FitnessPacakgesImpl implements FitnessPacakgesInterface{

	HashMap<String, Double> cardioWorkouts = new HashMap<>();
    HashMap<String, Double> strengthTraining = new HashMap<>();
    HashMap<String, Double> yogaAndPilates = new HashMap<>();
    HashMap<String, Double> crossFit = new HashMap<>();

    // Constructor to initialize the HashMaps with fitness packages and their prices
    public FitnessPacakgesImpl() {
        cardioWorkouts.put("High-Intensity Interval Training (HIIT)", 2000.00);
        cardioWorkouts.put("Spinning Class", 2500.00);
        cardioWorkouts.put("Kickboxing", 2200.00);
        cardioWorkouts.put("Zumba", 1800.00);

        strengthTraining.put("Weightlifting", 1800.00);
        strengthTraining.put("Bodyweight Exercises", 1500.00);
        strengthTraining.put("Powerlifting", 2200.00);
        strengthTraining.put("Circuit Training", 2000.00);

        yogaAndPilates.put("Vinyasa Yoga", 1600.00);
        yogaAndPilates.put("Hatha Yoga", 1700.00);
        yogaAndPilates.put("Pilates", 1900.00);

        crossFit.put("CrossFit WOD", 2400.00);
        crossFit.put("CrossFit Endurance", 2300.00);
        crossFit.put("CrossFit Gymnastics", 2200.00);
    }

    // Display fitness programs by category
    @Override
    public void displayFitnessProgramsByCategory(int category) {
        int count = 1;
        Map<String, Double> fitnessMap;
        
        switch (category) {
            case 1:
                fitnessMap = cardioWorkouts;
                break;
            case 2:
                fitnessMap = strengthTraining;
                break;
            case 3:
                fitnessMap = yogaAndPilates;
                break;
            case 4:
                fitnessMap = crossFit;
                break;
            default:
                System.out.println("Invalid input");
                return;
        }
        
        for (Entry<String, Double> entry : fitnessMap.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(count + ". " + key + " :- LKR " + value);
            count++;
        }
    }

    // Get price of the fitness program based on category and program number
    @Override
    public double getProgramPrice(int category, int program) {
        Map<String, Double> selectedCategory = null;
        switch (category) {
            case 1:
                selectedCategory = cardioWorkouts;
                break;
            case 2:
                selectedCategory = strengthTraining;
                break;
            case 3:
                selectedCategory = yogaAndPilates;
                break;
            case 4:
                selectedCategory = crossFit;
                break;
            default:
                return 0;
        }
        if (selectedCategory != null) {
            String selectedProgram = (String) selectedCategory.keySet().toArray()[program - 1];
            return selectedCategory.get(selectedProgram);
        }
        return 0;
    }

    // Get name of the fitness program based on category and program number
    @Override
    public String getProgramCategory(int category, int program) {
        String name = "";
        switch (category) {
            case 1:
                switch (program) {
                    case 1:
                        name = "High-Intensity Interval Training (HIIT)";
                        break;
                    case 2:
                        name = "Spinning Class";
                        break;
                    case 3:
                        name = "Kickboxing";
                        break;
                    case 4:
                        name = "Zumba";
                        break;
                }
                break;
            case 2:
                switch (program) {
                    case 1:
                        name = "Weightlifting";
                        break;
                    case 2:
                        name = "Bodyweight Exercises";
                        break;
                    case 3:
                        name = "Powerlifting";
                        break;
                    case 4:
                        name = "Circuit Training";
                        break;
                }
                break;
            case 3:
                switch (program) {
                    case 1:
                        name = "Vinyasa Yoga";
                        break;
                    case 2:
                        name = "Hatha Yoga";
                        break;
                    case 3:
                        name = "Pilates";
                        break;
                }
                break;
            case 4:
                switch (program) {
                    case 1:
                        name = "CrossFit WOD";
                        break;
                    case 2:
                        name = "CrossFit Endurance";
                        break;
                    case 3:
                        name = "CrossFit Gymnastics";
                        break;
                }
                break;
        }
        return name;
    }

}
