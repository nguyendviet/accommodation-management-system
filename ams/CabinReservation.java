package ams;

public class CabinReservation extends Reservation {

	/**
	 * @param args 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public CabinReservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String size, String price, String email, boolean hasFullKitchen, boolean hasLoft) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size, price, email, hasFullKitchen, hasLoft);
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