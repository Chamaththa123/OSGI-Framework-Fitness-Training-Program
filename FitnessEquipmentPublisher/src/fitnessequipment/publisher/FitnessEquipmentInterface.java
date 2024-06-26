package fitnessequipment.publisher;

public interface FitnessEquipmentInterface {

	public void displayEquipmentByCategory(int num);

	public double getEquipmentPrice(int category, int item);

	public String getEquipmentCategory(int category, int item);
}
