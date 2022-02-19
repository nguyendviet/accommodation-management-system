package ams;

/**
 * 
 */
public class HouseReservation extends Reservation {

	private int floorCount;

	/**
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param floorCount
	 */
	public HouseReservation(String accountNumber, String reservationNumber, Address address, String checkIn, String checkOut, String price, int floorCount) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, address, checkIn, checkOut);
		// Validate parameters 
		Helpers.validateParameters(accountNumber, reservationNumber, address.toString(), checkIn, checkOut);
		// Assign parameters's values to attributes
		this.floorCount = floorCount;
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
	 * Overriding parent's method
	 * @returns String in XML format
	 */
	public String toString() {
		return 
			"<house>" + 
				super.toString() + 
				"<floorCount>" + floorCount + "</floorCount>" +
			"</house>";
	}

	/**
	 * @return
	 */
	public String calculatePrice() {
		// TODO implement here
		return "";
	}

}