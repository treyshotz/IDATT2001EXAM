abstract class Vehicle implements Payable {
	
	final String licensePlate;
	final int weight;
	
	/**
	 * Constructor for a vehicle
	 * @param licensePlate
	 * @param weight
	 */
	public Vehicle(String licensePlate, int weight) {
		this.licensePlate = licensePlate;
		this.weight = weight;
	}
	
	/**
	 * Get licenseplate of a vehicle
	 * @return
	 */
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	/**
	 * Get weight of a vehilce
	 * @return
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Get the cost of a passage
	 */
	public abstract double getCost(boolean rush);
}