package ams;

public class CabinReservation extends Reservation {

	/**
	 * @param args 
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public CabinReservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String beds, String bedrooms, String bathrooms, String size, String email, boolean hasFullKitchen, boolean hasLoft) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, beds, bedrooms, bathrooms, size, email, hasFullKitchen, hasLoft);
	}

	/**
	 * Overloading constructor if load from file
	 * @param accountNumber
	 * @param reservationNumber
	 */
	public CabinReservation(String accountNumber, String reservationNumber) throws IllegalLoadException {
		// Call parent's constructor
		super(accountNumber, reservationNumber);
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
		if (this.getFullKitchen()) {
			price += 20;
		}
		price += Integer.parseInt(getBathrooms())*5;
		return Integer.toString(price);
	}

}