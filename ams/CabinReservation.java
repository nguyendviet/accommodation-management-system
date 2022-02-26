package ams;

public class CabinReservation extends Reservation {

	/**
	 * @param args 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public CabinReservation(String[] args, boolean hasFullKitchen, boolean hasLoft) {
		// Call parent's constructor
		super(args);
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public CabinReservation(String fileName) throws IllegalLoadException {
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