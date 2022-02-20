// This is the main client class for my program. It contains the main method.
// It uses methods from all of the other classes in my program to complete the programming tasks
package project;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CTA_TravelApp {
	

	public static void main(String[] args) { // main method. uses all of the methods in a user interface to do tasks.
		boolean done = false;
		Map map = present(); // Checks if a given Station is in map. (more about this method below)
		do { // do/while loop to continue asking for input until loop is broken
		Scanner sc = new Scanner(System.in); // scanner
		userMenu(); 
		String input = sc.nextLine(); // String input from the user
		switch (input) { // applies a switch case on what ever user entered
		case "1":
			map = addStation(sc, map); // add a station method, sets it to the object Map map.
			break;
		case "2":
			map = removeStation(sc, map);  // remove a station method, sets it to the object Map map.
			break;
		case "3":
			map = modifyStation(sc, map); // modify a station method, sets it to the object Map map.
			break;
		case "4":
			search(sc, map, false); // searches for a station using its name
			break;
		case "5":
			closestStation(sc, map, false); // searches for closest station to given coordinates
			break;
		case "6":
			searchReq(sc, map, false); // shows all stations with wheelchair access
			break;
		case "7":
			getRoute(); // (my get route method does not work. Just says "under maintenance")
			break;
		case "8": // done = true to break the do/while loop on the user's discretion, and exit the program
			done = true; 
			System.out.println("Exiting...");
			break;
		}
		System.out.println();
		}while(!done);
		
		writeToFile(map); // writeToFile method to write data to a file.
	}


	public static void userMenu() { // a method that gives the user a menu of options to choose from
		System.out.println("1. Add a Station");
		System.out.println("2. Remove a Station");
		System.out.println("3. Modify a Station");
		System.out.println();
		System.out.println("4. Search Station by name");
		System.out.println("5. Search nearest Station to a location");
		System.out.println("6. Show Stations with wheelchair access");
		System.out.println("7. Create path between two Stations");
		System.out.println();
		System.out.println("8. Exit Application");
		System.out.print("Choose: ");
	}
	
	public static int[] stationNumber(int[] array) { // this is just a test method. I tried using it to get all the lines for a station, but was not able to get the output in the form that I desired
		int[] arr = new int[7];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Is this station on the: "); System.out.println("Red Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); int input1 = sc.nextInt(); int input2 = -1;
		if (input1 == 1) {System.out.print("Enter order number: "); input2 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Green Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); int input3 = sc.nextInt(); int input4 = -1;
		if (input3 == 1) {System.out.print("Enter order number: "); input4 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Blue Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); int input5 = sc.nextInt(); int input6 = -1;
		if (input5 == 1) {System.out.print("Enter order number: "); input6 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Brown Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); int input7 = sc.nextInt(); int input8 = -1;
		if (input7 == 1) {System.out.print("Enter order number: "); input8 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Purple Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: ");int input9 = sc.nextInt(); int input10 = -1;
		if (input9 == 1) {System.out.print("Enter order number: "); input10 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Pink Line?"); System.out.println("1. Yes, 2. No");System.out.print("Choose: "); int input11 = sc.nextInt(); int input12 = -1;
		if (input11 == 1) {System.out.print("Enter order number: "); input12 = sc.nextInt();}
		
		System.out.println("Is this station on the: "); System.out.println("Orange Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); int input13 = sc.nextInt(); int input14 = -1;
		if (input13 == 1) {System.out.print("Enter order number: "); input14 = sc.nextInt();}
		
		array[0] = input2; array[1] = input4; array[2] = input6; array[3] = input8; array[4] = input10;
		array[5] = input12; array[6] = input14;

		System.out.println(Arrays.toString(array));
		return arr;
		
	}	
	
	public static Map addStation(Scanner sc, Map map) { // add a station method, uses type Scanner sc to get input, and Object Map map to add Station(s) to.
		boolean wheelchair = false; 
		System.out.print("Station Name: "); // basic prompting for station name
		String name = sc.nextLine();
		System.out.print("Latitude: "); // " for station Latitude
		while (!sc.hasNextDouble()) {
			System.out.println();
	        System.out.println("That's not a double!"); // reprompt if not the right value type
	        System.out.print("Please try again: ");
	        sc.next();
	    }
		double lat = sc.nextDouble();
		System.out.print("Longitude: "); // " for station Longitude
		while (!sc.hasNextDouble()) {
			System.out.println();
	        System.out.println("That's not a double!");// reprompt if not the right value type
	        System.out.print("Please try again: ");
	        sc.next();
	    }
		double log = sc.nextDouble();
		System.out.println("Type?"); // " for the Type of station
		System.out.println("1. Elevated");
		System.out.println("2. Surface");
		System.out.println("3. Embankment");
		System.out.println("4. Subway");
		System.out.print("Choose: ");
		while (!sc.hasNextInt()) {
			System.out.println();
	        System.out.println("That's not an integer!"); // reprompt if not the right value type
	        System.out.print("Please try again: ");
	        sc.next();
	    }
		int type = sc.nextInt();
		String des = "";
		switch (type) { // adds description type to String variable 'des', based on user input
		case 1: des = "elevated"; break;
		case 2: des = "surface"; break;
		case 3: des = "embankment"; break;
		case 4: des = "subway"; break; 
		}
		System.out.println("Wheelchair?"); // " for wheelchair requirements
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.print("Choose: ");
		while (!sc.hasNextInt()) {
			System.out.println();
	        System.out.println("That's not an integer!"); // reprompt if not the right value type
	        System.out.print("Please try again: ");
	        sc.next();
	    }
		int req = sc.nextInt();
		if (req == 1) {wheelchair = true;} // set to true or false based on user input
		else if (req == 2) {wheelchair = false;}
		
		// Asking the user for input on the colored lines: Does the station have it? if yes, then on which number?
		System.out.println("Is this station on the: "); System.out.println("Red Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();} int input1 = sc.nextInt(); int input2 = -1; if (input1 == 1) {System.out.print("Enter order number: ");  input2 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Green Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input3 = sc.nextInt(); int input4 = -1; if (input3 == 1) {System.out.print("Enter order number: "); input4 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Blue Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input5 = sc.nextInt(); int input6 = -1; if (input5 == 1) {System.out.print("Enter order number: "); input6 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Brown Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input7 = sc.nextInt(); int input8 = -1; if (input7 == 1) {System.out.print("Enter order number: "); input8 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Purple Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: ");while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input9 = sc.nextInt(); int input10 = -1; if (input9 == 1) {System.out.print("Enter order number: "); input10 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Pink Line?"); System.out.println("1. Yes, 2. No");System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input11 = sc.nextInt(); int input12 = -1; if (input11 == 1) {System.out.print("Enter order number: "); input12 = sc.nextInt();}
		System.out.println("Is this station on the: "); System.out.println("Orange Line?"); System.out.println("1. Yes, 2. No"); System.out.print("Choose: "); while (!sc.hasNextInt()) {
			System.out.println(); System.out.println("That's not an integer!"); System.out.print("Please try again: "); sc.next();}int input13 = sc.nextInt(); int input14 = -1; if (input13 == 1) {System.out.print("Enter order number: "); input14 = sc.nextInt();}
		Station s = new Station(name, lat, log, des, wheelchair, input2, input4, input6, input8, input10, input12, input14);

		map.add(s); // adds the Station s to the Object Map map
		
		System.out.println(s.toStringS()); // prints the added station to the console, for viewing purposes
		return map;
	}
	

	public static Map present() { // reads the file containing Station(s) and makes a new Map map of all the stations.
		Map map = new Map();
		
		try { // try/catch implementation to block any unnecessary exception errors
			File file = new File("src/project/CTAStops.csv"); // file path
			Scanner input = new Scanner(file);
			
			while(input.hasNextLine()) {
				// the procedure reads the file, by skipping the commas.
				// It stores the values in the Station s by parsing the String values from the file, and changing it to the appropriate type.
				String line = input.nextLine(); 
				String[] values = line.split(",");
				try {
					Station s = new Station( values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), values[3], Boolean.parseBoolean(values[4]), 
							Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]), 
							Integer.parseInt(values[10]), Integer.parseInt((values[11])) );
							
							map.add(s);
							
				}catch(Exception e) { // catch exception
			}
		}
			input.close();
	}catch(FileNotFoundException f) { // catch exception
		
	} catch(Exception e) { // catch exception
		System.out.println("Error reading...");
		}
		
		return map;	
	}
	
//	public static Station searchStation(Scanner input, Map map, boolean x) { // gets user input, stores data in a Map map
//		
//		System.out.print("Station name: "); // prompts for station name
//		String name = input.nextLine();
//		
//		ArrayList<Station> outcome = map.searchName(name); // uses the searchName method to get that specific Station s, and store it in new ArrayList<Station> outcome
//		if (outcome.size() == 0) {
//			System.out.println("No station found with name '" + name + "'."); // exception handling
//			return null;
//		} else if (outcome.size() == 1) {
//			if(!x) {
//				System.out.println(outcome.get(0).toString()); // if no error, prints out the Station in readable form
//			}
//			return outcome.get(0);
//		}
//		
		// the below setup is to take care of instances where there are multiple stations with same name.
		// allows the user to select which one they specifically mean.
//		if (!x) {
//			for (Station s : outcome) {
//				System.out.println(s.toString());
//			}
//			
//			return null;
//		}
//		
//		System.out.println();
//		for (int i=0; i<outcome.size(); i++) {
//			System.out.println((i+1) + ". " + outcome.get(i).toString());
//			
//		}
//		
//		return map;
//	}
	
	public static void writeToFile(Map map) { // simple writing to file method
		try {
			FileWriter storage = new FileWriter("src/project/CTAStops.csv"); // file writer to file path
			int size = map.size();
			for (int i=0; i<size; i++) {
				storage.write(map.get(i).toCSV());
				storage.write("\n");
			}
			
			storage.close();
		} catch (Exception e) { // exception handling
			System.out.println("File corrupted, please get data in file again...");
		}
	}
	
	public static Station search(Scanner input, Map map, boolean select) {   //method to search station by station name. Gets user input, stores data in a Map map
		System.out.print("Station Name: ");
		String name = input.nextLine(); // prompts for station name
		
		ArrayList<Station> outcome = map.searchName(name);  // uses the searchName method to get that specific Station s, and store it in new ArrayList<Station> outcome
		if (outcome.size() == 0) { 
			System.out.println("No station found with name '" + name + "'."); // exception handling
			return null; 
		} else if (outcome.size() == 1) {
			if (!select) {
				System.out.println(outcome.get(0).toStringS()); // if no error, prints out the Station in readable form
			}
			return outcome.get(0);
		}
		System.out.println();
		System.out.println("A number represents the position it is on the line");
		System.out.println("A '-1' means that it is not on that line");
		System.out.println();
		
		// the below setup is to take care of instances where there are multiple stations with same name.
		// allows the user to select which one they specifically mean.
		if (!select) {
			for (Station s : outcome) {
				System.out.println(s.toStringS()); // if no error, prints out the Station in readable form
			}
			return null;
		}
		
		System.out.println();
		for (int i=0; i<outcome.size(); i++) {
			System.out.println((i+1) + ". " + outcome.get(i).toStringS());  // if no error, prints out the Station in readable form
		}
		
		System.out.print("Choice: ");
		String choice = input.nextLine();
		int b = 0;
		try {
			b = Integer.parseInt(choice);
		} catch (Exception e) {
			System.out.println("'" + choice + "' is not a valid option."); // exception handling
			return null;
		}
		
		if (b <= 0 || b > outcome.size()) {
			System.out.println("'" + choice + "' is not a valid choice."); // exception handling
			return null;
		}
		
		return outcome.get(b-1);
	}
	
	public static Map removeStation(Scanner input, Map map) { //remove a station
		Station s = search(input, map, true); // uses the search method to check if the given station name is in Map map
		
		//if no, returns Map map
		if (s == null) {
			return map;
		}
		
		// else removes the Station s
		map.remove(s);
		
		return map;
	}
	
	public static Station searchReq(Scanner input, Map map, boolean select) {  //method to search station by station requirement. Gets user input, stores data in a Map map
		boolean name = true;
		
		ArrayList<Station> outcome = map.searchWheelchair(name); // uses the searchWheelchair method to get all Station s with that have wheelchair access, and store it in new ArrayList<Station> outcome
		if (outcome.size() == 0) {
			System.out.println("No station found with name '" + name + "'."); // exception handling
			return null;
		} else if (outcome.size() == 1) {
			if (!select) {
				System.out.println(outcome.get(0).toStringS()); // if no error, prints out in desired form
			}
			return outcome.get(0);
		}
		System.out.println();
		System.out.println("A number represents the position it is on the line");
		System.out.println("A '-1' means that it is not on that line");
		System.out.println();
		
		if (!select) {
			for (Station s : outcome) {
				System.out.println(s.toStringS()); // if no error, prints out in desired form
			}
			return null;
		}
		return outcome.get(0);
	}
	
	public static Station closestStation(Scanner input, Map map, boolean select) { // method to determine the closest station to given coordinates
		System.out.print("Latitude: "); //prompts for latitude 
		while (!input.hasNextDouble()) { 
			System.out.println();
	        System.out.println("That's not a double!"); // reprompt until correct value is entered
	        System.out.print("Please try again: ");
	        input.next();
	    }
		double user_lat = input.nextDouble();
		System.out.print("Longitude: "); //prompts for latitude 
		while (!input.hasNextDouble()) {
			System.out.println();
	        System.out.println("That's not an double!");  // reprompt until correct value is entered
	        System.out.print("Please try again: ");
	        input.next();
	    }
		double user_log = input.nextDouble();
		
		double temp = 0; // create double type variables for later use
		double temp2 = 999999999;
		double finalLat = 0;
		double finalLong = 0;
		
		int x1 = 0; // create integer type variables for later use
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		double distance = Math.hypot(x1-x2, y1-y2); // Math.hypot to get hypotenuse i.e. distance between two points

		//double for loop to get the closest latitude and longitude values to user entered coordinates
			for(int i=0; i<map.size();i++) { 
				double lat = map.get(i).getLat();
				
				for(int j=0; j<map.size();j++) {
					double log = map.get(j).getLong();
					
					distance = Math.hypot(user_lat-lat, user_log-log);
					temp = distance;
					if (temp2 > temp){
						temp2  = temp;
						finalLat  = lat;
						finalLong = log;
					}
				}
			}
			
			// searches for station with the closest lat value, using the searchLat() method [since we know it is closest, we can use either latitude or longitude]
			ArrayList<Station> results = map.searchLat(finalLat);
				
			System.out.println();
			System.out.println("A number represents the position it is on the line");
			System.out.println("A '-1' means that it is not on that line");
			System.out.println();
			
			System.out.println("Your Coordinates: (" + user_lat + ", " + user_log + ")" ); // prints user coordinates
			System.out.println("Station(s) closest to your location:");
			
				for (Station s : results) {
					System.out.println(s.toStringS()); // closest station
				}
				
			return map;
	}
	

	
	public static Map modifyStation(Scanner input, Map map) { // method to modify an existing station
		Station s = search(input, map, true);
		if (s!= null) {
		System.out.println();                         // Ask user what they want to change
		System.out.println("What to Modify?");
		System.out.println("1. Name");
		System.out.println("2. Latitude");
		System.out.println("3. Longitude");
		System.out.println("4. Description");
		System.out.println("5. Wheelchair Access");
		System.out.print("Choose: ");
		while (!input.hasNextInt()) {
			System.out.println();
	        System.out.println("That's not an integer!"); // reprompt until correct value type entered
	        System.out.print("Please try again: ");
	        input.next();
	    }
		String choice = input.nextLine();
		System.out.println();
		int b = 0;
		switch(choice) {
		case "1": // for modifying name
			System.out.print("Modify to Name: ");
			String name = input.nextLine();
			s.setName(name);
			System.out.println(s.toStringS());
			break;
		case "2": // for modifying latitude
			System.out.print("Modify to Latitude: ");
			while (!input.hasNextInt()) {
				System.out.println();
		        System.out.println("That's not a double!"); // reprompt until correct value type entered
		        System.out.print("Please try again: ");
		        input.next();
		    }
			double lat = input.nextDouble();
			s.setLat(lat);
			System.out.println(s.toStringS());
			break;
		case "3": // for modifying longitude
			System.out.print("Modify to Longitude: ");
			while (!input.hasNextInt()) {
				System.out.println();
		        System.out.println("That's not a double!"); // reprompt until correct value type entered
		        System.out.print("Please try again: ");
		        input.next();
		    }
			double log = input.nextDouble();
			s.setLong(log);
			System.out.println(s.toStringS());
			break;
		case "4": // for modifying description
			System.out.println("Modify to Description: ");
			System.out.println("1. Elevated");
			System.out.println("2. Surface");
			System.out.println("3. Embankment");
			System.out.println("4. Subway");
			System.out.print("Choose: ");
			String des = input.nextLine();
			try {
				b = Integer.parseInt(des);
			} catch (Exception e) {
				System.out.println("'" + des + "' is not a valid option."); //exception handling
				return null;
			}
			switch(des) {
			case "1":
				s.setDesc("elevated"); System.out.println(s.toStringS()); break;
			case "2":
				s.setDesc("surface"); System.out.println(s.toStringS()); break;
			case "3":
				s.setDesc("embankment"); System.out.println(s.toStringS()); break;
			case "4":
				s.setDesc("subway"); System.out.println(s.toStringS()); break;
			}
			break;
		case "5": // for modifying wheelchair access type
			System.out.println("Modify Wheelchair Access to: ");
			System.out.println("1. Yes, 2. No");
			System.out.print("Choose: ");
			String whl = input.nextLine();
			try {
				b = Integer.parseInt(whl);
			} catch (Exception e) {
				System.out.println("'" + whl + "' is not a valid option."); //exception handling
				return null;
			}
			switch(whl) {
			case "1":
				s.setWheelchair(true);
				System.out.println(s.toStringS());
				break;
			case "2":
				s.setWheelchair(false);
				System.out.println(s.toStringS());
				break;
			}
			break;
		}
		
		}
		return map;
	}
	
	public static void getRoute() { // this method of mine does not work. Though to prevent exceptions, I added this to my code.
		System.out.println();
		System.out.println("Sorry, this service is down for maintenance");
		
	}
}


	

	

