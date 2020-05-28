abstract class Vehicle implements Payable {
	
	final String licensePlate;
	final int weight;

	public Vehicle(String licensePlate, int weight) {
		this.licensePlate = licensePlate;
		this.weight = weight;
	}
	
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public abstract double getCost(boolean rush);
}