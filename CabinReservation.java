
import java.util.*;

/**
 * 
 */
public class CabinReservation extends Reservation {

	/**
	 * Default constructor
	 */
	public CabinReservation() {
	}

	/**
	 * 
	 */
	private boolean hasFullKitchen;

	/**
	 * 
	 */
	private boolean hasLoft;

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
	public void CabinReservation(String accountNumber, String reservationNumber, String address, Date checkIn, Date checkOut, double price, boolean hasFullKitchen, boolean hasLoft) {
		// TODO implement here
	}

	/**
	 * Overriding parent's method
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

	/**
	 * @return
	 */
	public Cabin getCabinInfo() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public abstract double calculatePrice();

}