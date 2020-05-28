import java.util.List;

public class TollStation {

	private final String stationName;
	private final int stationId;
	private final TollPassageRegister passages;
	
	/**
	 * Constructor for TollStation
	 * @param stationName
	 * @param stationId
	 */
	public TollStation(String stationName, int stationId) {
		this.stationName = stationName;
		this.stationId = stationId;
		this.passages = new TollPassageRegister();
	}
	
	/**
	 * @return stationID
	 */
	public int getStationId() {
		return stationId;
	}
	
	/**
	 * Not really necessary as i have the iterator in Tollregister but I threw it in anyways
	 * @return list of passages
	 */
	public List<TollPassage> getAllPassages() {
		return passages.getAllPassages();
	}
	
	/**
	 * Returns the Tollregister by using the iterator implemented in the register class
	 * @return the register with passages
	 */
	public TollPassageRegister getTollRegister() {
		return passages;
	}
	
	/**
	 * Registers a new passage
	 * @param licensePlate to registrate
	 * @return true/false
	 */
	public boolean registerTollPassage(String licensePlate) {
		return passages.registerPassage(getStationId(), licensePlate);
	}
}
