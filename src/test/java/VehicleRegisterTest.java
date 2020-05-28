import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Test for VehicleRegister
 */
public class VehicleRegisterTest {
	
	VehicleRegister vehicleRegister;
	ElectricVehicle electricVehicle;
	String electricLicensePlate;
	Vehicle petrolVehicle;
	Truck truck;
	Vehicle motorcycle;
	
	/**
	 * Sets up testing data to all the tests
	 * Because of the singleton design pattern i chose to reset the instance before every test, so that I don't depend on objects that could be modified previous test
	 */
	@BeforeEach
	public void setUp() throws NoSuchFieldException, IllegalAccessException {
		Field instance = VehicleRegister.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
		vehicleRegister = VehicleRegister.getInstance();
		electricLicensePlate = "AB123123";
		electricVehicle = new ElectricVehicle(electricLicensePlate, 1500);
		truck = new Truck("CD123123", 4000);
		petrolVehicle = new PetrolVehicle("EF123123", 2000);
		motorcycle = new Motorcycle("GH123123",200);
	}
	
	/**
	 * The test tries to register several different vehicles to make sure the register handles all the different kinds
	 */
	@Test
	public void registerVehicleWithValidInput() {
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertTrue(vehicleRegister.registerVehicle(petrolVehicle));
		assertTrue(vehicleRegister.registerVehicle(motorcycle));
	}
	
	/**
	 * The test tries to register two valid vehicles, making sure that the register works
	 * It finally tries to create a vehicle with illegal input and is therefore expected to return false
	 */
	@Test
	public void registerVehicleWithInvalidInput() {
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertFalse(vehicleRegister.registerVehicle(null));
	}
	
	/**
	 * The test tries to register two vehicles, making sure that there actually exists vehicles in the register
	 * It finally tries to find a vehicle by a valid license plate
	 */
	@Test
	public void findVehicleWithValidInput() {
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertEquals(electricVehicle, vehicleRegister.findVehicle(electricLicensePlate));
	}
	
	/**
	 * The test tries to register two vehicles, making sure that there actually exists vehicles in the register
	 * It finally tries to find a vehicle by a licenseplate that does not exist. The return should therefore be null
	 */
	@Test
	public void findVehicleWithInvalidInput() {
		String invalidLicensePlate = "AA123123";
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertEquals(null, vehicleRegister.findVehicle(invalidLicensePlate));
	}
	
	/**
	 * The test registers several vehicles, making sure that the register actually has vehicles registered
	 * It afterwards tries to find all the vehicle with a weight above a testWeight, 1999kg, and checks that amount returned is expected
	 */
	@Test
	public void findVehicleWithWeightWithValidInput() {
		int testWeight = 1999;
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertTrue(vehicleRegister.registerVehicle(petrolVehicle));
		assertTrue(vehicleRegister.registerVehicle(motorcycle));
		ArrayList<Vehicle> foundVehicles = vehicleRegister.findVehicleWithWeight(testWeight);
		assertEquals(2,foundVehicles.size());
	}
	
	/**
	 * The test registers several vehicles, making sure that the register actually has vehicles registered
	 * The test then tries to find all vehicles with a invalid weight, -1. This should throw IllegalArgument.
	 */
	@Test
	public void findVehicleWithWeightInvalidInput() {
		int testWeight = -1;
		assertTrue(vehicleRegister.registerVehicle(electricVehicle));
		assertTrue(vehicleRegister.registerVehicle(truck));
		assertTrue(vehicleRegister.registerVehicle(petrolVehicle));
		assertTrue(vehicleRegister.registerVehicle(motorcycle));
		try {
			vehicleRegister.findVehicleWithWeight(testWeight);
			fail();
		} catch (IllegalArgumentException e) {
			//The method should throw a new IllegalArgumentException as it is impossible to have a weight less than 0
		}
	}
}