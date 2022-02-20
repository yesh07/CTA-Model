// This class is the super class that starts it all. It contains the elementary variables that create the foundations for the rest of my program.
// The purpose of this class is to set the basis and pillars of my program, on which the rest of the classes will rely.
// Four variables are being introduced in this class: name, description, latitude, and longitude.
package project;

public abstract class Travel {

	protected String name;
	protected String description;
	protected double latitude;
	protected double longitude;
	
	public Travel() { //default constructor
		super();
	}
	
	public Travel(String name, double latitude, double longitude, String description) { //non-default constructor
		this();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		
		setName(name); // mutator to change the variable
		setLat(latitude); // "
		setLong(longitude); // "
		setDesc(description); // "
	}
	
	public String getName() { //accessor method for the String variable name
		return name;
	}
	
	public double getLat() { //accessor method for the double variable latitude
		return latitude;
	}
	
	public double getLong() { //accessor method for the double variable longitude
		return longitude;
	}
	
	public String getDesc() { //accessor method for the String variable description 
		return description;
	}
	
	public void setName(String name) { //mutator method for the String variable name
		this.name = name;
	}
	
	public void setLat(double latitude) {//mutator method for the double variable latitude
		this.latitude = latitude;
	}
	
	public void setLong(double longitude) {//mutator method for the double variable longitude
		this.longitude = longitude;
	}
	
	public void setDesc(String description) {//mutator method for the String variable description
		this.description = description;
	}
	
	public boolean equals(Travel t) { // equals method for this class, comparing all four introduced variables
		if (name != t.getName()) {
			return false;
		} else if (latitude != t.getLat()){
			return false;
		} else if (longitude != t.getLong()) {
			return false;
		} else if (description != t.getDesc()) {
			return false;
		}
		return true;
	}
	
	public String toStringT() { //toString method, on which the later toStrings() will build upon.
		return "Station Name: " + name + ", Coordinates: (" + latitude + ", " + longitude +"), Type: " + description;
	}
	
	public abstract String trip();
}
