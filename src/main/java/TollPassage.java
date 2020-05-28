import java.time.LocalDate;
import java.time.LocalDateTime;

public class TollPassage {
	
	private final int stationId;
	private final String licencePlate;
	private final double cost;
	private final int timeOfPassage;
	private final LocalDate dayOfPassage;
	
	/**
	 * Constructor for a passage
	 * Sets time and day to current time and day
	 * @param stationId of station
	 * @param licencePlate of vehicle passing
	 * @param rush if there is rush or not
	 */
	public TollPassage(int stationId, String licencePlate, boolean rush) {
		this.stationId = stationId;
		this.licencePlate = licencePlate;
		this.cost = VehicleRegister.getInstance().findVehicle(licencePlate).getCost(rush);
		this.timeOfPassage = LocalDateTime.now().getHour();
		this.dayOfPassage = LocalDate.now();
	}
	
	/**
	 * @return stationId
	 */
	public int getStationId() {
		return stationId;
	}
	
	/**
	 *	Gets the license plate of the vehicle passing
	 * @return licencePlate
	 */
	public String getLicencePlate() {
		return licencePlate;
	}
	
	/**
	 * Gets the cost of a passage
	 * @return cost
	 */
	public double isCost() {
		return cost;
	}
	
	/**
	 *	Gets the time of passage
	 * @return timeOfPassage
	 */
	public int getTimeOfPassage() {
		return timeOfPassage;
	}
	
	/**
	 * Get the day of passage
	 * @return
	 */
	public LocalDate getDayOfPassage() {
		return dayOfPassage;
	}
	
	@Override
	public String toString() {
		return "TollPassage{" +
				"stationId=" + stationId +
				", licencePlate='" + licencePlate + '\'' +
				", cost=" + cost +
				", timeOfPassage=" + timeOfPassage +
				", dayOfPassage=" + dayOfPassage +
				'}';
	}
}
