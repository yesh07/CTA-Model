//	In this class, I introduced the final variable, of type ArrayList<Station>, system to the program.
// The purpose of this class is store the different 'Station's in an array list object, as it makes it easier to work with data.
package project;

import java.util.ArrayList; //importing java ArrayList

public class Map extends Station {

	private ArrayList<Station> system; // data encapsulation using new ArrayList<Station> variable system.
	
	
	public Map() { //default constructor for variable system
		system = new ArrayList<Station>();
	}
	
	public Map(Station[] stations) { //non-default constructor for the variable system. Adds stations by cycling through them.
		system = new ArrayList<Station>(stations.length);
		for (Station s : stations) { // for loop to go and add the different Station(s) to the 'system' ArrayList/
			system.add(s); //Add method
		}
	}
	
	
	public void add(Station s) { // adds objects using ArrayList add commands 
		system.add(s);
	}
	
	public void remove(Station s) { //removes objects using ArrayList remove commands
		system.remove(s);
	}
	
	public Station get(int index) { //get index of elements in system ArrayList.
		return system.get(index);
	}
	
	public int size() { // get the size of the ArrayList, i.e. number of elements in an array list.
		return system.size();
	}
	
	public ArrayList<Station> getStation() { //accessor method fo 'system'
		return system;
	}
	
	public void setStation(ArrayList<Station> system) { //mutator method for system
		this.system = system;
	}
	
	public boolean equals(ArrayList<Station> t) { //equalsTo method for this class. Compares system to an ArrayList
		if (system != t) {
			return false;
		}
		return true;
	}
	public String toString() { //toString() uses toStringS() from previous class: Station.
		return toStringS();
	}
	
	
	public ArrayList<Station> searchName(String name) { //searches for Station(s) in an ArrayList, by using its name
		ArrayList<Station> station = new ArrayList<Station>(); // new ArrayList<Station> created
		
		for (Station s : system) // cycles through all the stations in system using a for loop
			if(s.getName().equalsIgnoreCase(name)) {
				station.add(s); //if condition is met, add the station.
			}
			
		return station;
	}
	
	public ArrayList<Station> searchWheelchair(boolean wheelchair) { //searches for Station(s) in an ArrayList, by using its Wheelchair availability.
		ArrayList<Station> station = new ArrayList<Station>(); // creates new ArrayList<Station> station.
		
		for (Station s : system) // loops through all Station(s) in the 'system' to confirm whether is has wheelchair or not
			if(s.hasWheelchair()) {
				station.add(s); // if it does, adds it to the station array list.
			}
		return station;
	}

	public ArrayList<Station> searchCoord(double latitude, double longitude) { //searches for Station(s) in an ArrayList, by using coordinates.
		ArrayList<Station> station = new ArrayList<Station>(); // creates new ArrayList<Station> station.
		for (Station s : system) { //loops through all Station(s) in the 'system' to confirm whether is has  said coordinates or not
			if(s.getLat() == latitude && s.getLong() == longitude) {
				station.add(s); // if yes, adds it to the array list s.
			}
		}
		return station;
	}
	
	public ArrayList<Station> searchLat(double latitude) {  // same method as the above two but for latitude only.
		ArrayList<Station> station = new ArrayList<Station>();
		for (Station s : system) {
			if(s.getLat() == latitude) {
				station.add(s);
			}
		}
		return station;
	}
}