package ams;

public class HotelReservation extends Reservation {

	/**
	 * 
	 * @param args 
	 * @param hasKitchenette
	 */
	public HotelReservation(String accountNumber, String reservationNumber, String reservationType, String address, String checkIn, String checkOut, String size, String email, boolean hasKitchenette) {
		// Call parent's constructor
		super(accountNumber, reservationNumber, reservationType, address, checkIn, checkOut, size, email, hasKitchenette);
	}

	/**
	 * Overloading constructor if load from file
	 * @param accountNumber
	 * @param reservationNumber
	 */
	public HotelReservation(String accountNumber, String reservationNumber) throws IllegalLoadException {
		// Call parent's constructor
		super(accountNumber, reservationNumber);
	}

	/**
	 * @return
	 */
	public String calculatePrice() {
		int price = 120;
		price *= Integer.parseInt(this.calculateNights());
		price += 50;
		if (Integer.parseInt(this.getSize()) > 900) {
			price += 15;
		}
		if (this.getKitchenette()) {
			price += 10;
		}
		return Integer.toString(price);
	}

}