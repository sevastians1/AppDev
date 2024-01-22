public class Vehicle {
	// TODO You'll need to fill in this entire file
	public Vehicle(VehicleType type, int row,int col, boolean isVertical, int length) {
		this.type=type;
		this.Location=new Location(row, col);
		this.isVertical=isVertical;
		this.length=length;
	}
	/**
	 * @return the type associated with this particular vehicle
	 */
	private VehicleType type;
	private Location Location;
	private boolean isVertical;
	private int length;
	//setters and getters for all
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location Location) {
		this.Location=Location;
	}
	public boolean isVertical() {
		return isVertical;
	}

	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	
	//fix this
	public VehicleType getVehicleType() {
		// TODO change this implementation so that you return the vehicles
		// actual type, which should be stored in a variable
		return type;
	}
	public void move(int numSpaces) {
		if(isVertical) {
			Location.setRow(Location.getCol()+numSpaces);
		}
		else {
			Location.setRow(Location.getRow()+numSpaces);
		}
		
	}
	public Location potentialMove(int numSpaces) {
		Location newLocation= new Location(Location.getRow(),Location.getCol());
		if(isVertical) {
			newLocation.setRow(newLocation.getRow()+numSpaces);
		}
		else {
			newLocation.setCol(newLocation.getCol()+numSpaces);
		}
		return newLocation;
	}
	
	public Location[] locationsOn() {
		Location[] allLocations= new Location[length];
		for(int i=0; i<length; i++) {
			Location newLocation=new Location(Location.getRow(),Location.getCol());
			int currentSpace=i;
			if(isVertical) {
				newLocation.setRow(newLocation.getRow()+currentSpace);
			}
			else {
				newLocation.setCol(newLocation.getCol()+currentSpace);
			}
			allLocations[i]=newLocation;
		}
		return allLocations;
		
	}

	public Location[] locationsPath(int spacesToMove) {
		Location[] allLocationsIfMove= new Location[(Math.abs(spacesToMove))];
		for(int i=0; i<Math.abs(spacesToMove); i++) {
			Location newLocation=new Location(Location.getRow(),Location.getCol());
			int currentSpace=i;
			if(spacesToMove>0) {
			currentSpace=i+length;
			}
			else {
				currentSpace=i+spacesToMove;
			}
			if(isVertical) {
				newLocation.setRow(newLocation.getRow()+currentSpace);
			}
			else {
				newLocation.setCol(newLocation.getCol()+currentSpace);
			}
			allLocationsIfMove[i]=newLocation;
		}
		return allLocationsIfMove;
	}
	
	public String toString() {
		return "Vehicle is "+ type + "Location Column: " +Location.getCol()+" Row: "+Location.getRow()+
				"\n" + "With a length of" + length+ " and is " +((isVertical)?"vertical ":"NOT vertical ");
	}
	public static void printLocations(Location[] arr) {
		for(int i = 0; i < arr.length; i++) {
		System.out.print("r" + arr[i].getRow() + "c" + arr[i].getCol() + "; ");
		}
		System.out.println();
		}
	public static void main(String[] args){
		Vehicle someTruck = new Vehicle(VehicleType.TRUCK, 1, 1, true, 3);
		Vehicle someAuto = new Vehicle(VehicleType.AUTO, 2, 2, false, 2);
		System.out.println("This next test is for locationsOn: ");
		System.out.println("vert truck at r1c1 should give you r1c1; r2c1; r3c1"+
		"as the locations its on top of... does it?");
		printLocations(someTruck.locationsOn());
		System.out.println("horiz auto at r2c2 should give you r2c2; r2c3"+
		"as the locations its on top of... does it?");
		printLocations(someAuto.locationsOn());
		System.out.println("if we were to move horiz auto -2 it should give"+
		"you at least r2c0; r2c1... does it?");
		printLocations(someAuto.locationsPath(-2));
		}
		
		
	
	
	
}





