public class TollStation {

	private final int stationId;
	private final int stationRingId;
	
	public TollStation(int stationId, int stationRingId) {
		this.stationId = stationId;
		this.stationRingId = stationRingId;
	}
	
	public int getStationId() {
		return stationId;
	}
	
	public int getStationRingId() {
		return stationRingId;
	}
}
