package bootcamppackagespublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BootCampPackageImp implements BootCampPackagesInterface {
	// Creating HashMaps to store different adventure categories
	HashMap<String, Double> bootCamp = new HashMap<String, Double>();
	HashMap<String, Double> retreats = new HashMap<String, Double>();
	HashMap<String, Double> accomadation = new HashMap<String, Double>();
	HashMap<String, Double> leanProteins = new HashMap<String, Double>();
	HashMap<String, Double> grains = new HashMap<String, Double>();
	HashMap<String, Double> healthyFats = new HashMap<String, Double>();
	HashMap<String, Double> vegitable = new HashMap<String, Double>();
	HashMap<String, Double> fruits = new HashMap<String, Double>();
	
	public BootCampPackageImp() {
		bootCamp.put("Boxing Bootcamp", 12000.00);
		bootCamp.put("Patner Chalage Bootcamp", 15000.00);
		bootCamp.put("Jungle Dancing", 16000.00);
		
		retreats.put("Samanala Mountan - Yoga", 5000.00);
		retreats.put("Health Food Cooking Class", 8000.00);
		retreats.put("Walsking Team", 3000.00);
		retreats.put("Massage and SPA treatments", 24000.00);

		accomadation.put("Cabine", 9000.00);
		accomadation.put("Tent", 5000.00);
		
		leanProteins.put("Grilled Checken", 150.00);
		leanProteins.put("Turkey", 200.00);
		leanProteins.put("Fish", 130.00);
		leanProteins.put("Tofu for Vegitarian", 120.00);

		grains.put("Quinoa",100.00);
		grains.put("Brown rice", 80.00);
		grains.put("Farro", 120.00);
		grains.put("wheat pasta", 70.00);
		
		healthyFats.put("Avocado", 120.00);
		healthyFats.put("Olive oil", 150.00);
		healthyFats.put("Almonds", 200.00);
		
		vegitable.put("Spinach", 100.00);
		vegitable.put("Bell peppers", 120.00);
		vegitable.put("Broccoli", 150.00);
		
		fruits.put("Berries", 200.00);
		fruits.put("Apples", 180.00);
		fruits.put("oranges", 150.00);
		fruits.put("Bananas", 220.00);
	}
	@Override
	public void displayBootCampByCategory(int num) {
		 int count = 1;
		    Map<String, Double> bootCampCatergery;
		    
		    switch (num) {
		        case 1:
		        	bootCampCatergery = bootCamp;
		            break;
		        case 2:
		        	bootCampCatergery = retreats;
		            break;
		        case 3:
		        	bootCampCatergery = accomadation;
		            break;
		        case 4:
		        	bootCampCatergery = leanProteins;
		            break;
		        case 5:
		        	bootCampCatergery = grains;
		            break;
		        case 6:
		        	bootCampCatergery = healthyFats;
		            break;
		        case 7:
		        	bootCampCatergery = vegitable;
		            break;
		        case 8:
		        	bootCampCatergery = fruits;
		            break;
		        default:
		            System.out.println("Invalid input");
		            return;
		    }
		    
		    for (Entry<String, Double> entry : bootCampCatergery.entrySet()) {
		        String key = entry.getKey();
		        Double value = entry.getValue();
		        System.out.println(count + ". " + key + " :- LKR " + value);
		        count++;
		    }   
		
	}

	@Override
	public double getBootCampPrice(int category, int place) {
		Map<String, Double> selectedCategory = null;
	    switch (category) {
	        case 1:
	            selectedCategory = bootCamp;
	            break;
	        case 2:
	            selectedCategory = retreats;
	            break;
	        case 3:
	            selectedCategory = accomadation;
	            break;
	        case 4:
	            selectedCategory = leanProteins;
	            break;
	        case 5:
	            selectedCategory = grains;
	            break;
	        case 6:
	            selectedCategory = healthyFats;
	            break;
	        case 7:
	            selectedCategory = vegitable;
	            break;
	        case 8:
	            selectedCategory = fruits;
	            break;
			default:
				return 0;
	    }
	    if (selectedCategory != null) {
	        String selectedPlace = selectedCategory.keySet().toArray()[place - 1].toString();
	        return selectedCategory.get(selectedPlace);
	    }
	    return 0;
	}

	@Override
	public String getBootCampCategory(int category, int place) {
		// TODO Auto-generated method stub
		return null;
	}

}
