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
	
	public boolean registerVehicle(Vehicle vehicle) {
		if (vehicle == null)
			return false;
		return vehicles.add(vehicle);
	}
	
	public Vehicle findVehicle(String licensePlate) {
		return vehicles.stream().filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate)).findFirst().orElse(null);
	}
	
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
