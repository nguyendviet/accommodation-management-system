package ams;
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
		super(accountNumber, reservationNumber, checkIn, checkOut);
	}

	/**
	 * Call parent's constructor
	 * Validate the path to the file. If file not found, throw IllegalLoadException.
	 * Load all the reservation attributes to the object’s attributes.
	 * Assign parameters's values to attributes
	 * @param fileName
	 */
	public CabinReservation(String fileName) throws IllegalLoadException {
		super(fileName);
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

}