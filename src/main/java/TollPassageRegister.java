import jdk.vm.ci.meta.Local;

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
	
	public boolean registerPassage(int stationId, String licensePlate) {
		//Maybe this should throw exception....
		
	 	if (stationId == 0 || licensePlate.isEmpty())
	 		 return false;
	 	
		TollPassage passage = new TollPassage(stationId, licensePlate, isRush());
		tollPassages.add(passage);
		return true;
	}
	
	private boolean isRush() {
		LocalTime timeNow = LocalTime.now();
		return ((timeNow.isAfter(MORNINGRUSHSTART) && timeNow.isBefore(MORNINGRUSHSTOP))
				|| timeNow.isAfter(AFTERNOONRUSHSTART) && timeNow.isBefore(AFTERNOONRUSHSTOP));
	}
	
	public List<TollPassage> getAllPassages() {
		return tollPassages;
	}
	
	@Override
	public Iterator<TollPassage> iterator() {
		return tollPassages.iterator();
	}
}
