public class DieselVehicle extends Vehicle {
	
	final int NORMALDIESELTAX = 19;
	final int RUSHDIESELTAX = 23;
	
	public DieselVehicle(String licensePlate, int weight) {
		super(licensePlate, weight);
	}
	
	@Override
	public String getLicensePlateNumber() {
		return this.getLicensePlate();
	}
	
	@Override
	public double getCost(boolean rush) {
		if (rush)
			return RUSHDIESELTAX;
		return NORMALDIESELTAX;
	}
	
}
