public class Motorcycle extends Vehicle {
	
	final int MOTORCYCLETAX = 0;
	
	public Motorcycle(String licensePlate, int weight) {
		super(licensePlate, weight);
	}
	
	@Override
	public String getLicensePlateNumber() {
		return this.getLicensePlate();
	}
	
	@Override
	public double getCost(boolean rush) {
		return MOTORCYCLETAX;
	}
}
