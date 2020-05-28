public class Truck extends Vehicle {
	
	final int NORMALTRUCKTAX = 86;
	final int RUSHTRUCKTAX = 101;
	
	public Truck(String licensePlate, int weight) {
		super(licensePlate, weight);
	}
	
	@Override
	public String getLicensePlateNumber() {
		return this.getLicensePlate();
	}
	
	@Override
	public double getCost(boolean rush) {
		if (rush)
			return RUSHTRUCKTAX;
		return NORMALTRUCKTAX;
	}
	
}
