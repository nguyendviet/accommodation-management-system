package ams;

public class HotelReservation extends Reservation {

	/**
	 * 
	 * @param args 
	 * @param hasKitchenette
	 */
	public HotelReservation(String[] args, boolean hasKitchenette) {
		// Call parent's constructor
		super(args);
	}

	/**
	 * Overloading constructor if load from file
	 * @param fileName
	 */
	public HotelReservation(String fileName) throws IllegalLoadException {
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