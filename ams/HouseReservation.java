package ams;

/**
 * 
 */
public class HouseReservation extends Reservation {
	/**
	 * @param args 
	 * @param floorCount
	 */
	public HouseReservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String size, String email, int floorCount) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size, email, floorCount);
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
		int price = 120;
		price *= Integer.parseInt(this.calculateNights());
		if (Integer.parseInt(this.getSize()) > 900) {
			price += 15;
		}
		return Integer.toString(price);
	}

}