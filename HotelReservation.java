
import java.util.*;

/**
 * 
 */
public class HotelReservation extends Reservation {

	/**
	 * Call parent's constructor
	 * Validate parameters 
	 * Assign parameters's values to attributes
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param address 
	 * @param checkIn 
	 * @param checkOut 
	 * @param price 
	 * @param hasKitchenette
	 */
	public HotelReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, boolean hasKitchenette) {
		super(accountNumber, reservationNumber, checkIn, checkOut);
	}

	/**
	 * Call parent's constructor
	 * Validate the path to the file. If file not found, throw IllegalLoadException.
	 * Load all the reservation attributes to the object’s attributes.
	 * Assign parameters's values to attributes.
	 * @param fileName
	 */
	public HotelReservation(String fileName) throws IllegalLoadException {
		super(fileName);
	}

	/**
	 * 
	 */
	private boolean hasKitchenette;

	/**
	 * Overriding parent's method
	 * return "<hotel>" + super.toString() + "<hasKitchenette>" + hasKitchenette + "</hotel>";
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public double calculatePrice() {
		// TODO implement here
		return 0.0d;
	}

	

	/**
	 * @return
	 */
	public Hotel getHotelInfo() {
		// TODO implement here
		return null;
	}

}