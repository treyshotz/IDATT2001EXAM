public class ElectricVehicle extends Vehicle{
	
	final int NORMALELECTRICTAX = 4;
	final int RUSHELECTRICTAX = 8;
	
	public ElectricVehicle(String licensePlate, int weight) {
		super(licensePlate, weight);

	}
	
	@Override
	public String getLicensePlateNumber() {
		return this.getLicensePlate();
	}
	
	@Override
	public double getCost(boolean rush) {
		if (rush)
			return RUSHELECTRICTAX;
		return NORMALELECTRICTAX;
	}
	
}
