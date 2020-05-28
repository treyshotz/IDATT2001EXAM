
public class Client {
	public static void main(String[] args) {
		//Creates different vehicles
		String electicPlate = "AA123123";
		Vehicle electric = new ElectricVehicle(electicPlate, 1500);
		String dieselPlate = "BB123123";
		Vehicle diesel = new DieselVehicle(dieselPlate, 25000);
		String petrolPlate = "CC123123";
		PetrolVehicle petrol = new PetrolVehicle(petrolPlate, 2000);
		String motorcyclePlate = "DD12313";
		Motorcycle motorcycle = new Motorcycle(motorcyclePlate, 200);
		
		//Createas a vehicle registers
		VehicleRegister vehicleRegister = VehicleRegister.getInstance();
		
		//Saves all the vehicles to the register
		System.out.println(vehicleRegister.registerVehicle(electric));
		System.out.println(vehicleRegister.registerVehicle(diesel));
		System.out.println(vehicleRegister.registerVehicle(petrol));
		System.out.println(vehicleRegister.registerVehicle(motorcycle));
		
		//Creates two new tollStations
		TollStation farsundToll = new TollStation("Farsund", 123);
		TollStation lyngdalToll = new TollStation("Lyngdal", 321);
		
		//Registers toll passages
		System.out.println(farsundToll.registerTollPassage(electicPlate));
		System.out.println(farsundToll.registerTollPassage(dieselPlate));
		System.out.println(farsundToll.registerTollPassage(motorcyclePlate));
		
		//Print list of passages
		System.out.println(farsundToll.getAllPassages());
		
		//Registers toll passages
		
		System.out.println(lyngdalToll.registerTollPassage(motorcyclePlate));
		System.out.println(lyngdalToll.registerTollPassage(petrolPlate));
		
		//Prints eac passages
		for (TollPassage tollPassage : farsundToll.getTollRegister()) {
			System.out.println(tollPassage);
		}
	}
}
