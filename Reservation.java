
import java.util.*;

/**
 * Reservation number prefixes: HT = hotel, CB = cabin, SH = house
 */
public abstract class Reservation {

	/**
	 * Validate parameters
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of lodge (address, number of beds, etc.)
	 * Calculate the price based on check in and check out dates and the type of lodge.
	 * @param accountNumber 
	 * @param reservationNumber 
	 * @param checkIn 
	 * @param checkOut
	 */
	public Reservation(String accountNumber, String reservationNumber, Date checkIn, Date checkOut) {
		// TODO implement here
	}

	/**
	 * 
	 */
	public String accountNumber;

	/**
	 * 
	 */
	public String reservationNumber;

	/**
	 * Validate account
	 * Validate reservation number to avoid duplicate
	 * Get details of the account (address,  number of beds, etc.) from the account's details
	 */
	public Address address;

	/**
	 * 
	 */
	public String status = "draft";

	/**
	 * 
	 */
	public Date checkIn;

	/**
	 * 
	 */
	public Date checkOut;

	/**
	 * 
	 */
	public double price;

	/**
	 * @return
	 */
	public abstract String toString();

	/**
	 * @return
	 */
	public abstract double calculatePrice();

	/**
	 * @return
	 */
	public int calculateNights() {
		// TODO implement here
		return 0;
	}

	/**
	 * Update reservation data using passed in parameters
	 * @param checkIn 
	 * @param checkOut 
	 * @param address 
	 * @return
	 */
	public void updateReservation(Date checkIn, Date checkOut, Address address) {
		// TODO implement here
	}

}