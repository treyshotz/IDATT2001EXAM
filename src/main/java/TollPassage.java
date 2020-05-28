import java.time.LocalDate;
import java.time.LocalDateTime;

public class TollPassage {
	
	private final int stationId;
	private final String licencePlate;
	private final double cost;
	private final int timeOfPassage;
	private final LocalDate dayOfPassage;
	
	public TollPassage(int stationId, String licencePlate, boolean rush) {
		this.stationId = stationId;
		this.licencePlate = licencePlate;
		this.cost = VehicleRegister.getInstance().findVehicle(licencePlate).getCost(rush);
		this.timeOfPassage = LocalDateTime.now().getHour();
		this.dayOfPassage = LocalDate.now();
	}
	
	public int getStationId() {
		return stationId;
	}
	
	public String getLicencePlate() {
		return licencePlate;
	}
	
	public double isCost() {
		return cost;
	}
	
	public int getTimeOfPassage() {
		return timeOfPassage;
	}
	
	public LocalDate getDayOfPassage() {
		return dayOfPassage;
	}
}
