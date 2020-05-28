
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TollPassageRegister implements Iterable<TollPassage> {
	
	ArrayList<TollPassage> tollPassages;
	final LocalTime MORNINGRUSHSTART = LocalTime.parse("06:30");
	final LocalTime MORNINGRUSHSTOP =  LocalTime.parse("08:59");
	final LocalTime AFTERNOONRUSHSTART = LocalTime.parse("14:30");
	final LocalTime AFTERNOONRUSHSTOP = LocalTime.parse("16:29");
	
	
	public TollPassageRegister() {
		tollPassages = new ArrayList<>();
	}
	
	/**
	 * Registers a new passage
	 * @param stationId that the passage happend at
	 * @param licensePlate of the vehicle passing
	 * @return true/false
	 */
	public boolean registerPassage(int stationId, String licensePlate) {
		//Maybe this should be void and throw exception... If I have time left
		
	 	if (stationId == 0 || licensePlate.isEmpty())
	 		 return false;
	 	
		TollPassage passage = new TollPassage(stationId, licensePlate, isRush());
		tollPassages.add(passage);
		return true;
	}
	
	/**
	 * Checks if the time right now is rush or not. This is a good idea for a real world application
	 * But for the purpose of this program and testing I should take a time as input to check if it correct or not
	 * @return true if is rush
	 */
	private boolean isRush() {
		LocalTime timeNow = LocalTime.now();
		return ((timeNow.isAfter(MORNINGRUSHSTART) && timeNow.isBefore(MORNINGRUSHSTOP))
				|| timeNow.isAfter(AFTERNOONRUSHSTART) && timeNow.isBefore(AFTERNOONRUSHSTOP));
	}
	
	/**
	 *
	 * @return list of alle passages
	 */
	public List<TollPassage> getAllPassages() {
		return tollPassages;
	}
	
	/**
	 *
	 * @return the register
	 */
	@Override
	public Iterator<TollPassage> iterator() {
		return tollPassages.iterator();
	}
}
