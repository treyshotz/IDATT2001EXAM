public class PetrolVehicle extends Vehicle {
	
	final int NORMALPETROLTAX = 17;
	final int RUSHPETROLTAX = 21;
	
	public PetrolVehicle(String licensePlate, int weight) {
		super(licensePlate, weight);

	}
	
	@Override
	public String getLicensePlateNumber() {
		return getLicensePlate();
	}
	
	@Override
	public double getCost(boolean rush) {
		if (rush)
			return RUSHPETROLTAX;
		return NORMALPETROLTAX;
	}
}
