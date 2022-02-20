// This is the Requirements class that introduces the new boolean variable wheelchair.
// It extends on the Travel class, and adds another variable to the constructor.
// The wheelchair variable is boolean, so the stations can either have or not have wheelchair access (true or false)
package project;

public class Requirements extends Travel {
	
	protected boolean wheelchair; // New boolean variable wheelchair

	public Requirements() { //default constructor
		super();
	}
	
	//non-default constructor
	public Requirements(String Name, double Latitude, double Longitude, String Description, boolean Wheelchair) {
		super(Name, Latitude, Longitude, Description);
		
		setWheelchair(Wheelchair); //mutator method to change variable
	}
	
	public boolean hasWheelchair() { //accessor method boolean wheelchair
		return wheelchair;
	}
	
	public void setWheelchair(boolean Wheelchair) { //mutator method for wheelchair
		this.wheelchair = Wheelchair;
	}
	
	public boolean equals(Requirements t) { //equals method for this class, compares variable wheelchair
		if (wheelchair != t.hasWheelchair()) {
			return false;
		}
		return true;
	}
		
	public String toStringR() { //toStringR() building up on toString() from Travel, to accomodate wheelchair
		return super.toStringT() + ", Wheelchair Access: " + wheelchair;
	}
	
	public String trip() {
		return toStringR();
	}
	
}


