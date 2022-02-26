package ams;

/**
 * 
 */
public class HouseReservation extends Reservation {
	/**
	 * @param args 
	 * @param floorCount
	 */
	public HouseReservation(String[] args, int floorCount) {
		// Call parent's constructor
		super(args, floorCount);
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public HouseReservation(String fileName) throws IllegalLoadException {
		// Call parent's constructor
		super(fileName);
	}

	/**
	 * @return
	 */
	public String calculatePrice() {
		// TODO implement here
		return "";
	}

}