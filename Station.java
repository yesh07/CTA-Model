// This is the station class that introduces the new int variables red, green, blue, brown, purple, pink, and orange
// This class adds all the different colored lines to the station object, and finally finishing the needed variables to fully represent a CTA Staiton.
package project;

public class Station extends Requirements {
	
	private int red; //new colored line
	private int green; //new colored line
	private int blue;//new colored line
	private int brown;//new colored line
	private int purple;//new colored line
	private int pink;//new colored line
	private int orange;//new colored line

	public Station() { //default constructor
		super();
	}
	
	public Station(String Name, double Latitude, double Longitude, String Description, boolean Wheelchair, //non-default constructor
			int Red, int Green, int Blue, int Brown, int Purple, int Pink, int Orange) {
		
		super(Name, Latitude, Longitude, Description, Wheelchair);
		
		setRed(Red);//mutator method to change variable
		setGreen(Green);// "
		setBlue(Blue);// "
		setBrown(Brown);// "
		setPurple(Purple);// "
		setPink(Pink); //"
		setOrange(Orange);//"
	}
	
	public int getRed() {// accessor method for red.
		return red;
	}
	public int getGreen() {// accessor method for green.
		return green;
	}
	public int getBlue() {// accessor method for blue.
		return blue;
	}
	public int getBrown() {// accessor method for brown.
		return brown;
	}
	public int getPink() {// accessor method for pink.
		return pink;
	}
	public int getPurple() {// accessor method for purple.
		return purple;
	}
	public int getOrange() {// accessor method for orange.
		return orange;
	}
	
	
	public void setRed(int Red) { //mutator method for this  colored variable
		this.red = Red;
	}
	
	public void setGreen(int Green) {//mutator method for this  colored variable
		this.green = Green;
	}
	
	public void setBlue(int Blue) {//mutator method for this  colored variable
		this.blue = Blue;
	}
	
	public void setBrown(int Brown) {//mutator method for this  colored variable
		this.brown = Brown;
	}
	
	public void setPurple(int Purple) {//mutator method for this  colored variable
		this.purple = Purple;
	}
	
	public void setPink(int Pink) {//mutator method for this  colored variable
		this.pink = Pink;
	}
	
	public void setOrange(int Orange) {//mutator method for this  colored variable
		this.orange = Orange;
	}
	
	public boolean equals(Station t) { //equals method for this class for all the new int variables
		if (red != t.getRed()) {
			return false;
		}
		if (blue != t.getBlue()) {
			return false;
		}
		if (green != t.getGreen()) {
			return false;
		}
		if (brown != t.getBrown()) {
			return false;
		}
		if (purple != t.getPurple()) {
			return false;
		}
		if (pink != t.getPink()) {
			return false;
		}
		if (orange != t.getOrange()) {
			return false;
		}
		return true;
	}
	
	public String toStringS() { //toStringS() builds on toStringR().
		return super.toStringR() + ", Red: " + red + ", Green: " + green + ", Blue: " + blue + ", Brown: " + brown
				+ ", Purple: " + purple + ", Pink: " + pink + ", Orange: " + orange;
	}
	
	public String toCSV() { //toString method to write data to a file.
		return name + "," + latitude + "," + longitude + "," + description + "," + wheelchair + "," + red + "," + green + "," + blue
				 + "," + brown + "," + purple + "," + pink + "," + orange;
	}
}