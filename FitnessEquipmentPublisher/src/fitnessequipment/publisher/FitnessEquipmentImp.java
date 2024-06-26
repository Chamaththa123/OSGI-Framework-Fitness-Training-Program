package fitnessequipment.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fitnessequipment.publisher.FitnessEquipmentInterface;

public class FitnessEquipmentImp implements FitnessEquipmentInterface {
	
	HashMap<String, Double> BasicBundle = new HashMap<String, Double>();
	HashMap<String, Double> IntermediateBundle = new HashMap<String, Double>();
	HashMap<String, Double> AdvancedBundle = new HashMap<String, Double>();

	public FitnessEquipmentImp() {
		BasicBundle.put("Core Strengthening Challenge (LKR 1500.00): \n * Strengthen and tone your core muscles with a series of targeted exercises designed to improve stability and posture.", 16500.00);
		BasicBundle.put("Flexibility and Mobility Mastery (LKR 1000.00): \n * Enhance your flexibility and joint mobility through a variety of stretching routines, helping to prevent injuries and improve overall movement.", 16000.00);
		BasicBundle.put("Beginner's Bodyweight Blast (LKR 1200.00): \n * Kickstart your fitness journey with a combination of bodyweight exercises to build strength, endurance, and confidence.", 16200.00);

		IntermediateBundle.put("Total Body Transformation (LKR 2000.00): \n * Transform your physique with a comprehensive program targeting all major muscle groups, incorporating strength, cardio, and flexibility training.", 20000.00);
		IntermediateBundle.put("Cardio Blast Circuit (LKR 1500.00): \n * Ignite fat burning and improve cardiovascular fitness with high-intensity circuit workouts designed to torch calories and boost endurance.", 19500.00);
		IntermediateBundle.put("Flexibility and Mobility Mastery (LKR 1000.00): \n * Enhance your flexibility and joint mobility through a variety of stretching routines, helping to prevent injuries and improve overall movement.", 18000.00);
		IntermediateBundle.put("Strength Training for Beginners (LKR 1800.00): \n * Learn the fundamentals of strength training with a focus on proper technique and form, laying the foundation for muscle growth and development.", 19800.00);
		
		AdvancedBundle.put("Total Body Transformation (LKR 2000.00): \n * Achieve complete body transformation with an intense program incorporating strength, cardio, and flexibility exercises for maximum results.", 24000.00);
		AdvancedBundle.put("Strength and Power Surge (LKR 2500.00): \n * Develop explosive strength and power with dynamic workouts designed to increase muscle mass and enhance athletic performance.", 24500.00);
		AdvancedBundle.put("Cardio Blast Circuit (LKR 1500.00): \n * Ignite fat burning and improve cardiovascular fitness with high-intensity circuit workouts designed to torch calories and boost endurance.", 23500.00);
		AdvancedBundle.put("Advanced HIIT Workouts (LKR 2200.00): \n * Push your limits with high-intensity interval training sessions aimed at boosting metabolism, burning fat, and improving overall fitness.", 24200.00);
		AdvancedBundle.put("Yoga for Strength and Flexibility (LKR 1800.00): \n * Combine the benefits of yoga with strength training to improve muscle strength, flexibility, and mental focus.", 23800.00);
	}

	@Override
	public void displayEquipmentByCategory(int num) {
	    int count = 1;
	    Map<String, Double> equipmentMap;
	    
	    switch (num) {
	        case 1:
	        	equipmentMap = BasicBundle;
	            break;
	        case 2:
	        	equipmentMap = IntermediateBundle;
	            break;
	        case 3:
	        	equipmentMap = AdvancedBundle;
	            break;
	        default:
	            System.out.println("Invalid input");
	            return;
	    }
	    
	    for (Entry<String, Double> entry : equipmentMap.entrySet()) {
	        String key = entry.getKey();
	        Double value = entry.getValue();
	        System.out.println(count + ". " + key + " :- LKR " + value);
	        count++;
	    }   
	} 

	@Override
	public double getEquipmentPrice(int category, int item) {
	    Map<String, Double> selectedCategory = null;
	    switch (category) {
	        case 1:
	            selectedCategory = BasicBundle;
	            break;
	        case 2:
	            selectedCategory = IntermediateBundle;
	            break;
	        case 3:
	            selectedCategory = AdvancedBundle;
	            break;
			default:
				return 0;
	    }
	    if (selectedCategory != null) {
	        String selectedEquipment = selectedCategory.keySet().toArray()[item - 1].toString();
	        return selectedCategory.get(selectedEquipment);
	    }
	    return 0;
	}

	@Override
	public String getEquipmentCategory(int category, int item) {
		String name = "";
		if (category == 1) {
			switch (item) {
			case 1:
				name = "Basic Fitness Equipment Bundle - Core Strengthening Challenge";
				break;
			case 2:
				name = "Basic Fitness Equipment Bundle - Flexibility and Mobility Mastery";
				break;
			case 3:
				name = "Basic Fitness Equipment Bundle - Beginner's Bodyweight Blast";
				break;
			}
		} else if (category == 2) {
			switch (item) {
			case 1:
				name = "Intermediate Fitness Equipment Bundle - Total Body Transformation";
				break;
			case 2:
				name = "Intermediate Fitness Equipment Bundle - Cardio Blast Circuit ";
				break;
			case 3:
				name = "Intermediate Fitness Equipment Bundle - Flexibility and Mobility Mastery";
				break;
			case 4:
				name = "Intermediate Fitness Equipment Bundle - Strength Training for Beginners";
				break;
			}

		} else if (category == 3) {
			switch (item) {
			case 1:
				name = "Advanced Bundle: Fitness Equipment - Total Body Transformation";
				break;
			case 2:
				name = "Advanced Bundle: Fitness Equipment - Strength and Power Surge";
				break;
			case 3:
				name = "Advanced Bundle: Fitness Equipment - Cardio Blast Circuit";
				break;
			case 4:
				name = "Advanced Bundle: Fitness Equipment - Advanced HIIT Workouts";
				break;
			case 5:
				name = "Advanced Bundle: Fitness Equipment - Yoga for Strength and Flexibility";
				break;
			}
		}
		return name;
	}
}
