import java.util.ArrayList;
import java.util.stream.Collectors;

public final class VehicleRegister {
	
	private final ArrayList<Vehicle> vehicles;
	private static VehicleRegister instance;
	
	//Made it package private for easier testing... Should be private by the singleton design principle
	private VehicleRegister() {
		vehicles = new ArrayList<>();
	}
	
	public static VehicleRegister getInstance() {
		if (instance == null) {
			instance = new VehicleRegister();
		}
		return instance;
	}
	
	/**
	 * Registers a new vehicle
	 * I chose to have a vehicle as input as there is way of telling wether the vehicle is electric etc...
	 * @param vehicle that will be registered
	 * @return true if the creation was a success
	 */
	public boolean registerVehicle(Vehicle vehicle) {
		//Maybe I should make this void and throw exception instead, if i got the time
		if (vehicle == null)
			return false;
		return vehicles.add(vehicle);
	}
	
	/**
	 * Uses a stream to find a vehicle with matching licenseplate
	 * @param licensePlate to search for
	 * @return vehicle if found, null else wise
	 */
	public Vehicle findVehicle(String licensePlate) {
		return vehicles.stream().filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate)).findFirst().orElse(null);
	}
	
	/**
	 * Finds all vehicles that have a greater weight than input
	 * @param weight for comparing
	 * @return list of vehicles heavier than input
	 */
	public ArrayList<Vehicle> findVehicleWithWeight(int weight) {
		if (weight < 0) {
			throw new IllegalArgumentException("Weight can't be negative");
		}
		return vehicles.stream().filter(vehicle -> vehicle.getWeight() > weight).collect(Collectors.toCollection(ArrayList::new));
	}
	
	@Override
	public String toString() {
		return "VehicleRegister{" +
				"vehicles=" + vehicles +
				'}';
	}
}
