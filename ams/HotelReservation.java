package ams;

public class HotelReservation extends Reservation {

	private boolean hasKitchenette;

	/**
	 * 
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param hasKitchenette
	 */
	public HotelReservation(String accountNumber, String reservationNumber, Address address, String checkIn, String checkOut, String price, boolean hasKitchenette) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, address, checkIn, checkOut);
		// Validate parameters 
		Helpers.validateParameters(accountNumber, reservationNumber, address.toString(), checkIn, checkOut, price);
		// Assign parameters's values to attributes
		this.hasKitchenette = hasKitchenette;
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
	 * Overriding parent's method
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<hotel>" + 
				super.toString() + 
				"<hasKitchenette>" + hasKitchenette + "</hasKitchenette>" +
			"</hotel>";
	}

	/**
	 * @return
	 */
	public String calculatePrice() {
		// TODO implement here
		return "";
	}

}