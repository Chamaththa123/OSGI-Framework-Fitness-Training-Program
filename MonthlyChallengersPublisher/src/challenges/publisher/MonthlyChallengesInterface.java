package challenges.publisher;

public interface MonthlyChallengesInterface {

    void displayChallengesByCategory(int num);

    double getChallengePrice(int category, int challenge);

    String getChallengeCategory(int category, int challenge);
}
