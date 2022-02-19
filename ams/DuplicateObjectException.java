package ams;
import java.util.*;

/**
 * If duplicate account/reservation exists throw unchecked user defined exception
 */
public class DuplicateObjectException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public DuplicateObjectException() {
	}

	/**
	 * 
	 */
	private String accountNumber;

	/**
	 * 
	 */
	private String reservationNumber;

	/**
	 * return "Error adding account: " + accountNumber + " . Account number has already existed.";
	 * return "Error adding reservation: " + reservationNumber + " . Reservation number has already existed.";
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @param account
	 */
	public void DuplicateObjectException(Account account) {
		// TODO implement here
	}

	/**
	 * Overload method if parameter type is different.
	 * @param reservation Overloading
	 */
	public void DuplicateObjectException(Reservation reservation) {
		// TODO implement here
	}

}