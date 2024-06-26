package challenges.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MonthlyChallengesImp implements MonthlyChallengesInterface {

    // Creating HashMaps to store different fitness challenge categories
    HashMap<String, Double> weightLossChallenges = new HashMap<>();
    HashMap<String, Double> muscleBuildingChallenges = new HashMap<>();
    // Add more categories as needed

    // Constructor to initialize the HashMaps with fitness challenges
    public MonthlyChallengesImp() {
        weightLossChallenges.put("30-Day Fat Burn Challenge", 4900.99);
        weightLossChallenges.put("Healthy Eating for Weight Loss", 3900.99);
        // Add more weight loss challenges

        muscleBuildingChallenges.put("Ultimate Muscle Gain Program", 5900.99);
        muscleBuildingChallenges.put("High-Intensity Strength Training", 4900.99);
        // Add more muscle building challenges
    }

    // Display fitness challenges based on the category number
    @Override
    public void displayChallengesByCategory(int num) {
        int count = 1;
        Map<String, Double> challengesMap;

        switch (num) {
            case 1:
                challengesMap = weightLossChallenges;
                break;
            case 2:
                challengesMap = muscleBuildingChallenges;
                break;
            // Add more cases for additional categories
            default:
                System.out.println("Invalid input");
                return;
        }

        for (Entry<String, Double> entry : challengesMap.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(count + ". " + key + " :- Rs " + value);
            count++;
        }
    }

    // Get price of the fitness challenge based on category and challenge number
    @Override
    public double getChallengePrice(int category, int challenge) {
        Map<String, Double> selectedCategory = null;
        switch (category) {
            case 1:
                selectedCategory = weightLossChallenges;
                break;
            case 2:
                selectedCategory = muscleBuildingChallenges;
                break;
            // Add more cases for additional categories
            default:
                return 0;
        }
        if (selectedCategory != null) {
            String selectedChallenge = selectedCategory.keySet().toArray()[challenge - 1].toString();
            return selectedCategory.get(selectedChallenge);
        }
        return 0;
    }

    // Get name of the fitness challenge based on category and challenge number
    @Override
    public String getChallengeCategory(int category, int challenge) {
        // Implement as needed based on the new fitness challenges
        return "";
    }
}
