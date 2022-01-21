
import java.util.*;

/**
 * 
 */
public class CabinReservation extends Reservation {

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
	 * @param hasFullKitchen 
	 * @param hasLoft
	 */
	public CabinReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, boolean hasFullKitchen, boolean hasLoft) {
		// TODO implement here
		super(accountNumber, reservationNumber, checkIn, checkOut);
	}

	/**
	 * 
	 */
	public boolean hasFullKitchen;

	/**
	 * 
	 */
	public boolean hasLoft;

	/**
	 * return "<cabin>" + super.toString() + "<hasFullKitchen>" + hasFullKitchen + ... "</cabin>";
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

}