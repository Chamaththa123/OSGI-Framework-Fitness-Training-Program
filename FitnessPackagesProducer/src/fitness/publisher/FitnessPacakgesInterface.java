package fitness.publisher;

public interface FitnessPacakgesInterface {
	
	void displayFitnessProgramsByCategory(int category);

    // Get price of the fitness program based on category and program number
    double getProgramPrice(int category, int program);

    // Get name of the fitness program based on category and program number
    String getProgramCategory(int category, int program);

}
