package ams;

public class HotelReservation extends Reservation {

	/**
	 * 
	 * @param args 
	 * @param hasKitchenette
	 */
	public HotelReservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String size, String price, String email, boolean hasKitchenette) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, size, price, email, hasKitchenette);
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