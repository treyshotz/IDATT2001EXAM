import java.time.LocalDate;
import java.time.LocalDateTime;

public class TollPassage {
	
	private final int stationId;
	private final String licencePlate;
	private final boolean cost;
	private final LocalDateTime timeOfPassage;
	private final LocalDate dayOfPassage;
	
	public TollPassage(int stationId, String licencePlate, boolean cost, LocalDateTime timeOfPassage, LocalDate dayOfPassage) {
		this.stationId = stationId;
		this.licencePlate = licencePlate;
		this.cost = cost;
		this.timeOfPassage = timeOfPassage;
		this.dayOfPassage = dayOfPassage;
	}
	
	public int getStationId() {
		return stationId;
	}
	
	public String getLicencePlate() {
		return licencePlate;
	}
	
	public boolean isCost() {
		return cost;
	}
	
	public LocalDateTime getTimeOfPassage() {
		return timeOfPassage;
	}
	
	public LocalDate getDayOfPassage() {
		return dayOfPassage;
	}
}
