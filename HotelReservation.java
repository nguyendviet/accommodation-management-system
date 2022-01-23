
import java.util.*;

/**
 * 
 */
public class HotelReservation extends Reservation {

	/**
	 * Default constructor
	 */
	public HotelReservation() {
	}

	/**
	 * 
	 */
	private boolean hasKitchenette;

	/**
	 * Overloading parent's method
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
	public void HotelReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, boolean hasKitchenette) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public Hotel getHotelInfo() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public abstract double calculatePrice();

}