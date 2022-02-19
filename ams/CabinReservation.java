package ams;

public class CabinReservation extends Reservation {

	private boolean hasFullKitchen;
	private boolean hasLoft;

	/**
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public CabinReservation(String accountNumber, String reservationNumber, String address, String checkIn, String checkOut, double price, boolean hasFullKitchen, boolean hasLoft) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, checkIn, checkOut);
		// Validate parameters 
		Helpers.validateParameters(accountNumber, reservationNumber, address, checkIn.toString(), checkOut.toString());
		this.hasFullKitchen = hasFullKitchen;
		this.hasLoft = hasLoft;
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
	 * Overriding parent's method
	 * @return String in XML format
	 */
	public String toString() {
		return 
			"<cabin>" + 
				super.toString() + 
				"<hasFullKitchen>" + hasFullKitchen + "</hasFullKitchen>" +
				"<hasLoft>" + hasLoft + "</hasLoft>" + 
			"</cabin>";
	}

	/**
	 * @return
	 */
	public String calculatePrice() {
		// TODO implement here
		return "";
	}

}